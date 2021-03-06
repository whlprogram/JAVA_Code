package MergeSort;

public class MergeSort {//合并排序 课本P22    27和41行很重要！

	/**
	 * @param args
	 */
	public static int b[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 5, 6, 3, 9, 8, 7, 2, 4, 0};
		System.out.print("排序前为:");
		for(int i=0;i<a.length;i++)
			 System.out.print(a[i] + " ");
		System.out.println();
		System.out.print("递归排序后为:");
		mergeSort(a, 0, 9);
		for(int i=0; i<=9; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.print("非递归排序后为:");
		mergeSort1(a, a.length);
	}
	//合并排序 递归算法
	public static void mergeSort(int a[], int left, int right){
		b = new int[right+1];//很重要！！！！！初始化数组b 
		if(left < right){//至少有两个元素
			int i = (left+right)/2;//取中点
			mergeSort(a, left, i);
			mergeSort(a, i+1, right);
			Merge(a, b, left, i, right);//合并到数组b
			
			Copy(a, b, left, right);//将数组b复制给数组a	 等同于下面三行代码
//			for(int i1=left; i1<=right; i1++){
//				a[i1] = b[i1];
//			}
		}
	}
	//合并排序 非递归算法
	public static void mergeSort1(int a[], int n){//对数组a中所有元素进行合并排序
		 b = new int[n];
		 int s = 1;//合并的有序数组段的初始大小
		//有序数组段的长度小于数组长度继续合并
		 while(s < n){
			 //从下界开始将a中的相邻的长度为s的元素合并到排序到b中
			 MergePass(a, b, s, n);//合并到数组b
			 s += s;//待合并的有序数组段的长度增加一倍
			 MergePass(b, a, s, n);//合并到数组a
			 s += s;//待合并的有序数组段的长度增加一倍
		 }
		 for(int i=0;i<n;i++)
			 System.out.print(a[i] + " ");
	}
	public static void MergePass(int x[], int y[], int s, int n){//合并大小为s的相邻子数组,n为x.length
		int i = 0;
		while(i <= n-2*s){//合并大小为s的相邻2段子数组x[i:i+s-1]和x[i+s:i+2*s-1]
			Merge(x, y, i, i+s-1, i+2*s-1);
			i = i + 2*s;
		}
		//剩下的元素个数少于2s
		if(i+s < n)
			//合并数组段x[i:i+s-1]和x[i+s:n-1]
			Merge(x, y, i, i+s-1, n-1);
		//剩下的元素个数少于s
		else
			//直接将x[i:n-1]赋值到y数组
			for(int j=i; j<=n-1; j++)
				y[j] = x[j];		
	}
	//合并c[left:middle]和c[middle+1:right]到d[left:right]
	public static void Merge(int c[], int d[], int left, int middle, int right){
		int i = left, j = middle+1, k = left;
		while( (i<=middle) && (j<=right) ){//两个子序列非空时取小者输出到d[k]上
			if(c[i] <= c[j]){
				d[k++] = c[i++];
			}
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
	public static void Copy(int a[], int b[], int m, int n){
		for(int i=m; i<=n; i++)
			a[i] = b[i];
	}

}
