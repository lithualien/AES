package third;

import matrix.Matrix;

public class MultiplicationForEnc {

    private int[][] column = new int[1][4];
    private int[][] convertedMatrix = new int[4][4];
    private Matrix matrix = new Matrix();

    public void MultiplyMatrix(int[][] transformedIntegers) {
        for(int i = 0; i < 4; i++) {
            column
        }
    }

    public int multiplicationFrom02(int number) {
        number *= 0x02;

        if(number > 0b100000000) {
            number = number ^ 0b00011011;
        }

        return number;
    }

    public int multiplicationFrom03(int number) {
        return (number * 0x02) ^ number;
    }
}
