class Demo1
{
	public static void main(String ar[])
	{
		int x[]={1,3,4,9};
		int y[]={2,5,7,8};
		int n=x.length;
		int m=y.length;
		int z[]=new int[n+m];
		int i,j,k;
		
		for(i=0,j=0,k=0;k<n+m;k++)
		{
			// if(i==n)
			// {
			   // z[k]=y[j++];
			// }
			// else if(j==m)
			// {
				// z[k]=x[i++];
			// }
			// else 
				if(x[i]<y[j])
			{
				z[k]=x[i++];
			}
			else
			{
				z[k]=y[j++];
			}
				
		}
		for(int h:z)
		{
			System.out.print("\t"+h);
		}
	}
	
}