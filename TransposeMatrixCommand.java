package processor;

import java.util.concurrent.ConcurrentMap;

public class TransposeMatrixCommand extends Command {
    TransposeMatrixCommand(Processor processor) {
        super(processor);
    }

    /*
    Main Diagonal:




    Side Diagonal:

    flipMatrix(a);
        for (int c = 0; c < cols; c++) {
            for (int d = 0; d < rows; d++) {
                tr[d][c] = a[c][d];
            }
        }
        flipMatrix(tr);


    Vertical Line:
      flipMatrix(a);



     */


    private void flipMatrix(double[][] matrix) {
        double temp;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                temp = matrix[i][j];

                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 -j] = temp;
            }
        }
    }

    private double[][] transposeMatrix(double[][] m) {
        double[][] temp = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }

    private void flipMatrixVertically(double[][] matrix) {
        double temp;

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                 temp = matrix[i][j];

                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 -i][j] = temp;
            }
        }
    }


    @Override
    void setMatrix() {
        System.out.println("\n" +
                "1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice: ");
        int choice = processor.scanner.nextInt();

        System.out.println("Enter matrix size: ");
        Command fill = new FillMatrixCommand(processor);
        fill.setMatrix();
        double[][] matrix = fill.getMatrix();

        int rows = matrix.length;
        int columns = matrix[0].length;

        switch (choice) {
            case 1:
                if (rows != columns) {
                    System.out.println("ERROR");
                    return;
                }
                matrix = transposeMatrix(matrix);
                break;
            case 2:
                if (rows != columns) {
                    System.out.println("ERROR");
                    return;
                }
                flipMatrix(matrix);
                matrix = transposeMatrix(matrix);
            case 3:
                flipMatrix(matrix);
                break;
            default:
            case 4:
                flipMatrixVertically(matrix);
        }

        printMatrix(matrix);
    }


}
