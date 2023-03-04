import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.text.html.HTMLEditorKit.Parser;

public class Client {

    private Client(){}

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        int port_num = Integer.parseInt(host);
        try {
            Registry registry = LocateRegistry.getRegistry(port_num);
            DoMagic stub = (DoMagic) registry.lookup("Do magic");
            String response = stub.matrixMultiply();
            System.out.println("Server responded: " + response);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    
    }
}
