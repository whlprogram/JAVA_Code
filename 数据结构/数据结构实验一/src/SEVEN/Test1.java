package SEVEN;
class Point{
	protected int x, y; //coordinates of the Point
	public Point(){     //���������Ĺ��췽��
		x = 0;
		y = 0;
		System.out.println("Point constructor: " + this.toString());
	}
	public 	Point(int a, int b){  //�������Ĺ��췽��
		x = a;
		y = b;
		System.out.println("Point constructor: " + this.toString());
	}
	public String toString(){
		return "[" + x + "," + y + "]";
	}
}
class Circle extends Point{ //Circle��̳�Point��
	protected double radius;
	public Circle(){
		super(4,5);  //���ø���������Ĺ��췽��
		radius = 10;
		System.out.println("Circle constructor: " + this.toString());
	}
	public String toString(){
		return "Center= " + super.toString() + " Radius= " + radius;
	}
}


public class Test1 {
	public static void main(String[] args) {
		Circle circle1 = new Circle(); 
		//��Circle��������ִ�и���Point����޲������췽��
		//Ȼ��ִ������Circle��Ĺ��췽��
	}

}
