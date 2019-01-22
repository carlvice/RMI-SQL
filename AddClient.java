import java.rmi.*;
import java.io.*;

public class AddClient
{
	public static void main(String[] args) 
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter IP/Name of server");
			String IP=br.readLine();
			System.out.println("Enter Two Numbers");
			int x=Integer.parseInt(br.readLine());
			int y=Integer.parseInt(br.readLine());
			String url="rmi://"+IP+"/AddServer";
			Addition addy=(Addition)Naming.lookup(url);
			System.out.println("Sum is "+addy.sum(x,y));
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
