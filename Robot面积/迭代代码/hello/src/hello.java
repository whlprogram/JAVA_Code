import java.util.Scanner;


public class hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("hello world");//������
		System.out.println("hello world");//����
		for(int i=1;i<=36;i++){
			System.out.print("*");
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
		
		
		
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.print("�������������");
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.println();//����
		float side=400.5f;
		float acr=side*side;
		System.out.println("�߳�Ϊ��"+side);
		System.out.println("�����ε�����ǣ�"+acr);
		
		
		
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.print("����Բ�����");
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.println();//����
		
		
		float[] radius={0.0f,1.0f,2.0f};
		float[] circleArea=new float[3];
		final float ��=3.1415927f;
		for(int i=0;i<3;i++){
			circleArea[i]=��*radius[i]*radius[i];
		}
		for(int i=1;i<=3;i++){
			System.out.print("��"+i+"��Բ���뾶Ϊ"+radius[i-1]+",����ǣ�"+circleArea[i-1]);
			System.out.println();
		}
		
		
		
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.print("����������");
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.println();//����
		Scanner sc = new Scanner(System.in);
		float rectangleArea;
		System.out.print("��������εĸ߶ȣ�");
		float height=sc.nextFloat();
		System.out.print("��������εĿ�ȣ�");
		float width=sc.nextFloat();
		rectangleArea=height*width;
		System.out.println("���ε�����ǣ�"+rectangleArea);
	}
}
