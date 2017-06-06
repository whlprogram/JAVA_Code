package perm;

import java.util.Scanner;

public class Perm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);  
		System.out.print("全排列,输入字符个数并依次输入字符：");
		int n = scan.nextInt();
		String list[] = new String[n];
		for (int i = 0; i < list.length; i++)
			list[i] = scan.next();
		Perm1(list,0,n-1);
	}
	public static void Perm1(String list[], int k, int m){
		if (k == m){//只剩下一个元素
			for (int i = 0; i <= m; i++)
				System.out.print(list[i]);
			//System.out.println();
		}
		else{//还有多个元素待排列,递归产生排列
			for (int i = k; i <= m; i++){
				//引用传递
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
