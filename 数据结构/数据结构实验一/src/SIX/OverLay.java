package SIX;
class Shape{
	public int y;
	public Shape(){
		y = 20;
		System.out.println("this is a Constractor of shape");
	}
	public void measure(){
		System.out.println("super y= " + y);
	}
}
class Rectangle extends Shape{
	public int y;
	public void measure(){
		super.measure();  //引用父类的measure()方法
		y = super.y + y;
		System.out.println("Shape.y= " + super.y); //引用父类的成员变量y
		System.out.println("Rectangle.y= " + y);   //引用子类的成员变量y
	}
}
public class OverLay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 30,height = 10;
		Rectangle tt = new Rectangle();
		tt.y = height;  //将height变量的值10赋值给子类的成员变量y
		tt.measure();   //引用子类的measure()方法
	}

}
