package Ackerman;
public class Ackerman {//Ackermanº¯Êı ¿Î±¾P12
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Ackerman1(1,0));
	}
	public static int Ackerman1(int n,int m){	
		if(n == 0)
			return 2;
		if(m == 0){
			if(n == 1)
				return 2;
			else
				return n+2;
		}
		return Ackerman1(Ackerman1(n-1,m), m-1);	
	}
}
