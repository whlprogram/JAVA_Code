import java.util.Arrays;
public class seqList {
	
	
	int[] a1 ={23,45,67,89,90,123,145};
	int[] a2 ={1,34,65,88,98,123,146,234,366};
	int a1l = a1.length;
	int a2l = a2.length;
	//int[] sort = new int[a1l+a2l];
	int[] sort = new int[a1.length+a2.length];

	for(int i=0;i
	{
		if(i 
				sort[i] = a2[i];
		else
			sort[i] = 0;
	}
	for(int j=a2l;j
	{
		sort[j] = a1[j-a2l];
	}
	Arrays.sort(sort);

	//
	for(int k=0;k System.out.print(sort[k]+" ");
	}
	

}
