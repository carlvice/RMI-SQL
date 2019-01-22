import java.rmi.*;
import java.io.*;

public class SqlSerialClient
{
	public static void main(String[] args) 
	{
		try
		{
			String id,name,address,branch,url,ip;
			int age;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter IP");
			ip=br.readLine();
			System.out.println("Enter Id");
			id=br.readLine();
			System.out.println("Enter Name");
			name=br.readLine();
			System.out.println("Enter Age");
			age=Integer.parseInt(br.readLine());
			System.out.println("Enter Address");
			address=br.readLine();
			System.out.println("Enter Branch");
			branch=br.readLine();
			url="rmi://"+ip+"/SqlServer";
			SqlInfo sql=(SqlInfo)Naming.lookup(url);
			sql.insert(id,name,address,branch,age);
			sql.fetch();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
