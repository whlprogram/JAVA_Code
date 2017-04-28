package matrixChain;


public class matrixChain {//矩阵连乘 最优解 P47

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A1=30*35 A2=35*15 A3=15*5 A4=5*10 A5=10*20 A6=20*25 
		//int p[] = {30, 35, 15, 5, 10, 20, 25};
		int p[] = {20, 25, 10, 5, 15, 20};
		//int n = 6;
		int n = 5;
		int m[][] = new int[n+1][n+1];
		int s[][] = new int[n+1][n+1];
		MatrixChain(p, n, m, s);
		System.out.println("输出最优解数组");
		for(int i=1; i<m.length; i++){
			for(int j=1; j<m[0].length; j++)
				System.out.print(m[i][j] + "   ");
			System.out.println();
		}
		System.out.println("输出最优断开位置数组");
		for(int i=1; i<s.length; i++){
			for(int j=1; j<s[0].length; j++)
				System.out.print(s[i][j]+" ");
			System.out.println();
		}
		Traceback(1, 5, s);
	}
	//输出计算最优计算次序,逗号分离
	public static void Traceback(int i, int j, int s[][]) {
		if(i==j) return;
		Traceback(i, s[i][j], s);
		Traceback(s[i][j]+1, j, s);
		System.out.println("(A" + i + "," + s[i][j] + ")*(A" + (s[i][j]+1) + "," + j + ")");
	}
	//一维数组P存储n个矩阵的行列值, 二维数组m存储最优值, 二维数组s记录最优断开位置
	public static void MatrixChain(int p[], int n, int m[][], int s[][]){
		for(int i=1; i<=n; i++)//单个矩阵
			m[i][i] = 0;
		for(int r=2; r<=n; r++){//多个矩阵
			for(int len=1; len<=n-r+1; len++){
				int j = len + r -1;
				m[len][j] = m[len+1][j] +p[len-1]*p[len]*p[j];
				s[len][j] = len;
				for(int k=len+1; k<j; k++){
					int t = m[len][k] + m[k+1][j] + p[len-1]*p[k]*p[j];
					if(t < m[len][j]){
						m[len][j] = t;
						s[len][j] = k;
					}
				}
			}
		}
	}

}
