package greedySelector;

import java.util.Scanner;

public class GreedySelector {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//9 800 1030 900 1130 700 1100 1130 1400 1200 1330 1300 1530 1500 1600 1430 1600 1600 1800
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t[] = new int[n+1];//活动序号
		int s[] = new int[n+1];//起始时间
		int f[] = new int[n+1];//终止时间
		int a[] = new int[n+1];//记录活动安排
		s[0] = 0; f[0] = 0; 
		for(int i=0; i<=n; i++)
			t[i] = i;
		for(int i=1; i<=n; i++){
			s[i] = scan.nextInt();
			f[i] = scan.nextInt();
		}
		bubbleSort(s, f, t);
		greedySelector(s, f, t);
		for(int i=1; i<t.length; i++){
			if(t[i] < 0){
				int temp = -t[i];
				a[temp] = 1;
			}		
		}
		for(int i=1; i<t.length; i++){
			System.out.print(a[i] + " ");		
		}	
	}
	public static void greedySelector(int s[], int f[], int t[]){
	    t[1]= -t[1]; //加入最早结束的活动
	    int j=1;     //刚加入集合的活动号
	    for (int i=2; i<s.length; i++){
	        if (s[i]>=f[j]){
	        	t[i]= -t[i];
	        	j=i; //j用以记录最近一次加入到集合A中的活动
	        }
	    }
	}
	public static void bubbleSort(int s[], int f[], int t[]){//冒泡排序算法   
        for(int i=1;i<f.length-1;i++){   
           for(int j=i+1;j<f.length;j++){   
               if (f[i]>f[j]){   
                   int temp=f[i];   
                   f[i]=f[j];   
                   f[j]=temp;
                   
                   int temp1=s[i];   
                   s[i]=s[j];   
                   s[j]=temp1;
                   
                   int temp2=t[i];   
                   t[i]=t[j];   
                   t[j]=temp2;
               }   
           }  
        }   
	}
}
