import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DoMagic extends Remote{
    String matrixMultiply() throws RemoteException;
}
