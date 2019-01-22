import java.rmi.*;
public class myApplicationClient
{
	public static void main(String[] args) 
	{
		try
		{
			String app= "//localhost/myApplication";
			myApplication mApp=(myApplication) Naming.lookup(app);
			System.out.println(mApp.myMethod());
		}
		catch (Exception error)
		{
			System.err.println("myApplicationClient exception : " +error.getMessage());
		}
	}
}
