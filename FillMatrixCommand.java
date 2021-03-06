package processor;

public class FillMatrixCommand extends Command {
    FillMatrixCommand(Processor processor) {
        super(processor);
    }

    @Override
    void setMatrix() {
        final int rows = processor.scanner.nextInt();
        final int columns = processor.scanner.nextInt();

        System.out.println("Enter " + (processor.matrix1 == null ?
                "first" : "second") + " matrix: ");
        matrix = new double[rows][columns];

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns; col++){
                matrix[row][col] = processor.scanner.nextDouble();
            }
        }
    }
}
