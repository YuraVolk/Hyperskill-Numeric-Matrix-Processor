package processor;

public class ConstantMultiplyCommand extends Command {
    ConstantMultiplyCommand(Processor processor) {
        super(processor);
    }

    @Override
    void setMatrix() {
        final int c = processor.scanner.nextInt();
        final int rows = processor.matrix1.length;
        final int columns = processor.matrix1[0].length;

        int[][] mat = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat[i][j] = processor.matrix1[i][j] * c;
            }
        }

        printMatrix(mat);
    }
}
