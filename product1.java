import java.util.*;
class product1
{
	public static void main(String ...sarita)
	{
		System.out.println(sarita[0]);
		
		int x[]={1,2,3,4};
		int n=x.length;
		int y[]=new int[n];
		
		Arrays.fill(y,1);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if (i != j) {
                    y[i] *= x[j];
                }
			}
		}
		for(int k:y)
		{
			System.out.println("\t"+k);
		}
	}
}