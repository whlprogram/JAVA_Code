package mergeSort;

import java.util.Random;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {//合并排序
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);  
//		System.out.print("合并排序,输入合并排序元素个数：");
		int n = scan.nextInt();
		//手动输入需要合并排序的数组
		int list[] = new int[n];
		for (int i = 0; i < list.length; i++)
			list[i] = scan.nextInt();
//		//随机生成数组
//		Random random = new Random();
//		int list[] = new int[n];
//		for (int i = 0; i < list.length; i++)
//			list[i] = random.nextInt(100);
//		
//		System.out.print("随机生成数组合并排序前为:");
//		for(int i=0;i<list.length;i++)
//			 System.out.print(list[i] + " ");
//		System.out.println();
//		System.out.print("递归合并排序后为:");
		mergeSort(list, 0, list.length-1);
		for(int i=0; i<list.length; i++){
			System.out.print(list[i] + " ");
		}
	}
	public static int b[];
	//合并排序 递归算法
	public static void mergeSort(int a[], int left, int right){
		b = new int[right+1];//很重要！！！！！初始化数组b 
		if(left < right){//至少有两个元素
			int i = (left+right)/2;//取中点
			mergeSort(a, left, i);
			mergeSort(a, i+1, right);
			Merge(a, b, left, i, right);//合并到数组b		
			Copy(a, b, left, right);//将数组b复制给数组a
		}
	}
	//合并c[left:middle]和c[middle+1:right]到d[left:right]
	public static void Merge(int c[], int d[], int left, int middle, int right){
		int i = left, j = middle+1, k = left;
		while( (i<=middle) && (j<=right) ){//两个子序列非空时取小者输出到d[k]上
			if(c[i] <= c[j])
				d[k++] = c[i++];
			else
				d[k++] = c[j++];
		}
		if(i > middle)//第一个子序列为空复制第二个子序列剩下部分
			for(int q=j; q<=right; q++)
				d[k++] = c[q];
		else //第二个子序列为空复制第一个子序列剩下部分
			for(int q=i; q<=middle; q++)
				d[k++] = c[q];
	}
	//将数组b复制给数组a
	public static void Copy(int a[], int b[], int m, int n){
		for(int i=m; i<=n; i++)
			a[i] = b[i];
	}

}
