package quickSort;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {//�������� �ݹ��㷨
		// TODO �Զ����ɵķ������
		Scanner scan = new Scanner(System.in);  
//		System.out.print("��������,�����������Ԫ�ظ�����");
		int n = scan.nextInt();
		//�ֶ�������Ҫ�������������
		int list[] = new int[n];
		for (int i = 0; i < list.length; i++)
			list[i] = scan.nextInt();
//		//�����������
//		Random random = new Random();
//		int list[] = new int[n];
//		for (int i = 0; i < list.length; i++)
//			list[i] = random.nextInt(100);
//		
//		//System.out.print("������������������ǰΪ:");
//		for(int i=0;i<list.length;i++)
//			 System.out.print(list[i] + " ");
//		System.out.println();
//		//System.out.print("�ݹ���������Ϊ:");
		QuickSort1(list, 0, list.length-1);
		for(int i=0; i<list.length; i++){
			System.out.print(list[i] + " ");
		}
	}
	public static void QuickSort1(int a[], int p, int r){
		if(p < r){
			int q = Partition(a, p, r);
			QuickSort1(a, p, q-1);//����������
			QuickSort1(a, q+1, r);//���Ұ������
		}
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
