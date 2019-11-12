package processor;

import java.util.Scanner;

public class Processor {
    Scanner scanner = new Scanner(System.in);
    double[][] matrix1;
    double[][] matrix2;
    private Command command;

    private void sumMatrices() {
        command = new FillMatrixCommand(this);
        System.out.print("Enter size of first matrix: ");
        command.setMatrix();
        matrix1 = command.getMatrix();
        System.out.print("Enter size of second matrix: ");
        command.setMatrix();
        matrix2 = command.getMatrix();

        command = new SumMatrixCommand(this);
        command.setMatrix();
    }

    private void multiplyByConstant() {
        System.out.println("Enter size of first matrix: ");
        command = new FillMatrixCommand(this);
        command.setMatrix();
        matrix1 = command.getMatrix();

        System.out.println("Enter constant: ");
        command = new ConstantMultiplyCommand(this);
        command.setMatrix();
    }

    private void multiplyMatrices() {
        command = new FillMatrixCommand(this);
        System.out.print("Enter size of first matrix: ");
        command.setMatrix();
        matrix1 = command.getMatrix();
        System.out.print("Enter size of second matrix: ");
        command.setMatrix();
        matrix2 = command.getMatrix();

        command = new MultiplyMatricesCommand(this);
        command.setMatrix();
    }

    private void transposeMatrix() {
        command = new FillMatrixCommand(this);
        System.out.print("Enter size of first matrix: ");
        command.setMatrix();
        matrix1 = command.getMatrix();

        command = new TransposeMatrixCommand(this);
        command.setMatrix();
    }


    private void nullify() {
        matrix1 = null;
        matrix2 = null;
        Runtime.getRuntime().gc();
    }

    void execute() {
        int choice;

        main:
        while (true) {
            System.out.println("1. Add matrices\n" +
                    "2. Multiply matrix to a constant\n" +
                    "3. Multiply matrices\n" +
                    "0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sumMatrices();
                    break;
                case 2:
                    multiplyByConstant();
                    break;
                case 3:
                    multiplyMatrices();
                    break;
                case 4:
                    transposeMatrix();
                    break;
                case 0:
                default:
                    break main;
            }
            nullify();
        }
    }
}
