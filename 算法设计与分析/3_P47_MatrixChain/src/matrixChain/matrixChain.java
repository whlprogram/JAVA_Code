package matrixChain;


public class matrixChain {//矩阵连乘 最优解 P47

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A1=30*35 A2=35*15 A3=15*5 A4=5*10 A5=10*20 A6=20*25 
//		int p[] = {30, 35, 15, 5, 10, 20, 25};
//		int n = 6;
		int p[] = {20, 25, 10, 5, 15, 20};
		int n = 5;
		int m[][] = new int[n+1][n+1];
		int s[][] = new int[n+1][n+1];
		
		int s1[][] = new int[n+1][n+1];
		
		int m2[][] = new int[n+1][n+1];
		int s2[][] = new int[n+1][n+1];
		
		MatrixChain(p, n, m, s);//非递归
		t(1, n, s);
		System.out.println();
		RecurMatrixChain(1, n, p, s1);//自底向上 递归 动态规划
		t(1, n, s1);
		System.out.println();
		MemoizedMatrixChain(n, m2, s2, p);//自顶向下 递归 动态规划
		t(1, n, s2);
//		System.out.println("输出最优解数组");
//		for(int i=1; i<m.length; i++){
//			for(int j=1; j<m[0].length; j++)
//				System.out.print(m[i][j] + "   ");
//			System.out.println();
//		}
//		System.out.println("输出最优断开位置数组");
//		for(int i=1; i<s.length; i++){
//			for(int j=1; j<s[0].length; j++)
//				System.out.print(s[i][j]+" ");
//			System.out.println();
//		}	
	}
	//输出计算最优计算次序,逗号分离 课本P48
	public static void Traceback(int i, int j, int s[][]) {
		if(i==j) return;
		Traceback(i, s[i][j], s);
		Traceback(s[i][j]+1, j, s);
		System.out.println("(A" + i + "," + s[i][j] + ")*(A" + (s[i][j]+1) + "," + j + ")");
	}
	//输出计算最优计算次序,括号分离
	public static void t(int i, int j, int s[][]) {
		if (i == j)
			System.out.print("A" + i);
		else if (i + 1 == j)
			System.out.print("(A" + i + "*" + "A" + j + ")");
		else {	
			System.out.print("(");
			t(i, s[i][j], s);
			System.out.print("*");
			t(s[i][j]+1, j, s);
			System.out.print(")");
		}
	}
	//非递归方法
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
	//自底向上 递归 动态规划 课本P49
	public static int RecurMatrixChain(int i, int j, int p[], int s[][]) {
		if(i==j) return 0;
		int u = RecurMatrixChain(i, i, p, s) + RecurMatrixChain(i+1, j, p, s) + p[i-1]*p[i]*p[j];
		s[i][j] = i;
		for(int k=i+1; k<j; k++){
			int t = RecurMatrixChain(i, k, p, s) + RecurMatrixChain(k+1, j, p, s) + p[i-1]*p[k]*p[j];
			if(t < u){
				u = t;
				s[i][j] = k;
			}
		}
		return u;
	}
	//自顶向下 递归 动态规划 课本P51
	public static int MemoizedMatrixChain(int n, int m[][], int s[][], int p[]) {
		for(int i=1; i<=n; i++)
			for(int j=i; j<=n; j++)
				m[i][j] = 0;
		return LookupChain(1, n, m, s, p);
	}
	public static int LookupChain(int i, int j, int m[][], int s[][], int p[]){
		if(m[i][j] > 0) return m[i][j];
		if(i==j) return 0;
		int u = LookupChain(i, i, m, s, p) + LookupChain(i+1, j, m, s, p) + p[i-1]*p[i]*p[j];
		s[i][j] = i;
		for(int k=i+1; k<j; k++){
			int t = LookupChain(i, k, m, s, p) + LookupChain(k+1, j, m, s, p) + p[i-1]*p[k]*p[j];
			if(t < u){
				u = t;
				s[i][j] = k;
			}
		}
		m[i][j] =u;
		return u;
	}

}
