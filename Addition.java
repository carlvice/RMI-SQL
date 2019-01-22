import java.rmi.*;

public interface Addition extends Remote
{
	int sum(int a,int b) throws RemoteException;
} 