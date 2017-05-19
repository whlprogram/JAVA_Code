package feature;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import protocol.DataProtocol;

/**
 * Created by Yang on 16/11/15.
 */
public class ConnectionServer {//服务器连接

    private static boolean isStart = true;
    private static ServerResponseTask serverResponseTask;

    public ConnectionServer() {

    }

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            serverSocket = new ServerSocket(Config.PORT);
            while (isStart) {
                Socket socket = serverSocket.accept();//服务端接收客户端的连接请求
                serverResponseTask = new ServerResponseTask(socket,
                        new ResponseCallback() {

                            @Override
                            public void targetIsOffline(DataProtocol reciveMsg) {
                                if (reciveMsg != null) {
                                	//System.out.println(reciveMsg.getData());
                                	DataSplit.Split(reciveMsg);
                                 	String retu = JdbcAction.backQuery(reciveMsg.getMsgId());
                                 	System.out.println(retu);
                                }
                                ServerResponseTask.printAllClient();
                            }

                            @Override
                            public void targetIsOnline(String clientIp) {
                                System.out.println(clientIp + " is onLine");
                            }
                        });

                if (socket.isConnected()) {
                    executorService.execute(serverResponseTask);
                }
            }

            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    isStart = false;
                    serverSocket.close();
                    if (serverSocket != null)
                        serverResponseTask.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
