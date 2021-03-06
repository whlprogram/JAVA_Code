package fibonacci;

import java.util.Scanner;

public class Fibonacci {//斐波拉契数列

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //普通递归算法
        //System.out.println(Fibonacci1(n));
        //自底向上的非递归动态规划算法
        System.out.println(Fibonacci2(n));
        //自顶向下的递归动态规划算法(备忘录方法)
        System.out.println(Fibonacci3(n));
	}
	//普通递归算法
	public static int Fibonacci1(int n){
		if(n < 0)
			return -1;
		if(n==0 || n==1)
			return 1;
		return Fibonacci1(n-1)+Fibonacci1(n-2);
	}
	//自底向上的非递归动态规划算法
	public static int Fibonacci2(int n){
		int f0 = 1, f1 = 1, f2 = 0;
		for(int i=2; i<=n; i++){
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}
		return f2;
	}
	//自顶向下的递归动态规划算法(备忘录方法)
	public static int fibarr[] = new int[1000];//默认全部为0
	public static int Fibonacci3(int n){
		int t = 0;
		if(fibarr[n] != 0)
			return fibarr[n];
		if(n==0 || n==1)
			t = 1;
		if(n > 1)
			t = Fibonacci3(n-1) + Fibonacci3(n-2);
		fibarr[n] = t;
		return fibarr[n];
	}

}
