package FOUR;
//子类在继承父类成员变量时，只继承父类成员中非私有的成员变量
class Shape{
	public int x,y;
	private int m,n;
	public Shape(){ //父类Shape的构造方法
		x = 10;
		y = 20;
		m = 100;
		n = 200;
		System.out.println("x=" + x + " " +"y=" + y);
		System.out.println("this is a Constractor of shape");
	}
	public void measure(){
		int s;
		s= x*y;
		System.out.println("result=" + s);
	}
	private void show(){
		System.out.println("x=" + x + " " + "y=" + y);
	}
}
public class Rectangle extends Shape {
//class Rectangle extends Shape{}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 30,height = 10;
		Rectangle tt = new Rectangle(); //创建对象时要引用构造方法
		tt.x = width;
		tt.y = height;
		//width = tt.m 对于Rectangle子类不能继承父类的私有成员变量的值，此语句会产生语法错误
		//height = tt.n 与上相同
		//tt.show  //不能引用show()私有方法
	}

}
