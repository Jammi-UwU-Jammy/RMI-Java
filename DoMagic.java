import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DoMagic extends Remote{
    String matrixMultiply(Matrix matrix1, Matrix matrix2) throws RemoteException;
}
