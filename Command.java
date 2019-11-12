package processor;

public abstract class Command {
    Processor processor;
    double[][] matrix;

    Command(Processor processor) {
        this.processor = processor;
    }

    abstract void setMatrix();
    double[][] getMatrix() {
        return matrix;
    }

    void printMatrix(double[][] matrix) {
        for(double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
