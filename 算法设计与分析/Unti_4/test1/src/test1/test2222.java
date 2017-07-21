package test1;

import java.util.Scanner;

public class test2222 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double c = scan.nextDouble();
		int id[] = new int[n+1];
		double w[] = new double[n+1];
		double v[] = new double[n+1];
		double x[] = new double[n+1];
		for(int i=1; i<=n; i++){
			id[i] = i;
			w[i] = scan.nextDouble();
		}
		for(int i=1; i<=n; i++){
			v[i] = scan.nextDouble();
			x[i] = v[i]/w[i];
		}
		double a[] = new double[n+1];
		double b[] = new double[n+1];
		sort(id, w, x);
		knap(c, id, w, x, a);
		for(int i=1; i<=n; i++){
			if(id[i] < 0){
				int temp = -id[i];
				b[temp] = a[i];
			}
		}
		for(int i=1; i<=n; i++)
			System.out.print(b[i] + " ");
	}
	public static void knap(double c, int id[], double w[], double x[], double a[]){
		int i;
		for(i=1; i<x.length; i++){
			if(c < w[i])
				break;
			id[i] = -id[i];
			a[i] = 1.0;
			c -= w[i];
		}
		if(i < x.length){
			id[i] = -id[i];
			a[i] = c/w[i];
		}	
	}
	public static void sort(int id[], double w[], double x[]){
		for(int i=1; i<x.length-1; i++){
			for(int j=i+1; j<x.length; j++){
				if(x[i] < x[j]){
					double temp = x[j];
					x[j] = x[i];
					x[i] = temp;
					
					int temp1 = id[j];
					id[j] = id[i];
					id[i] = temp1;
					
					double temp2 = w[j];
					w[j] = w[i];
					w[i] = temp2;
				}
			}
		}
	}

}
