package TWO;
import java.util.Scanner;
class Point {
	private int x,y;
	public void setPoint(int a,int b){
		x = a;
		y = b;
	}
	public int getX(){return x;}
	public int getY(){return y;}
	public String toString(){
		return "[" + this.getX() + "," + this.getY() + "]";//引用类的方法
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int i, j;
		i = in.nextInt();
		j = in.nextInt();
		Point dot = new Point();
		dot.setPoint(i, j);
		System.out.println(dot.toString());
	}

}
