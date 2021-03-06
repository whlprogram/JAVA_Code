package bestBinarySearchTree;

import java.util.Scanner;

public class BestBinarySearchTree {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner sc=new Scanner(System.in);
		//结点的个数
		int n = sc.nextInt();
		//成功的概率
		int p[]=new int[n+1];
		//失败的概率
		int q[]=new int[n+1];
		//保存最优子树T(i, j)的根节点元素
		int s[][]=new int[n+2][n+1];
		//保存最优子树T(i, j)的平均搜索次数(平均步长)(检索开销)
		int m[][]=new int[n+2][n+1];
		//保存最优子树T(i, j)的概率和
		int w[][]=new int[n+2][n+1];
		
		p[0] = 0;
		for (int i = 1; i <=n; i++)
		   p[i]=sc.nextInt();
		for (int i = 0; i <= n; i++)
		   q[i]=sc.nextInt();
		//OBST(q, p, n, m, s, w);
		bost(p, q, n, m, s, w);
//		System.out.println("----------");
//		for(int i=0; i<s.length; i++){
//			for(int j=0; j<s[0].length; j++)
//				System.out.print(m[i][j] + " ");
//			System.out.println();
//		}
//		System.out.println("----------");
//		for(int i=0; i<s.length; i++){
//			for(int j=0; j<s[0].length; j++)
//				System.out.print(s[i][j] + " ");
//			System.out.println();
//		}
//		System.out.println("----------");
		
		Tree(1, n, s);//最优二叉查找树输出
	}
	//最优二叉搜索树的自底向上非递归的动态规划算法
	//结点的个数 n
	//成功的概率p[]
	//失败的概率q[]
	//保存最优子树T(i, j)的根节点元素s[][]
	//保存最优子树T(i, j)的平均搜索次数(平均步长)(检索开销)m[][]
	//保存最优子树T(i, j)的概率和w[][]
	public static void bost(int p[], int q[], int n, int m[][], int s[][], int w[][]){
		for (int i = 0; i<=n; i++){
			//5  p[]=(15  10  5  10  20)  q[]=(5  10  5  5  5  10)
			w[i+1][i]=q[i];//
			m[i+1][i]=0;
		}
	    for(int r=0; r<n; r++){//起始元素和终止元素的间隔
			for(int i=1; i<=n-r; i++){
				int j=i+r;
				w[i][j]=w[i][j-1]+p[j]+q[j];
				m[i][j]=m[i][i-1]+m[i+1][j];//m[i][i-1]表示左子树的检索开销 为0  i不可能到i-1的位置
//				m[i][j]=m[i+1][j] 
				s[i][j]=i;
				for(int k=i+1; k<=j; k++){
					int t= m[i][k-1]+m[k+1][j];
					if(t<m[i][j]){
						m[i][j]=t;
						s[i][j]=k;
					}
			     }
				 m[i][j]+=w[i][j];
			 }
		  }
	}
	//改进的算法  时间复杂度O(n^2) 构造最优解
	public static void OBST(int a[], int b[], int n, int m[][], int s[][], int w[][]){
		for(int i=0; i<=n; i++){
			w[i+1][i] = b[i];
			m[i+1][i] = 0;
			s[i+1][i] = 0;
		}
		for(int r=0; r<n; r++){
			for(int i=1; i<=n-r; i++){
				int j = i+r;
				int il = s[i][j-1]>i ? s[i][j-1] : i;
				int jl = s[i+1][j]>i ? s[i+1][j] : j;
				w[i][j] = w[i][j-1] + a[j] + b[j];
				m[i][j] = m[i][il-1] + m[il+1][j];
				s[i][j] = il;//
				for(int k=il+1; k<=jl; k++){
					int t = m[i][k-1] + m[k+1][j];
					if(t <= m[i][j]){
						m[i][j] = t;
						s[i][j] = k;
					}	
				}
				m[i][j] += w[i][j];
			}
		}
	}
	//实现输出
	public static void Tree(int i,int j,int s[][]){
		if(j>i){
	        int root=s[i][j];//根节点
	        System.out.println("s"+root+"是根");
	        if (s[i][root-1]>0)
	        	System.out.println("s"+root+"的左孩子是s"+s[i][root-1]);
	        if (s[root+1][j]>0)
	           	System.out.println("s"+root+"的右孩子是s"+s[root+1][j]);
	        Tree(i, root-1, s);
	        Tree( root+1, j, s);       
		  }
	}

}
