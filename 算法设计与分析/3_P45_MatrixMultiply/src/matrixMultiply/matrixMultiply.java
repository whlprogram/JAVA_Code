package matrixMultiply;

public class matrixMultiply {//����˷� �α�P45

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����a, b
		int A[][]={{1,2,3,4,5},
				   {1,2,3,4,5},
				   {1,2,3,4,5},
				   {1,2,3,4,5}};
		int B[][]={{5,4,3,2,1},
				   {5,4,3,2,1},
				   {5,4,3,2,1},
				   {5,4,3,2,1},
				   {5,4,3,2,1}};
		int C[][] = new int[A.length][B[0].length];
		MatrixMultiply(A, B, C, A.length, A[0].length, B.length, B[0].length);
		//�������c
		for(int i=0; i<C.length; i++){
			for(int j=0; j<C[0].length; j++){
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}
	}
	//ra,ca��rb,cb��ʾ����A��B������������ ��ά����C�洢A,B�˻�
	public static void MatrixMultiply(int a[][], int b[][], int c[][], int ra, int ca, int rb, int cb) {
		if(ca != rb) 
			System.out.println("���󲻿ɳ�");
		for(int i=0; i<ra; i++){
			for(int j=0; j<cb; j++){
				int sum = a[i][0]*b[0][j];
				for(int k=1; k<ca; k++)
					sum += a[i][k]*b[k][j];
				c[i][j] = sum;
			}
		}
	}

}
