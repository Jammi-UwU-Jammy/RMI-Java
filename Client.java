import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class Client {

    private Client(){}
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        int port_num = Integer.parseInt(host);
        try {
            Registry registry = LocateRegistry.getRegistry(port_num);
            DoMagic stub = (DoMagic) registry.lookup("Do magic");


            System.out.println("First matrix: column separated by semicolon, \nEx: 1,2,3 ; 4,5,6 ; 7,8,9 ");
            String firstMatrix = sc.nextLine();
            System.out.println("Second matrix: ");
            String secondMatrix = sc.nextLine();

            String response = stub.matrixMultiply(firstMatrix, secondMatrix);
            System.out.println("Server responded: " + response);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        sc.close();
    }
}
