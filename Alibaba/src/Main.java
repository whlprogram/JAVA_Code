import java.util.Scanner;

/**
 */
public class Main {

    //private static final int MAX_PATH_LENGTH = 65535;


    public static void main(String[] args) {
        //输入
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();//n个组
        int m = scanner.nextInt();//m条约束关系
        int[][] arr = new int[m+1][3];
        int len = m+1;
        for(int i=1; i<len; i++){
        	arr[i][0] = 0;
        	arr[i][1] = scanner.nextInt();
        	arr[i][2] = scanner.nextInt();
        }
        for(int i=1; i<len-1; i++){
        	for(int j=i+1; j<len; j++){
            	if(arr[i][1] > arr[j][1]){
            		int temp1 = arr[i][1];
            		int temp2 = arr[i][2];
            		
            		arr[i][1] = arr[j][1];
            		arr[i][2] = arr[j][2];
            		
            		arr[j][1] = temp1;
            		arr[j][2] = temp2;
            	}
            }
        }
        int count = 0;
        int boo = 0;
        for(int i=1; i<len; i++){
        	if(arr[i][0] != 0)
        		continue;
        	fun(arr, i, arr[i][1], count, m);
        	if(count >= 3){
        		System.out.print("no");
        		boo = 1;
        		break;
        	}
        		
        }
        if(boo == 0)
        	System.out.print("yes");
    }

    private static void fun(int[][] arr, int x, int flag, int count, int m) {
        count++;
        arr[x][0] = 1;
        if(arr[arr[x][2]][2] == flag)
        	return;
        if(x == m)
        	return;
        fun(arr, arr[x][2], flag, count, m);
        
    }

  

}
