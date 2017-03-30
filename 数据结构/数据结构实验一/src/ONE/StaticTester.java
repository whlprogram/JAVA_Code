package ONE;
class StaticTest{
	public int x = 1;
	public static int y = 1;  //static
}
public class StaticTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		StaticTest.y = StaticTest.y + 1;
		StaticTest m = new StaticTest();
		StaticTest n = new StaticTest();
		m.x = m.x + 3;
		m.y = m.y + 3;
		n.x = n.x + 5;
		n.y = n.y + 5;	
		System.out.println("m.x=" + m.x + " " + "m.y=" + m.y);
		System.out.println("n.x=" + n.x + " " + "n.y=" + n.y);
	}

}
