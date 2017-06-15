package perm;
import java.util.Scanner;
public class Perm {
	public static void main(String[] args) {//全排列
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);  
		int n = scan.nextInt();
		String list[] = new String[n];
		for (int i = 0; i < list.length; i++)
			list[i] = scan.next();
		Perm1(list,0,n-1);
		System.out.println();
	}
	public static void Perm1(String list[], int k, int m){
		if (k == m){//只剩下一个元素
			for (int i = 0; i <= m; i++)
				System.out.print(list[i]);
			//System.out.println();//题目要求一行输出
		}
		else{//还有多个元素待排列,递归产生排列
			for (int i = k; i <= m; i++){
				String temp = list[k];
				list[k] = list[i];
				list[i] = temp;	
				Perm1(list,k+1,m);
				String temp1 = list[k];
				list[k] = list[i];
				list[i] = temp1;
			}
		}
	}
}
