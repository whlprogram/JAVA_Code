package IntegerDivision;

public class integerDivision {//整数划分 课本P14

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();//快捷键 先输入sysout，然后 快捷键：Alt+/
		System.out.println(q(6, 4));
		System.out.println();
	}
	public static int q(int n, int m){
		if(n<1 || m<1)
			return 0;
		if(n==1 || m==1)
			return 1;
		if(n < m)
			return q(n, n);
		if(n == m)
			return q(n, m-1)+1;
		//n>m>1 正整数n的最大加数n1不大于m的划分由n1 = m的划分和n1 <= m-1的划分组成
		return q(n, m-1)+ q(n-m, m);
		
	}

}
