package test;
/*
��ʮ������Nת��Ϊr���Ƶ�������ת����������շת���������N=3456��r=8Ϊ��ת���������£�
N      N / 8(����)  N % 8(����)
3456   432         0     ��
432    54 		   0
54 	   6 		   6
6 	   0 		   6     ��
���ԣ���3456��10 =��6600��8
*/
import java.util.*;
public class conversion {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		System.out.print("������һ��ʮ��������");
		int num = x.nextInt();//��ʾ��������ת������
		System.out.print("������Ҫ����ת���Ľ���(���ֱ�ʾ)");
		int base = x.nextInt();//��ʾ����
		trans(num,base);
		
		//System.out.println(Integer.toOctalString(3456));
	}
	
	public static void trans(int num,int base)
	{
		if(num == 0)
		{
			System.out.println("0");
			return ;
		}
		//����һ����Ӧ��ϵ��
		char[] chs = {'0','1','2','3',
				'4','5','6','7',
				'8','9','A','B',
				'C','D','E','F'};
		/*����õ��Ƚ϶�����ݣ����ݶ�Ļ��ȴ洢�������ٽ��в���
		 ����һ�����飬��Ϊ��ʱ����*/
		char[] arr = new char[32];
		int pos = arr.length;
		while(num != 0)
		{
			int temp = num % base;
			arr[--pos] = chs[temp];
			num = num / base;
		}
		//System.out.println("pos=" + pos);
		for(int x= pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);
		}
		System.out.println();
	}
	
}
