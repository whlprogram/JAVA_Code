import java.util.Scanner;


public class Robot {
	//�����ҳ��ķ���
	static void view()
	{
		for(int i=1;i<=36;i++){
			System.out.print("*");
		}
		System.out.println();//����
		for(int i=1;i<=10;i++){
			System.out.print("*");
		}
		System.out.print("��ӭ����������������");
		for(int i=1;i<=10;i++){
			System.out.print("*");
		}
		System.out.println();//����
		for(int i=1;i<=36;i++){
			System.out.print("*");
		}
		System.out.println();//����
		System.out.println("       **       ");
		System.out.println("      ****      ");	
		System.out.println("     ** * **    ");	
		System.out.println("** ********** **");			
		System.out.println("** ********** **");	
		System.out.println("** ********** **");	
		System.out.println("** ********** **");	
		System.out.println("** ********** **");	
		System.out.println("     **   **    ");	
		System.out.println("     **   **    ");	
		
		for(int i=1;i<=30;i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("��������һ��ͷ����ֻ�۾���һ�����壬��ֻ�ֺ����������");
		System.out.println("ͷ��ͷ����һ����Բ���뾶Ϊ5");
		System.out.println("�۾����۾���һ��Բ���뾶Ϊ");
		System.out.println("���壺������һ�������Ρ��߳�Ϊ10");
		System.out.println("�֣�����һ�����Σ��߶�Ϊ10�����Ϊ2");
		System.out.println("�ȣ�����һ�����Σ��߶�Ϊ5�����Ϊ2");
		for(int i=1;i<=30;i++){
		System.out.print("-");
	    }
	    System.out.println();
	}
	//���������ε����
	static float square(float side)
	{
		float sarc=side*side;
		return sarc;
	}
	//����Բ�����
	static float circle(float radius)
	{
		final float ��=3.1415927f;
		float carc=��*radius*radius;		
		return carc;
	}
	//���㳤�������
	static float rectangle(float height,float width)
	{
		float rectangleArea;
		rectangleArea=height*width;
		return rectangleArea;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������ҳ��
		view();
		//��ȡ����ֵ�����
        float headRadius,eyeRadius,bodySide,handHeight,handWidth,legHeight,legWidth,RobotArea=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("������ͷ�İ뾶:");
        headRadius=sc.nextFloat();

        System.out.print("�������۾��İ뾶:");
        eyeRadius=sc.nextFloat();

        System.out.print("����������ı߳�:");
        bodySide=sc.nextFloat();

        System.out.print("�������ֵĸ߶�:");
        handHeight=sc.nextFloat();;
        System.out.print("�������ֵĿ��:");
        handWidth=sc.nextFloat();

        System.out.print("�������ȵĸ߶�:");
        legHeight=sc.nextFloat();
        System.out.print("�������ȵĿ��:");
        legWidth=sc.nextFloat();
        
        
        
      //�����¼������������
        float []partArea={circle(headRadius)/2,
			        	2*circle(eyeRadius),
			        	square(bodySide),
			        	2*rectangle(handHeight,handWidth),
			        	2*rectangle(legHeight,legWidth)
        				};
      //ʹ��forѭ����������������
        for(int i=0;i<partArea.length;i++){
        	RobotArea+=partArea[i];	
        }
        for(int i=1;i<=20;i++){
            System.out.print("*");
        }
        System.out.println();
        //��������������
        System.out.print("�����˵�����ǣ�"+RobotArea);
	}

}
