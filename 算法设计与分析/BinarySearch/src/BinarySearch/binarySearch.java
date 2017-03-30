package BinarySearch;

public class binarySearch {//二分搜索技术 课本P14

	/**
	 * @param args
	 */
	//const"和"goto"这两个关键字在Java语言中并没有具体含义。
	//Java语言把它们列为关键字，只是因为"const"和"goto"是其他某些计算机语言的关键字
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 8;
		int a[] = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch1(a, x, a.length));
	}
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
}
