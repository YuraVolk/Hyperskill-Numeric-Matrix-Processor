package processor;

public class ConstantMultiplyCommand extends Command {
    ConstantMultiplyCommand(Processor processor) {
        super(processor);
    }

    @Override
    void setMatrix() {
        final double c = processor.scanner.nextDouble();
        final int rows = processor.matrix1.length;
        final int columns = processor.matrix1[0].length;

        double[][] mat = new double[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat[i][j] = processor.matrix1[i][j] * c;
            }
        }

        printMatrix(mat);
    }
}
