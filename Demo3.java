class Demo3
{
	public static void main (String args[])
	{
		String s1="sarita";
		char c[]=s1.toCharArray();
		int i=0,j=c.length-1;
		
		for(;i<j;i++,j--)
		{
			char t=c[i];
			c[i]=c[j];
			c[j]=t;
		}
		for(char k:c)
		{
			System.out.print("\t"+k);
		}
	}
}