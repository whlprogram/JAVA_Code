package FOUR;
//�����ڼ̳и����Ա����ʱ��ֻ�̳и����Ա�з�˽�еĳ�Ա����
class Shape{
	public int x,y;
	private int m,n;
	public Shape(){ //����Shape�Ĺ��췽��
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
		Rectangle tt = new Rectangle(); //��������ʱҪ���ù��췽��
		tt.x = width;
		tt.y = height;
		//width = tt.m ����Rectangle���಻�ܼ̳и����˽�г�Ա������ֵ������������﷨����
		//height = tt.n ������ͬ
		//tt.show  //��������show()˽�з���
	}

}
