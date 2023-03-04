import java.util.Scanner;

public class testApp {

    public static void main(String args[]){

        float[][] testArray1 = new float[][]{{1,2,3}, {4,5,6}};
        float[][] testArray2 = new float[][]{{1,2}, {4,5}, {6,7}};
        Matrix matrix1 = new Matrix(testArray1);
        Matrix matrix2 = new Matrix(testArray2);

        // Matrix resultMatrix =  matrix1.multiply(matrix2);
        // resultMatrix.printMatrix();
        Scanner sc = new Scanner(System.in);
        System.out.println("Put in a matrix: ");
        String s = sc.nextLine();
        Parser parse = new Parser(s);

        //Parser parse = new Parser("1.5, 2.5, 3.1 ; 4.8, 5, 6.5; 7.1 ,7 , 8");
        Matrix test = new Matrix(parse.getMatrix());
        test.printMatrix();

        


    }

}
