package integerDivision;
import java.util.Scanner;
public class IntegerDivision {//整数划分
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);  
		int n = scan.nextInt();
		System.out.println(q(n, n));
	}
	public static int q(int n, int m){
		if(n<1 || m<1)
			return 0;
		if(n==1 || m==1)
			return 1;
		if(n < m)
			return q(n, n);
		if(n == m)
			return q(n, m-1)+1;
		return q(n, m-1)+ q(n-m, m);
	}
}
