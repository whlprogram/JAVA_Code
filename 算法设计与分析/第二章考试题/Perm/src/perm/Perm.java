package perm;

import java.util.Scanner;

public class Perm {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner scan = new Scanner(System.in);  
		System.out.print("ȫ����,�����ַ����������������ַ���");
		int n = scan.nextInt();
		String list[] = new String[n];
		for (int i = 0; i < list.length; i++)
			list[i] = scan.next();
		Perm1(list,0,n-1);
	}
	public static void Perm1(String list[], int k, int m){
		if (k == m){//ֻʣ��һ��Ԫ��
			for (int i = 0; i <= m; i++)
				System.out.print(list[i]);
			//System.out.println();
		}
		else{//���ж��Ԫ�ش�����,�ݹ��������
			for (int i = k; i <= m; i++){
				//���ô���
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
