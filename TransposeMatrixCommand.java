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

    private void transposeMatrix(double[][] matrix) {
        for (int c = 0; c < matrix.length; c++) {
            for (int d = 0; d < matrix[0].length; d++) {
                matrix[d][c] = matrix[c][d];
            }
        }
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
        Command fill = new FillMatrixCommand(processor);
        fill.setMatrix();
        double[][] matrix = fill.getMatrix();

        int rows = matrix.length;
        int columns = matrix[0].length;
        System.out.println("\n" +
                "1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice: ");
        int choice = processor.scanner.nextInt();
        switch (choice) {
            case 1:
                if (rows != columns) {
                    System.out.println("ERROR");
                    return;
                }
                transposeMatrix(matrix);
                break;
            case 2:
                if (rows != columns) {
                    System.out.println("ERROR");
                    return;
                }
                flipMatrix(matrix);
                transposeMatrix(matrix);
                flipMatrix(matrix);
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
