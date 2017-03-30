package FIVE;
class SuperA{
	private int privateData = 10;
	public int pubSuperData;
	private void privateMethod(){
		System.out.println("super privateData=" + privateData);
		System.out.println("Super class's privateMethod");
	}
	public void pubSuperMethod(){
		privateMethod();
		System.out.println("Super class's pubSuperMethod");
	}
}
class SubB extends SuperA{
	private int privateData = 20;
	private void privateMethod(){
		System.out.println("sub privateData=" + privateData);
		System.out.println("Subclass's privateMethod");
	}
	public void pubSubMethod(){
		privateMethod();
		super.pubSuperMethod();  //this（）是调用自己其他的构造函数，super()是调用自己继承的父类的构造函数
		System.out.println("Subclass's publicSubMethod");
	}
}
public class ExtendTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubB t = new SubB();
		t.pubSubMethod();
	}

}
