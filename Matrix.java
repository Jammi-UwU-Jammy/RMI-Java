

public class Matrix {
    private int dimension[];
    private float rows[][];
    private float columns[][];

    public Matrix(float rows[][]){
        this.rows = rows;
        //[0] = rows, [1] = cols
        this.dimension = new int[]{rows.length, rows[0].length};

        //Flip the matrix
        this.columns = new float[this.dimension[1]][this.dimension[0]];
        setToColumns();
    }

    public Matrix multiply(Matrix secondMatrix){
        //result matrix = (r x c) where r = 1st matrix row_num and c = 2nd matrix' col_num 
        float result[][] = new float[this.dimension[0]][secondMatrix.getDimension()[1]];

        if (isMultipliable(secondMatrix)){
            for (int x = 0, y ; x < this.dimension[0] ; ++x){
                float anElement = 0;
                for (y = 0; y < secondMatrix.getDimension()[1]; ++y){
                    anElement = rowXcol(this.rows[x], secondMatrix.getColumns()[y]);
                    result[x][y] = anElement;
                }
            }

            return new Matrix(result);
        }
        else return null;
    }

    public float rowXcol(float[] row, float[] col){
        float result = 0;
        for (int i = 0; i < row.length ; ++i){
            result += row[i]* col[i]; 
        }
        return result;
    }

    public boolean isMultipliable(Matrix secondMatrix){
        //1st matrix's col = 2nd matrix's row
        if (this.dimension[1] == secondMatrix.getDimension()[0])
            return true;
        else
            return false;
    }

    public float[][] getColumns(){
        return this.columns;
    }

    public int[] getDimension(){
        return this.dimension;
    }

    public void setToColumns(){
        //float[][] columns = new float[this.dimension[1]][this.dimension[0]];

        for (int y = 0; y < this.dimension[1] ; ++y){
            for (int x = 0; x < this.dimension[0]; ++x){
                this.columns[y][x] = rows[x][y];
                //System.out.print(columns[y][x] + "\t");
            }
        }
    }

    public void printMatrix(){
        for (int y = 0; y < this.dimension[0] ; ++y){
            for (int x = 0; x < this.dimension[1]; ++x){
                System.out.print(rows[y][x] + "\t");
            }
            System.out.println();
        }
    }
    

}
