package QuickSort;

import java.util.Random;
import com.sun.org.apache.bcel.internal.generic.SWAP;

public class QuickSort {//��������

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 5, 6, 3, 9, 8, 7, 2, 4, 0};
		System.out.print("��������ǰ:");
		for(int i=0; i<=9; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		QuickSort1(a, 0, 9);
		System.out.print("���������:");
		for(int i=0; i<=9; i++){
			System.out.print(a[i] + " ");
		}
	}
	public static void QuickSort1(int a[], int p, int r){
		if(p < r){
			int q = Partition(a, p, r);
			QuickSort1(a, p, q-1);//����������
			QuickSort1(a, q+1, r);//���Ұ������
		}
	}
	public static void RandomizedQuickSort(int a[], int p, int r){
		if(p < r){
			int q = RandomizedPartition(a, p, r);
			RandomizedQuickSort(a, p, q-1);//����������
			RandomizedQuickSort(a, q+1, r);//���Ұ������
		}
	}
	public static int RandomizedPartition(int a[], int p, int r){
		int i = Random(p, r);
		
		int temp = a[i];
		a[i] = a[p];
		a[p] = temp;
		
		return Partition(a, p, r);
	}
	private static int Random(int p, int r) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static int Partition(int a[], int p, int r){
		int i = p, j = r+1;
		int x = a[p];
		//��<x��Ԫ�ؽ������������
		//��>x��Ԫ�ؽ������ұ�����
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
		return j;//��׼ֵλ��
	}

}
