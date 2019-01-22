import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
public class SqlSerialServer extends UnicastRemoteObject implements SqlInfo 
{
	Connection con;
	Statement stmt;
	ResultSet rst;
	String id,name,address,branch,qry;
	int age;
	public SqlSerialServer()throws RemoteException
	{
		super();	
	}
	public void insert(String s1,String s2,String s3,String s4,int a)
	{
		id=s1;
		name=s2;
		address=s3;
		branch=s4;
		age=a;
		qry="insert into serial values('"+id+"','"+name+"',"+age+",'"+address+"','"+branch+"');";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/client","root","123");
			stmt=con.createStatement();
			stmt.executeUpdate(qry);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void fetch()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/client","root","123");
			qry="select * from serial where id="+id;
			rst=stmt.executeQuery(qry);
			while(rst.next())
			{
				id=rst.getString(1);
				name=rst.getString(2);
				age=rst.getInt(3);
				address=rst.getString(4);
				branch=rst.getString(5);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Values are :\n Id = "+id+"\n Name = "+name+"\n Age = "+age+"\n Address = "+address+"\n Branch = "+branch);
	}
	public static void main(String[] args) 
	{
		try
		{
			SqlSerialServer sql=new SqlSerialServer();
			Naming.rebind("SqlServer",sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
