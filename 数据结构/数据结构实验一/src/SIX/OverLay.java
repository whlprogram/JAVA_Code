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
		super.measure();  //���ø����measure()����
		y = super.y + y;
		System.out.println("Shape.y= " + super.y); //���ø���ĳ�Ա����y
		System.out.println("Rectangle.y= " + y);   //��������ĳ�Ա����y
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
		tt.y = height;  //��height������ֵ10��ֵ������ĳ�Ա����y
		tt.measure();   //���������measure()����
	}

}
