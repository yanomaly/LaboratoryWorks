package Lab4;
//Толстой Ян 8 группа 2 курс
//Класс матриц
import java.util.Random;

public class Matrix {

    private Integer matrix[][];

    public Matrix(){}

    public Matrix(int rows, int columns){
        matrix = new Integer[rows][columns];
    }

    public  void print(){
        System.out.println("Matrix:");
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    public  void set_Random (int random){
        Random numb = new Random();
        for(int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = Math.abs(numb.nextInt() % random);
    }

    public int getMaxRow (int k){
        k--;
        if(k < matrix[0].length) {
            int max_index = 0, max = matrix[0][k];
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][k] > max) {
                    max = matrix[i][k];
                    max_index = i;
                }
            }
            return max_index;
        }
        else {System.out.println("Wrong param!"); return -1;}
    }

    public int getMinRow (int k){
        k--;
        if(k < matrix[0].length) {
            int min_index = 0, min = matrix[0][k];
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][k] < min) {
                    min = matrix[i][k];
                    min_index = i;
                }
            }
            return min_index;
        }
        else {System.out.println("Wrong param!"); return -1;}
    }

    public void swapRows(int row1, int row2){
        Integer temp[];
        temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    public void printMinItems(int k){
        System.out.println(matrix[getMinRow(k)][--k]);
    }


    public static void main(String[] args) {
        int     count = 2,
                rows = 3, columns = 4,
                diapason = 10,
                row_number = 3;
        Matrix arr[] = new Matrix[count];
        for (int i = 0; i < count; i++) {
            arr[i] = new Matrix(rows, columns);
            arr[i].set_Random(diapason);
        }
        System.out.println("Initial matrices");
        for (Matrix temp: arr)
            temp.print();
        for (Matrix temp: arr)
            temp.swapRows(temp.getMinRow(row_number), temp.getMaxRow(row_number));
        System.out.println("Changed matrices");
        for (Matrix temp: arr)
            temp.print();
        System.out.println("Min elements");
        for (Matrix temp: arr)
            temp.printMinItems(row_number);
    }
}

