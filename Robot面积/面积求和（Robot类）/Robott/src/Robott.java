import java.util.Scanner;

public class Robott {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����ҳ��
		for (int i = 1; i <= 36; i++) {
			System.out.print("*");
		}
		System.out.println();// ����
		for (int i = 1; i <= 10; i++) {
			System.out.print("*");
		}
		System.out.print("��ӭ����������������");
		for (int i = 1; i <= 10; i++) {
			System.out.print("*");
		}
		System.out.println();// ����
		for (int i = 1; i <= 36; i++) {
			System.out.print("*");
		}
		System.out.println();// ����
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
		System.out.println("��������һ��ͷ����ֻ�۾���һ�����壬��ֻ�ֺ����������");
		System.out.println("ͷ��ͷ����һ����Բ���뾶Ϊ5");
		System.out.println("�۾����۾���һ��Բ���뾶Ϊ");
		System.out.println("���壺������һ�������Ρ��߳�Ϊ10");
		System.out.println("�֣�����һ�����Σ��߶�Ϊ10�����Ϊ2");
		System.out.println("�ȣ�����һ�����Σ��߶�Ϊ5�����Ϊ2");
		for (int i = 1; i <= 30; i++) {
			System.out.print("-");
		}
		System.out.println();

		Robot robot = new Robot();

		System.out.print("������ͷ�İ뾶:");
		robot.setheadRadius();
		System.out.print("�������۾��İ뾶:");
		robot.seteyeRadius();
		System.out.print("����������ı߳�:");
		robot.setbodySide();
		System.out.print("�������ֵĸ߶�:");
		robot.sethandHeight();
		System.out.print("�������ֵĿ��:");
		robot.sethandWidth();
		System.out.print("�������ȵĸ߶�:");
		robot.setlegHeight();
		System.out.print("�������ȵĿ��:");
		robot.setlegWidth();

		for (int i = 1; i <= 30; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.print("�����˵�����ǣ�" + robot.getRobotArea());
	}

}
