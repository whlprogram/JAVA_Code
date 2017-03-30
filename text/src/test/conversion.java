package test;
/*
将十进制数N转换为r进制的数，其转换方法利用辗转相除法：以N=3456，r=8为例转换方法如下：
N      N / 8(整除)  N % 8(求余)
3456   432         0     低
432    54 		   0
54 	   6 		   6
6 	   0 		   6     高
所以：（3456）10 =（6600）8
*/
import java.util.*;
public class conversion {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		System.out.print("请输入一个十进制整数");
		int num = x.nextInt();//表示即将进行转换的数
		System.out.print("请输入要进行转换的进制(数字表示)");
		int base = x.nextInt();//表示进制
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
		//定义一个对应关系表。
		char[] chs = {'0','1','2','3',
				'4','5','6','7',
				'8','9','A','B',
				'C','D','E','F'};
		/*查表用到比较多的数据，数据多的话先存储起来，再进行操作
		 定义一个数组，作为临时容器*/
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
