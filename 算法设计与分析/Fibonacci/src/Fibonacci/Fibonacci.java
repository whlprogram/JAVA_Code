package Fibonacci;

import java.util.Scanner;

public class Fibonacci {//斐波拉契数列

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		  /*在新增一个Scanner对象时需要一个System.in对象，因为实际上还是System.in在取得用户输入。
		   * Scanner的next()方法用以取得用户输入的字符串；
		   * nextInt()将取得的输入字符串转换为整数类型；同样，
		   * nextFloat()转换成浮点型；
		   * nextBoolean()转换成布尔型。*/
		  Scanner scan = new Scanner(System.in);
		  System.out.print("斐波拉契数列普通递归算法,输入数据：");
		  int n = scan.nextInt();
		  System.out.println("斐波拉契数列普通递归算法,得到数据：" + Fibonacci1(n));
		  
		  System.out.print("斐波拉契数列自底向上的非递归算法,输入数据：");
		  int n1 = scan.nextInt();
		  System.out.println("斐波拉契数列自底向上的非递归算法,得到数据：" + Fibonacci2(n1));
		  
		  System.out.print("斐波拉契数列自顶向下的递归算法,输入数据：");
		  int n2 = scan.nextInt();
		  System.out.println("斐波拉契数列自顶向下的递归算法,得到数据：" + Fibonacci3(n2));
	}
	public static int Fibonacci1(int n){//普通递归算法
		if(n == 0)	return 0;
		else if(n == 1)	return 1;
		else return Fibonacci1(n-1)+Fibonacci1(n-2);
	}
	public static int Fibonacci2(int n){//自底向上的非递归算法
		int f0 = 0, f1 = 1, f2 = 0;
		if(n == 0)	return f0;
		if(n == 1)	return f1;
		for(int i=2; i<=n; ++i){
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}
		return f2;
	}
	public static int fibarr[] = new int[1000];//默认全部为0
	public static int Fibonacci3(int n){//自顶向下的递归算法
		int t = 0;
		if(fibarr[n] != 0)
			return fibarr[n];
		if(n == 0)	t = 0;
		if(n == 1)	t = 1;
		if(n > 1) 
			t = Fibonacci1(n-1)+Fibonacci1(n-2);
		return fibarr[n] = t; //取代下面两行
//		fibarr[n] = t;
//		return fibarr[n];
		
	}

}
