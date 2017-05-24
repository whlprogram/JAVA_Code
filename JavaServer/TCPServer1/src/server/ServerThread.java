package server;

import java.io.BufferedReader;  
import java.io.InputStreamReader;  
import java.io.PrintStream;  
import java.net.Socket;

/** 
 * ����Ϊ���߳��࣬���ڷ���� 
 * �������Ҫ�õ����̣߳����ﵥ��д��һ�����߳���
 */ 
public class ServerThread implements Runnable {  
	  
    private Socket client = null;  
    public ServerThread(Socket client){  
        this.client = client;  
    }  
      
    @Override  
    public void run() {  
        try{  
            //��ȡSocket���������������ͻ��˷�������  
            PrintStream out = new PrintStream(client.getOutputStream());  
            //��ȡSocket�����������������մӿͻ��˷��͹���������  
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));  
            boolean flag =true;  
            while(flag){  
                //���մӿͻ��˷��͹���������  
                String str =  buf.readLine();  
                if(str == null || "".equals(str)){  
                    flag = false;  
                }else{  
                	//DataSplit.Split(str);
                	//DataSplit v = new DataSplit();
                	JdbcAction.update(str);
                }  
            }  
            out.close();  
            client.close();  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
  
}  