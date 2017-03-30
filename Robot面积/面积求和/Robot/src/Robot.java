import java.util.Scanner;


public class Robot {
	//输出主页面的方法
	static void view()
	{
		for(int i=1;i<=36;i++){
			System.out.print("*");
		}
		System.out.println();//换行
		for(int i=1;i<=10;i++){
			System.out.print("*");
		}
		System.out.print("欢迎进入机器人面积计算");
		for(int i=1;i<=10;i++){
			System.out.print("*");
		}
		System.out.println();//换行
		for(int i=1;i<=36;i++){
			System.out.print("*");
		}
		System.out.println();//换行
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
		System.out.println("机器人由一个头，两只眼睛，一个身体，两只手和两条腿组成");
		System.out.println("头：头部是一个半圆，半径为5");
		System.out.println("眼睛：眼睛是一个圆，半径为");
		System.out.println("身体：身体是一个正方形。边长为10");
		System.out.println("手：手是一个矩形，高度为10，宽度为2");
		System.out.println("腿：腿是一个矩形，高度为5，宽度为2");
		for(int i=1;i<=30;i++){
		System.out.print("-");
	    }
	    System.out.println();
	}
	//计算正方形的面积
	static float square(float side)
	{
		float sarc=side*side;
		return sarc;
	}
	//计算圆形面积
	static float circle(float radius)
	{
		final float π=3.1415927f;
		float carc=π*radius*radius;		
		return carc;
	}
	//计算长方形面积
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
		//调用输出主页面
		view();
		//获取变量值并输出
        float headRadius,eyeRadius,bodySide,handHeight,handWidth,legHeight,legWidth,RobotArea=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入头的半径:");
        headRadius=sc.nextFloat();

        System.out.print("请输入眼睛的半径:");
        eyeRadius=sc.nextFloat();

        System.out.print("请输入身体的边长:");
        bodySide=sc.nextFloat();

        System.out.print("请输入手的高度:");
        handHeight=sc.nextFloat();;
        System.out.print("请输入手的宽度:");
        handWidth=sc.nextFloat();

        System.out.print("请输入腿的高度:");
        legHeight=sc.nextFloat();
        System.out.print("请输入腿的宽度:");
        legWidth=sc.nextFloat();
        
        
        
      //数组记录身体各部分面积
        float []partArea={circle(headRadius)/2,
			        	2*circle(eyeRadius),
			        	square(bodySide),
			        	2*rectangle(handHeight,handWidth),
			        	2*rectangle(legHeight,legWidth)
        				};
      //使用for循环计算机器人总面积
        for(int i=0;i<partArea.length;i++){
        	RobotArea+=partArea[i];	
        }
        for(int i=1;i<=20;i++){
            System.out.print("*");
        }
        System.out.println();
        //输出机器人总面积
        System.out.print("机器人的面积是："+RobotArea);
	}

}
