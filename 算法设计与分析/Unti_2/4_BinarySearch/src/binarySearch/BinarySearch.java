package binarySearch;

//import java.util.Arrays;
//import java.util.Random;
import java.util.Scanner;

public class BinarySearch {//二分搜索 递归实现

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);  
		//System.out.print("二分搜索,输入二分搜索元素个数：");
		int n = scan.nextInt();
		//手动输入数组
		int list[] = new int[n];
		for (int i = 0; i < list.length; i++)
			list[i] = scan.nextInt();
		list = bubbleSort(list);
//		//随机生成数组
//		Random random = new Random();
//		int list[] = new int[n];
//		for (int i = 0; i < list.length; i++)
//			list[i] = random.nextInt(11);
//		//将随机生成的数组排序
//		Arrays.sort(list);
//		//打印随机生成的数组
//		System.out.print("随机生成的0-10数组：");
//		for (int i = 0; i < list.length; i++)
//			System.out.print(list[i] + " ");
//		System.out.println();
//		System.out.print("二分搜索,输入要搜索的元素：");
		int num = scan.nextInt();
		System.out.println( er(list, 0, list.length-1, num));
	}
	//非递归
	public static int binarySearch1(int a[], int x, int n){
		//在a[0] <= a[1] <= ... <= a[n-1]中搜索x （有序数组）
		//找到x时返回其在数组中的位置，否则返回-1
		int left = 0;
		int right = n-1;
		while(left <= right){
			int middle = (left + right)/2;
			if(x == a[middle])
				return middle;
			if(x > a[middle])
				left = middle+1;
			else
				right = middle-1;	
		}	
		return -1;
	}
	//递归
	public static int er(int a[],int start,int stop,int num)
	{
		if(start>stop) 
			return -1;
		int mid=(start+stop)/2;
		if(a[mid]==num)
			return mid;
		if(a[mid]>num)
			return er(a,start,mid-1,num);
		return er(a,mid+1,stop,num);
	}
	public static int[] bubbleSort(int[] args){//冒泡排序算法   
        for(int i=0;i<args.length-1;i++){   
           for(int j=i+1;j<args.length;j++){   
               if (args[i]>args[j]){   
                   int temp=args[i];   
                   args[i]=args[j];   
                   args[j]=temp;   
               }   
            }  
       }  
       return args;  
	}
}
