package processor;

public class FillMatrixCommand extends Command {
    FillMatrixCommand(Processor processor) {
        super(processor);
    }

    @Override
    void setMatrix() {
        int rows = processor.scanner.nextInt();
        int columns = processor.scanner.nextInt();

        matrix = new int[rows][columns];

        for(int row = 0;row < rows; row++){
            for(int col = 0;col < columns; col++){
                matrix[row][col] = processor.scanner.nextInt();
            }
        }
    }
}
