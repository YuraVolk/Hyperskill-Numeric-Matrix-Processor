package processor;

public class MultiplyMatricesCommand extends Command {
    MultiplyMatricesCommand(Processor processor) {
        super(processor);
    }

    @Override
    void setMatrix() {
        int rowsIn1 = processor.matrix1.length;
        int columnsIn1 = processor.matrix1[0].length;
        int columnsIn2 = processor.matrix2[0].length;

        int[][] mat = new int[rowsIn1][columnsIn1];
        for (int i = 0; i < rowsIn1; i++) {
            for (int j = -0; j < columnsIn2; j++) {
                mat[i][j] = 0;
                for (int k = 0; k < columnsIn1; k++) {
                    mat[i][j] = mat[i][j] +
                            processor.matrix1[i][k] *
                                    processor.matrix2[k][j];
                }
            }
        }

        printMatrix(mat);
    }
}
