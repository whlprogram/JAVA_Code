import java.util.Scanner;


public class Area {

	/**
	 * @param args
	 */
	static void view()//��ʼ����
	{
		for(int i=0;i<=35;i++){
			System.out.print("*");//���36��*
		}
		System.out.println();//����
		for(int i=1;i<=10;i++){
			System.out.print("*");
		}
		System.out.print("��ӭ�����������");
		for(int i=1;i<=10;i++){
			System.out.print("*");
		}
		System.out.println();//����
		for(int i=1;i<=36;i++){
			System.out.print("*");
		}
		System.out.println();//����
		System.out.println("1�����������ε����");
		System.out.println("2������Բ�ε����");
		System.out.println("3��������ε����");
		System.out.println("4���˳�����");
		
	}
	static float square(float side)//�����������
	{
		float s=side*side;
		System.out.println("�����ε�����ǣ�"+s);
		return s;
	}
	static float circle(float radius)//��Բ�����
	{
		final float ��=3.1415927f;
		float s=��*radius*radius;
		System.out.println("Բ�ε�����ǣ�"+s);		
		return s;
	}
	static float rectangle(float height,float width)//��������
	{
		float s=height*width;
		System.out.println("���ε�����ǣ�"+s);
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int type;

        do{
        	view();
		    Scanner sc = new Scanner(System.in);
		    type=sc.nextInt();
		    switch(type){
				case 1:
					Scanner sq = new Scanner(System.in);
					System.out.print("�����������εı߳���");
				    float side=sq.nextFloat();
				    square(side);
					break;
				case 2:		
				    Scanner se = new Scanner(System.in);
					System.out.print("������Բ�εı߳���");
					float radius=se.nextFloat();
					circle(radius);
					break;
				case 3:
					Scanner sr = new Scanner(System.in);
					System.out.print("��������εĸ߶ȣ�");
					float height=sr.nextFloat();
					System.out.print("��������εĿ�ȣ�");
					float width=sr.nextFloat();
					rectangle(height, width);
					break;
				case 4:
					System.out.println("�����Ѿ��˳���");
					break;
				default:
					System.out.println("��ѡ��Ĳ˵�����ڣ�");
			}
        }while(type!=4);

	}

}
