import java.util.Scanner;

public class Robott {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//输出主页面
		for (int i = 1; i <= 36; i++) {
			System.out.print("*");
		}
		System.out.println();// 换行
		for (int i = 1; i <= 10; i++) {
			System.out.print("*");
		}
		System.out.print("欢迎进入机器人面积计算");
		for (int i = 1; i <= 10; i++) {
			System.out.print("*");
		}
		System.out.println();// 换行
		for (int i = 1; i <= 36; i++) {
			System.out.print("*");
		}
		System.out.println();// 换行
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

		for (int i = 1; i <= 30; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println("机器人由一个头，两只眼睛，一个身体，两只手和两条腿组成");
		System.out.println("头：头部是一个半圆，半径为5");
		System.out.println("眼睛：眼睛是一个圆，半径为");
		System.out.println("身体：身体是一个正方形。边长为10");
		System.out.println("手：手是一个矩形，高度为10，宽度为2");
		System.out.println("腿：腿是一个矩形，高度为5，宽度为2");
		for (int i = 1; i <= 30; i++) {
			System.out.print("-");
		}
		System.out.println();

		Robot robot = new Robot();

		System.out.print("请输入头的半径:");
		robot.setheadRadius();
		System.out.print("请输入眼睛的半径:");
		robot.seteyeRadius();
		System.out.print("请输入身体的边长:");
		robot.setbodySide();
		System.out.print("请输入手的高度:");
		robot.sethandHeight();
		System.out.print("请输入手的宽度:");
		robot.sethandWidth();
		System.out.print("请输入腿的高度:");
		robot.setlegHeight();
		System.out.print("请输入腿的宽度:");
		robot.setlegWidth();

		for (int i = 1; i <= 30; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.print("机器人的面积是：" + robot.getRobotArea());
	}

}
