package StrassenMatrixMultiplication;

public class strassenMatrixMultiplication {//Strassen矩阵乘法 课本P19
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//两个n*n的矩阵相乘，结果仍然是一个n*n矩阵
		int a[][] = {{0,1}
					,{2,3}};
		int b[][] = {{0,1}
					,{2,3}};
		strassenMatrixMultiplication1(a, b);
	}
	public static void strassenMatrixMultiplication1(int a[][], int b[][]){//2个2阶方阵乘法
		int M1 = a[0][0] * (b[0][1] - b[1][1]);
		int M2 = (a[0][0] + a[0][1]) * b[1][1];
		int M3 = (a[1][0] + a[1][1]) * b[0][0];
		int M4 = a[1][1] * (b[1][0] - b[0][0]);
		int M5 = (a[0][0] + a[1][1]) * (b[0][0] + b[1][1]);
		int M6 = (a[0][1] - a[1][1]) * (b[1][0] + b[1][1]);
		int M7 = (a[0][0] - a[1][0]) * (b[0][0] + b[0][1]);
		
		int C1 = M5 + M4 - M2 + M6;
		int C2 = M1 + M2;
		int C3 = M3 + M4;
		int C4 = M5 + M1 - M3 - M7;
		System.out.print(C1);
		System.out.println(" " + C2);
		System.out.print(C3);
		System.out.println(" " + C4);
	}
}
