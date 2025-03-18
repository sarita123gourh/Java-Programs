class Product2
{
	public static void main(String ar[])
	{
		int arr[]={1,2,3,4};
		int n=arr.length;
		int y[]=new int[n];
		
		int prefix=1;
		
		for(int i=0;i<n;i++)
		{
			y[i]=prefix;
			
			prefix*=arr[i];//24
		}
		int suffix=1;
		for(int i=n-1;i>=0;i--)
		{
			y[i]=y[i]*suffix;
			suffix=suffix*arr[i];
		}
		
		for(int k:y){System.out.println("\t"+k);}
	}
}