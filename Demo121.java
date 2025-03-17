class A
{
	static A a;
	private A(){}
	
	static A getObject()
	{
		if(a==null)
		{
			synchronized(A.class)
			{
		      if(a==null)
		        {
			      a=new A();
		        }
			}
			
		}
		return a;
	}
}
class Demo121
{
	public static void main(String ar[])
	{
		A a=A.getObject();
		A a1=A.getObject();
		
		System.out.println(a.hashCode());
		System.out.println(a1.hashCode());
		
	}
}