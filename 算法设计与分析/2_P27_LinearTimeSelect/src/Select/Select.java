package Select;

public class Select {//����ʱ����� ��Ҫ�����������Ԫ��  ������RandomizedSelect ��������ʱO(n)

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int select(int a[], int p, int r, int k) {
		if(r- p < 75){
			��ĳ���������㷨������a[p:r]����
			return a[p+k-1];
		}
		for(int i=0; i<=(r-p-4)/5; i++){//i��Ϊn��Ԫ�صķ������
			��a[p+5*i]��a[p+5*i+4]�ĵ�3СԪ����a[p+i]����λ��;//����λ��Ԫ�ػ���ǰ��
			//����λ������λ����r-p-4��������˵��n-5
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
