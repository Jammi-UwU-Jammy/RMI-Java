import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DoMagic extends Remote{
    String matrixMultiply(String matrix1, String matrix2) throws RemoteException;
}
