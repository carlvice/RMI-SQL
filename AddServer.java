import java.rmi.*;
import java.rmi.server.*;
public class AddServer extends UnicastRemoteObject implements Addition 
{
	public AddServer() throws RemoteException
	{}
	public int sum(int a,int b)
	{
			return a+b;
	}
	public static void main(String args[])
	{
		
		try
		{
			
			AddServer as=new AddServer();
			Naming.rebind("AddServer",as);		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
