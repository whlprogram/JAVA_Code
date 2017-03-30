
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
	public static void toHex(int num)//ʮ����-->ʮ������
	{	
		trans(num,15,4);
	}
	public static void toOctal(int num)//ʮ����-->�˽���
	{	
		trans(num,7,3);
	}
	public static void toBinary(int num)//ʮ����-->������
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
