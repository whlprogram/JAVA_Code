
public class conversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toHex(6);
		toOctal(6);
		toOctal(-6);
		toBinary(6);
		System.out.println(Integer.toBinaryString(6));
	}
	public static void toHex(int num)//十进制-->十六进制
	{	
		trans(num,15,4);
	}
	public static void toOctal(int num)//十进制-->八进制
	{	
		trans(num,7,3);
	}
	public static void toBinary(int num)//十进制-->二进制
	{	
		trans(num,1,1);
	}
	public static void trans(int num,int base,int offset)
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
			int temp = num & base;
			arr[--pos] = chs[temp];
			num = num >>> offset;
		}
		//System.out.println("pos=" + pos);
		for(int x= pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);
		}
		System.out.println();
	}
	
}
