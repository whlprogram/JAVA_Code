package Fibonacci;

import java.util.Scanner;

public class Fibonacci {//쳲���������

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		  /*������һ��Scanner����ʱ��Ҫһ��System.in������Ϊʵ���ϻ���System.in��ȡ���û����롣
		   * Scanner��next()��������ȡ���û�������ַ�����
		   * nextInt()��ȡ�õ������ַ���ת��Ϊ�������ͣ�ͬ����
		   * nextFloat()ת���ɸ����ͣ�
		   * nextBoolean()ת���ɲ����͡�*/
		  Scanner scan = new Scanner(System.in);
		  System.out.print("쳲�����������ͨ�ݹ��㷨,�������ݣ�");
		  int n = scan.nextInt();
		  System.out.println("쳲�����������ͨ�ݹ��㷨,�õ����ݣ�" + Fibonacci1(n));
		  
		  System.out.print("쳲����������Ե����ϵķǵݹ��㷨,�������ݣ�");
		  int n1 = scan.nextInt();
		  System.out.println("쳲����������Ե����ϵķǵݹ��㷨,�õ����ݣ�" + Fibonacci2(n1));
		  
		  System.out.print("쳲����������Զ����µĵݹ��㷨,�������ݣ�");
		  int n2 = scan.nextInt();
		  System.out.println("쳲����������Զ����µĵݹ��㷨,�õ����ݣ�" + Fibonacci3(n2));
	}
	public static int Fibonacci1(int n){//��ͨ�ݹ��㷨
		if(n == 0)	return 0;
		else if(n == 1)	return 1;
		else return Fibonacci1(n-1)+Fibonacci1(n-2);
	}
	public static int Fibonacci2(int n){//�Ե����ϵķǵݹ��㷨
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
	public static int fibarr[] = new int[1000];//Ĭ��ȫ��Ϊ0
	public static int Fibonacci3(int n){//�Զ����µĵݹ��㷨
		int t = 0;
		if(fibarr[n] != 0)
			return fibarr[n];
		if(n == 0)	t = 0;
		if(n == 1)	t = 1;
		if(n > 1) 
			t = Fibonacci1(n-1)+Fibonacci1(n-2);
		return fibarr[n] = t; //ȡ����������
//		fibarr[n] = t;
//		return fibarr[n];
		
	}

}
