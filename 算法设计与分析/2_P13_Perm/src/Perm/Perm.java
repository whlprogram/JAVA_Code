package Perm;

public class Perm {//全排列 课本P13

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int list[] = {1,2,3,4};
		Perm1(list,0,2);
	}
	public static void Perm1(int list[], int k, int m){
		if (k == m){//只剩下一个元素
			for (int i = 0; i <= m; i++)
				System.out.print(list[i]);
			System.out.println();
		}
		else{//还有多个元素待排列,递归产生排列
			for (int i = k; i <= m; i++){
//				Swap(list[k],list[i]);//值传递(错误)
				//引用传递
				int temp = list[k];
				list[k] = list[i];
				list[i] = temp;
				
				Perm1(list,k+1,m);
				
				int temp1 = list[k];
				list[k] = list[i];
				list[i] = temp1;
//				Swap(list[k], list[i]);
			}
		}
	}
	 public static void Swap(int a, int b){//值传递 只传递两个数，并非传递地址
		int temp = a;
		a = b;
		b = temp;
	}
}
