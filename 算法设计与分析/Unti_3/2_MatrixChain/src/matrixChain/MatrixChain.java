package matrixChain;

import java.util.Scanner;

public class MatrixChain {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p[] = new int[n+1];
        for(int i=0; i<=n; i++)
        	p[i] = scan.nextInt();
//		int n = 6;
//		int p[] = {30, 35, 15, 5, 10, 20, 25};
        //非递归
        int m[][] = new int[n+1][n+1];
        int s[][] = new int[n+1][n+1];
        MatrixChain1(p, n, m, s);
		t(1, n, s);
		System.out.println();
		String sss = traceBack(1, n, s);
		System.out.println(sss);
		//自底向上 递归 动态规划
        int s1[][] = new int[n+1][n+1];
		RecurMatrixChain(1, n, p, s1);
		t(1, n, s1);
		System.out.println();
		//自顶向下 递归 动态规划
		int m2[][] = new int[n+1][n+1];
		int s2[][] = new int[n+1][n+1];
		MemoizedMatrixChain(n, m2, s2, p);
		t(1, n, s2);
	}
	//输出计算最优计算次序,括号分离
	public static void t(int i, int j, int s[][]) {
		if (i == j)
			System.out.print("A" + i);
		else {	
			System.out.print("(");
			t(i, s[i][j], s);
			t(s[i][j]+1, j, s);
			System.out.print(")");
		}
	}
	public static String traceBack(int i,int j,int s[][]){
		if(i==j){
		      return "A"+i;
		}
		else{
		       return"("+traceBack(i,s[i][j],s)+traceBack(s[i][j]+1,j,s)+")";
		}
	}
	//非递归方法
	//一维数组P存储n个矩阵的行列值, 二维数组m存储最优值, 二维数组s记录最优断开位置
	public static void MatrixChain1(int p[], int n, int m[][], int s[][]){
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
	//一维数组P存储n个矩阵的维数值, 二维数组s记录最优断开位置
	//自底向上 递归 动态规划
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
	//一维数组P存储n个矩阵的维数值, 二维数组m存储最优值, 二维数组s记录最优断开位置
	//自顶向下 递归 动态规划(备忘录方法)
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
