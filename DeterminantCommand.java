package processor;

public class DeterminantCommand extends Command {
    DeterminantCommand(Processor processor) {
        super(processor);
    }

    private double determinantOfMatrix(double[][] matrix, int rows) {
        double det;
        if(rows == 1) {
            det = matrix[0][0];
        } else if (rows == 2) {
            det = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        } else {
            det = 0;
            for(int j1 = 0; j1 < rows; j1++) {
                double[][] m = new double[rows - 1][];
                for(int k = 0; k < (rows - 1); k++) {
                    m[k] = new double[rows - 1];
                }
                for(int i = 1;i < rows; i++) {
                    int j2 = 0;
                    for(int j = 0;j < rows; j++) {
                        if(j == j1) {
                            continue;
                        }

                        m[i-1][j2] = matrix[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0, 1.0 + j1 + 1.0)* matrix[0][j1] *
                        determinantOfMatrix(m,rows - 1);
            }
        }

        return det;

    }
    @Override
    void setMatrix() {
        System.out.println(determinantOfMatrix(processor.matrix1,
                processor.matrix1.length) + "\n");
    }
}
