package Select;

public class Select {//线性时间查找 按要求查找数组中元素  类似于RandomizedSelect 但最坏情况用时O(n)

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int select(int a[], int p, int r, int k) {
		if(r- p < 75){
			用某个简单排序算法对数组a[p:r]排序
			return a[p+k-1];
		}
		for(int i=0; i<=(r-p-4)/5; i++){//i即为n个元素的分组个数
			将a[p+5*i]至a[p+5*i+4]的第3小元素与a[p+i]交换位置;//将中位数元素换至前面
			//找中位数的中位数，r-p-4即上面所说的n-5
		}
		int x = select(a, p, p+(r-p-4)/5, (r-p-4)/10);
		int i = Partition(a, p, r, x);
		int j = i - p +1;
		if(k <= j)
			return select(a, p, i, k);
		else
			return select(a, i+1, r, k-j);
		
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
