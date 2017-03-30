import java.util.Scanner;


public class hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("hello world");//不换行
		System.out.println("hello world");//换行
		for(int i=1;i<=36;i++){
			System.out.print("*");
		}
		System.out.println();//换行
		for(int i=1;i<=10;i++){
			System.out.print("*");
		}
		System.out.print("欢迎进入面积计算");
		for(int i=1;i<=10;i++){
			System.out.print("*");
		}
		System.out.println();//换行
		for(int i=1;i<=36;i++){
			System.out.print("*");
		}
		System.out.println();//换行
		System.out.println("1、计算正方形的面积");
		System.out.println("2、计算圆形的面积");
		System.out.println("3、计算矩形的面积");
		System.out.println("4、退出程序");
		
		
		
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.print("计算正方形面积");
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.println();//换行
		float side=400.5f;
		float acr=side*side;
		System.out.println("边长为："+side);
		System.out.println("正方形的面积是："+acr);
		
		
		
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.print("计算圆形面积");
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.println();//换行
		
		
		float[] radius={0.0f,1.0f,2.0f};
		float[] circleArea=new float[3];
		final float π=3.1415927f;
		for(int i=0;i<3;i++){
			circleArea[i]=π*radius[i]*radius[i];
		}
		for(int i=1;i<=3;i++){
			System.out.print("第"+i+"个圆：半径为"+radius[i-1]+",面积是："+circleArea[i-1]);
			System.out.println();
		}
		
		
		
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.print("计算矩形面积");
		for(int i=1;i<=10;i++){
			System.out.print("-");
		}
		System.out.println();//换行
		Scanner sc = new Scanner(System.in);
		float rectangleArea;
		System.out.print("请输入矩形的高度：");
		float height=sc.nextFloat();
		System.out.print("请输入矩形的宽度：");
		float width=sc.nextFloat();
		rectangleArea=height*width;
		System.out.println("矩形的面积是："+rectangleArea);
	}
}
