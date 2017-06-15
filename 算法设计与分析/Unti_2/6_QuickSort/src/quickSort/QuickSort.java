package quickSort;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {//快速排序 递归算法
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);  
//		System.out.print("快速排序,输入快速排序元素个数：");
		int n = scan.nextInt();
		//手动输入需要快速排序的数组
		int list[] = new int[n];
		for (int i = 0; i < list.length; i++)
			list[i] = scan.nextInt();
//		//随机生成数组
//		Random random = new Random();
//		int list[] = new int[n];
//		for (int i = 0; i < list.length; i++)
//			list[i] = random.nextInt(100);
//		
//		//System.out.print("随机生成数组快速排序前为:");
//		for(int i=0;i<list.length;i++)
//			 System.out.print(list[i] + " ");
//		System.out.println();
//		//System.out.print("递归快速排序后为:");
		QuickSort1(list, 0, list.length-1);
		for(int i=0; i<list.length; i++){
			System.out.print(list[i] + " ");
		}
	}
	public static void QuickSort1(int a[], int p, int r){
		if(p < r){
			int q = Partition(a, p, r);
			QuickSort1(a, p, q-1);//对左半段排序
			QuickSort1(a, q+1, r);//对右半段排序
		}
	}
	public static int Partition(int a[], int p, int r){
		int i = p, j = r+1;
		int x = a[p];
		//将<x的元素交换到左边区域
		//将>x的元素交换到右边区域
		while(true){
			while(a[++i]<x && i<r);
			while(a[--j] > x);
			if(i >= j)
				break;
			//Swap(a[i], a[j]);
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		a[p] = a[j];
		a[j] = x;
		return j;//基准值位置
	}
}
