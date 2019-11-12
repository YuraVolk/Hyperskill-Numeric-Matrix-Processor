package processor;

import java.util.Scanner;

public class Processor {
    Scanner scanner = new Scanner(System.in);
    int[][] matrix1;
    int[][] matrix2;
    private Command command;

    void execute() {
         command = new FillMatrixCommand(this);
         command.setMatrix();
         matrix1 = command.getMatrix();
         command.setMatrix();
         matrix2 = command.getMatrix();

         command = new SumMatrixCommand(this);
         command.setMatrix();
    }
}
