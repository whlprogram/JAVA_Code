package server;

import java.net.ServerSocket;  
import java.net.Socket; 


/*
 * 服务端处理TCP连接请求的代码
 */
public class Server1 {

	public static void main(String[] args) throws Exception{
		// TODO 自动生成的方法存根
		//服务端在20006端口监听客户端请求的TCP连接  
        ServerSocket server = new ServerSocket(8885);  
        Socket client = null;  
        boolean f = true;  
        while(f){  
            //等待客户端的连接，如果没有获取连接  
            client = server.accept();  
            System.out.println("与客户端连接成功！");  
            //为每个客户端连接开启一个线程  
            new Thread(new ServerThread(client)).start();  
        }  
        server.close();
	}

}
