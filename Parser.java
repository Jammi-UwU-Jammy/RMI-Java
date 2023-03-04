import java.util.ArrayList;

public class Parser {
    private String string;
    private float[][] matrix;

    public Parser(String string){
        this.string = string;
        this.matrix = stringTo2DArray();
    }

    public float[][] stringTo2DArray(){

        String[] rows = string.strip().split(";");
        //ArrayList<float[]> matrix = new ArrayList<>();
        float[][] matrix = new float[rows.length][];

        for (int i = 0; i < rows.length ; ++i){
            float[] array = collectIntegersFromString(rows[i]);
            matrix[i] = array;
        }
        return matrix;
    }

    public float[][] getMatrix(){
        return this.matrix;
    }

    public float[] collectIntegersFromString(String string){

        String[] floatString = string.strip().split(",");
        float[] array = new float[floatString.length];

        for (int i  = 0; i < floatString.length ; ++i){
            array[i] = Float.parseFloat(floatString[i]);
            //System.out.println(array[i]);
        }

        return array;
    }
}
