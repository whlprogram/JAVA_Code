package BinarySearch;

public class binarySearch {//������������ �α�P14

	/**
	 * @param args
	 */
	//const"��"goto"�������ؼ�����Java�����в�û�о��庬�塣
	//Java���԰�������Ϊ�ؼ��֣�ֻ����Ϊ"const"��"goto"������ĳЩ��������ԵĹؼ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 8;
		int a[] = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch1(a, x, a.length));
	}
	public static int binarySearch1(int a[], int x, int n){
		//��a[0] <= a[1] <= ... <= a[n-1]������x ���������飩
		//�ҵ�xʱ�������������е�λ�ã����򷵻�-1
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
