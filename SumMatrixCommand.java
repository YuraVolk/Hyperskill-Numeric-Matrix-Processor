package processor;

public class SumMatrixCommand extends Command {
    SumMatrixCommand(Processor processor) {
        super(processor);
    }

    @Override
    void setMatrix() {
        final int rows = processor.matrix1.length;
        final int columns = processor.matrix1[0].length;

        if (rows != processor.matrix2.length &&
            columns != processor.matrix2[0].length)  {
            System.out.println("ERROR");
            return;
        }

        double[][] sum = new double[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i][j] = processor.matrix1[i][j] + processor.matrix2[i][j];
            }
        }

        printMatrix(sum);
    }
}
