package test;



	import java.util.Scanner;

	public class test 
	{	
	    public static void main(String[] args)
		{
	    	Scanner sc=new Scanner(System.in);
			int  n=sc.nextInt();
			int p[]=new int[n+1];//�ɹ��ļ���
			int q[]=new int[n+1];//ʧ�ܵļ���
			int s[][]=new int[n+2][n+1];//��ѽڵ�
			int w[][]=new int[n+2][n+1];
			int m[][]=new int[n+2][n+1];
			for (int i = 1; i <=n; i++)
			{
			   p[i]=sc.nextInt();
			}
			for (int i = 0; i <= n; i++)
			{
			  q[i]=sc.nextInt();
			}
			bost(n, p, q, w, m, s);
			
			System.out.println("----------");
			for(int i=0; i<s.length; i++){
				for(int j=0; j<s[0].length; j++)
					System.out.print(s[i][j] + " ");
				System.out.println();
			}
			System.out.println("----------");
			
			T(1,n, s);//���Ž�
			
		}

		//�����Ŷ������������Ե����Ϸǵݹ�Ķ�̬�滮�㷨��
		public static void bost(int n,int p[],int q[],int w[][],int m[][],int s[][])
		{
			for (int i = 0; i<=n; i++)
		    {
				//5  15  10  5  10  20  5  10  5  5  5  10
				w[i+1][i]=q[i];
				m[i+1][i]=q[i];
			}
		    for(int r = 0;r <n; r++)
		    {
				for(int i =1; i <=n-r; i++)
				{
					int j=i+r;
					w[i][j]=w[i][j-1]+p[j]+q[j];
					m[i][j]=m[i][i-1]+m[i+1][j];
					s[i][j]=i;
					for(int k = i+1; k <= j; k++)
					{
						int t= m[i][k-1]+m[k+1][j];
						if(t<m[i][j])
						{
							m[i][j]=t;
							s[i][j]=k;
						}
				     }
					 m[i][j]+=w[i][j];
				 }
			  }
		}
		public static void T(int i,int j,int s[][])//�������Ž�
		{
			if(j>i)
			{
		        int root=s[i][j];//���ڵ�
		        System.out.println("s"+root+"�Ǹ�");
		        if (s[i][root-1]>0)
		        {
		        	System.out.println("s"+root+"��������s"+s[i][root-1]);
		    	}
		        if (s[root+1][j]>0)
		        {
		           	System.out.println("s"+root+"���Һ�����s"+s[root+1][j]);
		    	}
		        T(i, root-1, s);
		        T( root+1, j, s);       
			  }
		}

	}


