import java.util.Scanner;

/**
 * Created by Andrey Sadriev aka AESFUI on 05.11.2016.
 */
public class Matrix {
    /*
    Метод транспонирования матрицы
     */
    public static int[][] matrixTransp() {
        int[][] matrixIn = enteringMatrix();

        int col = matrixIn.length;      // получаем размеры будущей
        int row = matrixIn[0].length;   // траснпонированной матрицы

        int[][] matrixOut = new int[row][col];

        System.out.println("Транспонированная матрица:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixOut[i][j] = matrixIn[j][i];
                System.out.print(matrixOut[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();

        return matrixOut;
    }

    /*
    Метод умножения матриц
     */
    public static void matrixMulti() {
        int[][] matrixA = enteringMatrix();
        int[][] matrixB = enteringMatrix();

        int rowA = matrixA.length;      // размеры
        int colA = matrixA[0].length;   // первой матрицы
        int rowB = matrixB.length;      // размеры
        int colB = matrixB[0].length;   // второй матрицы

        if (colA != rowB) {
            System.out.println("Матрицы несогласованы!");
            return;
        }

        int[][] matrixC = new int[rowA][colB];

        int sumC; //значение в итоговой ячейке выходной матрицы

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {

                //вычисление значения новой ячейки
                sumC = 0;
                for (int k = 0; k < rowB; k++) {
                    sumC+= matrixA[i][k] * matrixB[k][j];
                }

                matrixC[i][j] = sumC;
            }
        }

        //вывод полученной матрицы
        System.out.println("Результат умножения матриц:");
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                System.out.print(matrixC[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] enteringMatrix() {

        System.out.println("Введите размеры матрицы, СТРОКИ СТОЛБЦЫ: ");

        Scanner in = new Scanner(System.in);
        int row = in.nextInt(), col = in.nextInt();

        int[][] matrix = new int[row][col];

        System.out.println("Введите через пробел значения ячеек, разделяя строки Enter'ом: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        System.out.println();

        return matrix;
    }

    public static void main(String[] args) {
        matrixTransp();
        matrixMulti();
    }
}
