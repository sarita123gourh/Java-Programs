class Product3
{
	public static void main(String ar[])
	{
		int nums[]={1,2,3,4};
		int n=nums.length;
		
		int product=1;
		int countZero=0;
		for(int i=0;i<n;i++)
		{
			if(nums[i]==0)
			{
				countZero++;
				continue;
			}
			product=product*nums[i];
		}
		if(countZero>1)
			product=0;
		
		for(int i=0;i<n;i++)
		{
			if(nums[i]==0)
			{
				nums[i]=product;
			}
			else if(countZero==0)
			{
				nums[i]=product/nums[i];
			}
			else
				nums[i]=0;
		}
		for(int k:nums){System.out.println("\t"+k);}
	}
	
}