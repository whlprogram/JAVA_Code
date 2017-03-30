import java.util.Scanner;


public class Area {

	/**
	 * @param args
	 */
	static void view()//开始界面
	{
		for(int i=0;i<=35;i++){
			System.out.print("*");//输出36个*
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
		
	}
	static float square(float side)//求正方形面积
	{
		float s=side*side;
		System.out.println("正方形的面积是："+s);
		return s;
	}
	static float circle(float radius)//求圆形面积
	{
		final float π=3.1415927f;
		float s=π*radius*radius;
		System.out.println("圆形的面积是："+s);		
		return s;
	}
	static float rectangle(float height,float width)//求矩形面积
	{
		float s=height*width;
		System.out.println("矩形的面积是："+s);
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
					System.out.print("请输入正方形的边长：");
				    float side=sq.nextFloat();
				    square(side);
					break;
				case 2:		
				    Scanner se = new Scanner(System.in);
					System.out.print("请输入圆形的边长：");
					float radius=se.nextFloat();
					circle(radius);
					break;
				case 3:
					Scanner sr = new Scanner(System.in);
					System.out.print("请输入矩形的高度：");
					float height=sr.nextFloat();
					System.out.print("请输入矩形的宽度：");
					float width=sr.nextFloat();
					rectangle(height, width);
					break;
				case 4:
					System.out.println("程序已经退出！");
					break;
				default:
					System.out.println("您选择的菜单项不存在！");
			}
        }while(type!=4);

	}

}
