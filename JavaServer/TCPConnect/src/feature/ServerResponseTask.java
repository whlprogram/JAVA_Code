package feature;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import protocol.*;
import util.DecodeUtil;
import util.SerializeUtil;
import util.SocketUtil;

/**
 * Created by Yang on 16/11/16.
 */
public class ServerResponseTask implements Runnable {//��������Ӧ����

    private ReciveTask reciveTask;
    private SendTask sendTask;
    private Socket socket;
    private ResponseCallback tBack;

    private volatile ConcurrentLinkedQueue<BasicProtocol> dataQueue = new ConcurrentLinkedQueue<>();
    private static ConcurrentHashMap<String, Socket> onLineClient = new ConcurrentHashMap<>();

    private String userIP;
    
    private String clientId;
    public String getUserIP() {
        return userIP;
    }
    
    

    public ServerResponseTask(Socket socket, ResponseCallback tBack) {
        this.socket = socket;
        this.tBack = tBack;
        this.userIP = socket.getInetAddress().getHostAddress();
        System.out.println("�û�IP��ַ��" + userIP);     
    }

    @Override
    public void run() {
        try {
            //���������߳�
            reciveTask = new ReciveTask();
            reciveTask.inputStream = new DataInputStream(socket.getInputStream());
            reciveTask.start();

            //���������߳�
            sendTask = new SendTask();
            sendTask.outputStream = new DataOutputStream(socket.getOutputStream());
            sendTask.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (reciveTask != null) {
            reciveTask.isCancle = true;
            reciveTask.interrupt();
            if (reciveTask.inputStream != null) {
                SocketUtil.closeInputStream(reciveTask.inputStream);
                reciveTask.inputStream = null;
            }
            reciveTask = null;
        }

        if (sendTask != null) {
            sendTask.isCancle = true;
            sendTask.interrupt();
            if (sendTask.outputStream != null) {
                synchronized (sendTask.outputStream) {//��ֹд����ʱֹͣ��д����ͣ
                    sendTask.outputStream = null;
                }
            }
            sendTask = null;
        }
        
        if(!onLineClient.isEmpty()&&clientId!=null&&clientId!=null){
        	 onLineClient.remove(clientId);
        }
    }

    public void addMessage(BasicProtocol data) {
        if (!isConnected()) {
            return;
        }

        dataQueue.offer(data);
        toNotifyAll(dataQueue);//���������������ݣ����ѷ����߳�
    }

    public Socket getConnectdClient(int clientID) {
        return onLineClient.get(clientID);
    }

    /**
     * ��ӡ�Ѿ����ӵĿͻ���
     */
    public static void printAllClient() {
        if (onLineClient == null) {
            return;
        }
        Iterator<String> inter = onLineClient.keySet().iterator();
        System.out.println("-----------------------------------------");
        if(onLineClient.isEmpty()){
        	System.out.println("��ǰû�����ߵĿͻ���.");
        }else {
        	 while (inter.hasNext()) {
             	String id = inter.next();
                 System.out.println("client{clientId: "+id+", clientIp: "+onLineClient.get(id).getInetAddress().getHostAddress()+"} is online...");    
             }
		}
        System.out.println("-----------------------------------------");
    }

    public void toWaitAll(Object o) {
        synchronized (o) {
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void toNotifyAll(Object obj) {
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    private boolean isConnected() {
        if (socket.isClosed() || !socket.isConnected()) {
            onLineClient.remove(clientId);
            ServerResponseTask.this.stop();
            System.out.println("socket closed...");
            return false;
        }
        return true;
    }

    public class ReciveTask extends Thread {

        private DataInputStream inputStream;
        private boolean isCancle;

        @Override
        public void run() {
            while (!isCancle) {
                if (!isConnected()) {
                    isCancle = true;
                    break;
                }

                BasicProtocol clientData = SocketUtil.readFromStream(inputStream);
                
                if (clientData != null) {
                    if (clientData.getProtocolType() == 0) {
                    	DataProtocol dataProtocol = (DataProtocol)clientData;
                        System.out.println("dtype: " + ((DataProtocol) clientData).getDtype() + ", pattion: " + ((DataProtocol) clientData).getPattion() + 
                        		", msgId: " + ((DataProtocol) clientData).getMsgId() + "�� clientId: "+((DataProtocol) clientData).getClientId() +", data: " + ((DataProtocol) clientData).getData());
//                        byte[] bytes = dataProtocol.genContentData();
//                        System.out.println(DecodeUtil.binary(bytes, 2));
                        clientId = ((DataProtocol) clientData).getClientId();
                        DataAckProtocol dataAck = new DataAckProtocol();
                        dataAck.setAckMsgId(((DataProtocol) clientData).getMsgId());
                        dataAck.setUnused("message received:"+ ((DataProtocol) clientData).getData());
                        dataQueue.offer(dataAck);
                        toNotifyAll(dataQueue); //���ѷ����߳�

                        tBack.targetIsOnline(userIP);
                        onLineClient.put(clientId, socket);
                    } else if (clientData.getProtocolType() == 2) {
                        System.out.println("pingId: " + ((PingProtocol) clientData).getPingId());
                        PingProtocol pingProtocol = (PingProtocol)clientData;
//                        byte[] bytes = pingProtocol.genContentData();
//                        System.out.println(DecodeUtil.binary(bytes, 2));
                        clientId = pingProtocol.getClientId();
                        PingAckProtocol pingAck = new PingAckProtocol();
                        pingAck.setUnused("heart-beat");
                        dataQueue.offer(pingAck);
                        toNotifyAll(dataQueue); //���ѷ����߳�

                        tBack.targetIsOnline(userIP);
                        onLineClient.put(clientId, socket);
                    }
                } else {
                    System.out.println("client {clientId: "+clientId+", clientIp: "+userIP+"} is offline...");
                    if(!onLineClient.isEmpty()&&clientId!=null){
                    	onLineClient.remove(clientId);
                    }
                    ServerResponseTask.printAllClient();
                    break;
                }
            }

            SocketUtil.closeInputStream(inputStream);
        }
    }

    public class SendTask extends Thread {

        private DataOutputStream outputStream;
        private boolean isCancle;

        @Override
        public void run() {
            while (!isCancle) {
                if (!isConnected()) {
                    isCancle = true;
                    break;
                }

                BasicProtocol procotol = dataQueue.poll();
                if (procotol == null) {
                    toWaitAll(dataQueue);
                } else if (outputStream != null) {
                    synchronized (outputStream) {
                        SocketUtil.write2Stream(procotol, outputStream);
                    }
                }
            }

            SocketUtil.closeOutputStream(outputStream);
        }
    }

}