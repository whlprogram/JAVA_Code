package fibonacci;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);  
		System.out.print("自底向上的非递归算法,输入：");
		int n1 = scan.nextInt();
		System.out.println("自底向上的非递归算法,输出：" + Fibonacci1(n1));
		  
		System.out.print("自顶向下的递归算法,输入：");
		int n2 = scan.nextInt();
		System.out.println("自顶向下的递归算法,输出：" + Fibonacci2(n2));
	}
	public static int Fibonacci1(int n){//自底向上的非递归算法
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
	public static int Fibonacci2(int n){//自顶向下的递归算法 备忘录方法
		int t = 0;
		if(fibarr[n] != 0)
			return fibarr[n];
		if(n == 0)	t = 0;
		if(n == 1)	t = 1;
		if(n > 1) 
			t = Fibonacci2(n-1)+Fibonacci2(n-2);
		return fibarr[n] = t;
	}

}
