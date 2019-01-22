import java.rmi.*;
import java.rmi.server.*;
public class myApplicationServer extends UnicastRemoteObject implements myApplication  
{
	public myApplicationServer() throws RemoteException
	{
		super();
	}
	public String myMethod()
	{
		return " I am here to serve.\n";
	}
	public static void main(String[] args) 
	{
		String app="//localhost/myApplication";
		try
		{
			myApplicationServer server=new myApplicationServer();
			Naming.rebind(app,server);
		}
		catch (Exception error)
		{
			System.err.println("myApplicationServer Exception :"+error.getMessage());
		}
	}
}
