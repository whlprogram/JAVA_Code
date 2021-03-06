package QuickSort;

import java.util.Random;
//import com.sun.org.apache.bcel.internal.generic.SWAP;

public class QuickSort {//快速排序 课本P24

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 5, 6, 3, 9, 8, 7, 2, 4, 0};
		System.out.print("快速排序前:");
		for(int i=0; i<=9; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		QuickSort1(a, 0, 9);
		System.out.print("快速排序后:");
		for(int i=0; i<=9; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		
		int b[] = {1, 5, 6, 2, 8, 9, 7, 3, 0, 4};
		System.out.print("随机快速排序前:");
		for(int i=0; i<=9; i++){
			System.out.print(b[i] + " ");
		}
		System.out.println();
		RandomizedQuickSort(b, 0, 9);
		System.out.print("随机快速排序后:");
		for(int i=0; i<=9; i++){
			System.out.print(b[i] + " ");
		}    
		
	}
	public static void QuickSort1(int a[], int p, int r){
		if(p < r){
			int q = Partition(a, p, r);
			QuickSort1(a, p, q-1);//对左半段排序
			QuickSort1(a, q+1, r);//对右半段排序
		}
	}
	public static void RandomizedQuickSort(int a[], int p, int r){
		if(p < r){
			int q = RandomizedPartition(a, p, r);
			RandomizedQuickSort(a, p, q-1);//对左半段排序
			RandomizedQuickSort(a, q+1, r);//对右半段排序
		}
	}
	public static int RandomizedPartition(int a[], int p, int r){
//      random.nextInt(max)表示生成[0,max]之间的随机数
//		举例：
//		生成0－2之间的随机数，包括2
//		Random rand = new Random();
//		int randNum = rand.nextInt(3);
//		生成5－26之间的随机数，包括26
//		int randNum = rand.nextInt(22)+5;
		
		Random rand = new Random();
		int i = rand.nextInt(r-p) + p;//在p~r之间随机生成一个数
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
