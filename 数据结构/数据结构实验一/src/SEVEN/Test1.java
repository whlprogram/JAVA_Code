package SEVEN;
class Point{
	protected int x, y; //coordinates of the Point
	public Point(){     //不带参数的构造方法
		x = 0;
		y = 0;
		System.out.println("Point constructor: " + this.toString());
	}
	public 	Point(int a, int b){  //带参数的构造方法
		x = a;
		y = b;
		System.out.println("Point constructor: " + this.toString());
	}
	public String toString(){
		return "[" + x + "," + y + "]";
	}
}
class Circle extends Point{ //Circle类继承Point类
	protected double radius;
	public Circle(){
		super(4,5);  //引用父类带参数的构造方法
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
		//建Circle对象，首先执行父类Point类的无参数构造方法
		//然后执行子类Circle类的构造方法
	}

}
