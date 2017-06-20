package test;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(F(n));
		System.out.println(F1(n));
	}
	public static int F(int n){
		int f0=1,f1=1,f2=0;
		if(n==0)	return f0;
		if(n==1)	return f1;
		for(int i=2; i<=n; i++){
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}
		return f2;
	}
	public static int far[]= new int[1000];
	public static int F1(int n){
		if(far[n] != 0)
			return far[n];
		int t=0;
		if(n==0)	t=1;
		if(n==1)	t=1;
		if(n>1)		t=F1(n-1) + F1(n-2);
		far[n] = t;
		return far[n];
	}
}
