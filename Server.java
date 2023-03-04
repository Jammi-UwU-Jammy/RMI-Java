import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements DoMagic{

    //public Server(){}

    @Override
    public String matrixMultiply(String matrixString1, String matrixString2) throws RemoteException {
        Parser parser = new Parser(matrixString1);
        Matrix firstMatrix = new Matrix(parser.getMatrix());

        Parser parser2 = new Parser(matrixString2);
        Matrix secondMatrix = new Matrix(parser2.getMatrix());

        Matrix resultMatrix = firstMatrix.multiply(secondMatrix);
        // resultMatrix.printMatrix();

        return resultMatrix.toString();
    }

    

    public static void main(String args[]){
        String host = (args.length < 1) ? null : args[0];
	    int port_num = Integer.parseInt(host);


        try {
            //System.setProperty("java.rmi.server.hostname","127.0.0.8000");
            Server obj = new Server();
            DoMagic stub = (DoMagic) UnicastRemoteObject.exportObject(obj, 0);
    
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry(port_num);
            registry.bind("Do magic", stub); 
    
            System.err.println("Server ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

    }

    
}
