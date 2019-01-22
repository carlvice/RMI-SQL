import java.rmi.*;
public interface SqlInfo extends Remote
{
	void insert(String id,String name,String address,String branch,int age);
	void fetch();
}