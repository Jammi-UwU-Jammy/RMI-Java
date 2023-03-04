import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {

    private Client(){}

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        int port_num = Integer.parseInt(host);
        try {
            Registry registry = LocateRegistry.getRegistry(port_num);
            DoMagic stub = (DoMagic) registry.lookup("Do magic");

            // Matrix matrix1 = new Matrix(new float[][]{{1,2,3}, {4,5,6}});
            // Matrix matrix2 = new Matrix(new float[][]{{1,2}, {4,5}, {6,7}});

            // String response = stub.matrixMultiply(matrix1, matrix2);
            String response = "";
            System.out.println("Server responded: " + response);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    
    }
}
