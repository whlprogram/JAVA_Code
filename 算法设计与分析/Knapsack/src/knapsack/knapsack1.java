package knapsack;

public class knapsack1 {

	public static void main(String[] args) {//0-1背包问题  P73
		// TODO 自动生成的方法存根
		int v[] = {0, 12, 10, 20, 15};
		int w[] = {0, 2, 1, 3, 2};
		int c = 5, n = 4;
		int m[][] = new int[5][6];
		int x[] = new int[n+1];
		Knapsack(v, w, c, n, m);
		Traceback(m, w, c, n, x);
		for(int i=1; i<x.length; i++)
			System.out.print(x[i]+",");
	}
	//v为价值数组,Vi(1 <= i <= n)  w为重量数组,Wi(1 <= i <= n)  c为背包容量  n为物品数量，若物品i，则1 <= i <= n
	public static void Knapsack(int v[], int w[], int c, int n,int m[][]){
		int jMax = min(w[n]-1, c);
		for(int j=0; j<=jMax; j++)//初始化m[n][j], 二维数组最下面一行
			m[n][j] = 0;
		for(int j=w[n]; j<=c; j++)//初始化m[n][j]
			m[n][j] = v[n];
		for(int i=n-1; i>1; i--){
			jMax = min(w[i]-1, c);
			for(int j=0; j<=jMax; j++)
				m[i][j] = m[i+1][j];
			for(int j=w[i]; j<=c; j++)
				m[i][j] = max(m[i+1][j], m[i+1][j-w[i]]+v[i]);		
		}
		m[1][c] = m[2][c];
		if(c >= w[1])
			m[1][c] = max(m[1][c], m[2][c-w[1]]+v[1]);
	}
	public static void Traceback(int m[][], int w[], int c, int n, int x[]){
		for(int i=1; i<n; i++)
			if(m[i][c] == m[i+1][c])
				x[i] = 0;
			else{
				x[i] = 1;
				c -= w[i];
			}
		x[n] = (m[n][c] != 0)?1:0;
	}
	public static int min(int x, int y){return x<y?x:y;}
	public static int max(int x, int y){return x>y?x:y;}

}
