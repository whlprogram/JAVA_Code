package ackerman;

import java.util.Scanner;

public class Ackerman {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);  
		int n = scan.nextInt();
		int m = scan.nextInt();
		System.out.println(Ackerman1(n, m));
	}
	public static int Ackerman1(int n,int m){	
		if(n==0 && m>=0)return 1;
		if(n==1 && m==0)return 2;
		if(n>=2 && m==0)return n+2;
		if(n>=1 && m>=1) 
			return Ackerman1(Ackerman1(n-1,m),m-1);
        return -1;
	}
}
