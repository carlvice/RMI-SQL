import java.rmi.*;
public interface myApplication extends Remote
{
	String myMethod() throws RemoteException;
}