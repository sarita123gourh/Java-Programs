class Demo2
{
	public static void main(String ar[])
	{
		int x[]={5,4,3,2,1};
		int n=x.length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(x[j]>x[j+1])
				{
					int t=x[j];
					x[j]=x[j+1];
					x[j+1]=t;
				}
			}
		}
		for (int num : x) {
            System.out.print(num + " ");
        }
	}
}