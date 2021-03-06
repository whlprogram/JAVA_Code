package RandomizedSelect;

import java.util.Random;
import java.util.Scanner;

public class RandomizedSelect {//线性时间查找 按要求查找数组中元素 随机划分基准 最坏情况用时O(n^2) 平均性能很好0(n) 课本P27

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//找数组a[0:n-1]中第k小元素
		int a[] = {4, 67, 6, 23, 85, 5, 90, 32, 66, 10};
		int n = a.length;
		Scanner scan = new Scanner(System.in);
		System.out.print("你想查找第几小的元素?请输入：");
		int k = scan.nextInt();
		System.out.println("数组中第k小的元素是：" +randomizedSelect(a, 0, n-1, k));
	}
	public static int randomizedSelect(int a[], int p, int r, int k) {
		if(p == r)
			return a[p];
		int i = RandomizedPartition(a, p, r);
		int j = i-p+1;
		if(k <= j)
			return randomizedSelect(a, p, i, k);
		else
			return randomizedSelect(a, i+1, r, k-j);
		
	}
	public static int RandomizedPartition(int a[], int p, int r){
		Random rand = new Random();
		int i = rand.nextInt(r-p+1) + p;//在p~r之间随机生成一个数
		//a[i]与a[p]交换位置
		int temp = a[i];
		a[i] = a[p];
		a[p] = temp;
		
		return Partition(a, p, r);
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
