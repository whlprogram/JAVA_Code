package EIGHT;
class A{
	String s = "class:A";
}
class B extends A{    //B��̳�A��
	String s = "class:B";
}
public class TypeV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b1,b2 = new B();
		A a1,a2;
		a1 = (A)b2;   //����Ķ�������Զ�ת��Ϊ����Ķ���
		a2 = b2;
		System.out.println(a1.s);
		System.out.println(a2.s);
		b1 = (B)a1;
		System.out.println(b1.s);
	}

}
