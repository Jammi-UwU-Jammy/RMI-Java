public class testApp {

    public static void main(String args[]){

        float[][] testArray1 = new float[][]{{1,2,3}, {4,5,6}};
        float[][] testArray2 = new float[][]{{1,2}, {4,5}, {6,7}};
        Matrix matrix1 = new Matrix(testArray1);
        Matrix matrix2 = new Matrix(testArray2);

        Matrix resultMatrix =  matrix1.multiply(matrix2);
        resultMatrix.printMatrix();

        //matrix1.printMatrix();


    }

}
