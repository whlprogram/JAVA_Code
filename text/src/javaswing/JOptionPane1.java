package javaswing;
import javax.swing.JOptionPane;
public class JOptionPane1 {
	public static void main(String[] args) {
		String A;
		String B;
		int a1;
		int a2;
		int sum;
		A = JOptionPane.showInputDialog("Enter First Number");
		B = JOptionPane.showInputDialog("Enter Second Number");
		
		a1 = Integer.parseInt(A);
		a2 = Integer.parseInt(B);
		sum = a1 + a2;
		JOptionPane.showMessageDialog(null, "The sum is "+sum, "Results",JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0);
		

	}

}
