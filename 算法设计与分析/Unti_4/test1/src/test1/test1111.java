package test1;

import java.util.Scanner;

public class test1111 {

	//���룺9 800 1030 900 1130 700 1100 1130 1400 1200 1330 1300 1530 1500 1600 1430 1600 1600 1800
	//�����1 0 0 0 1 0 1 0 1
		
	//���룺 11 1 4 3 5 0 6 5 7 3 8 5 9 6 10 8 11 8 12 2 13 12 14
	//���: 1 0 0 1 0 0 0 1 0 0 1
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int s[] = new int[n+1];
		int f[] = new int[n+1];
		int a[] = new int[n+1];
		for(int i=1; i<=n; i++){
			s[i] = scan.nextInt();
			f[i] = scan.nextInt();
		}
		for(int i=0; i<=n; i++)
			a[i] = i;		
		sort(s, f, a);
		greedy(s, f, a);
		int t[] = new int[n+1];
		for(int i=1; i<=n; i++){
			if(a[i] < 0){
				int temp = -a[i];
				t[temp] = 1;
			}
		}
		for(int i=1; i<=n; i++)
			System.out.print(t[i] + " ");
	}
	public static void greedy(int s[], int f[], int a[]){
		a[1] = -a[1];
		int j = 1;
		for(int i=2; i<f.length; i++){
			if(s[i] >= f[j]){
				a[i] = -a[i];
				j = i;
			}
		}
		
	}
	public static void sort(int s[], int f[], int a[]){
		for(int i=1; i<f.length-1; i++){
			for(int j=i+1; j<f.length; j++){
				if(f[i] > f[j]){
					int temp = f[j];
					f[j] = f[i];
					f[i] = temp;
					
					int temp1 = s[j];
					s[j] = s[i];
					s[i] = temp1;
					
					int temp2 = a[j];
					a[j] = a[i];
					a[i] = temp2;
				}
			}
		}
	}
}
		


