package test;

import java.util.Scanner;

public class test4 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int p[] = new int[n+1];
		p[0] = 0;
		for(int i=1; i<=n; i++)
			p[i] = scan.nextInt();
		int q[] = new int[n+1];
		for(int i=0; i<=n; i++)
			q[i] = scan.nextInt();
		int m[][] = new int[n+2][n+1];
		int w[][] = new int[n+2][n+1];
		int s[][] = new int[n+2][n+1];
		BBST(n, p, q, m, w, s);
		t(1, n, s);
	}
	public static void BBST(int n, int p[], int q[], int m[][], int w[][], int s[][]){
		for(int i=0; i<=n; i++){
			m[i+1][i] = 0;
			w[i+1][i] = q[i];
		}
		for(int r=0; r<n; r++){
			for(int i=1; i<=n-r; i++){
				int j=i+r;
				m[i][j] = m[i][i-1] + m[i+1][j];
				w[i][j] = w[i][j-1] + p[j] + q[j];
				s[i][j] = i;
				for(int k=i+1; k<=j; k++){
					int t = m[i][k-1] + m[k+1][j];
					if(t < m[i][j]){
						m[i][j] = t;
						s[i][j] = k;
					}
				}
				m[i][j] += w[i][j];
			}
		}
	}
	public static void t(int i, int j, int s[][]){
		if(i<j){
			int root = s[i][j];
			System.out.println("s" + root + "是根");
			if(s[i][root-1]>0)
				System.out.println("s" + root + "的左孩子是" + "s" + s[i][root-1]);
			if(s[root+1][j]>0)
				System.out.println("s" + s[i][j] + "的左孩子是" + "s" + s[root+1][j]);
			t(i, root-1, s);
			t(root+1, j, s);
		}
	}
	

}
