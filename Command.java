package processor;

public abstract class Command {
    Processor processor;
    int[][] matrix;

    Command(Processor processor) {
        this.processor = processor;
    }

    abstract void setMatrix();
    int[][] getMatrix() {
        return matrix;
    }

    void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
