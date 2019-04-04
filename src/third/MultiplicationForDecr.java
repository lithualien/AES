package third;

import matrix.Matrix;

public class MultiplicationForDecr {
    private int[] temp = new int[16];
    private Matrix matrix = new Matrix();

    public int[] getHexMessage(int[] hexMessage) {
        multiplyMatrix(hexMessage);
        System.arraycopy(temp,0, hexMessage, 0, 16);
        return hexMessage;
    }

    private void multiplyMatrix(int[] hexMessage) {
        temp[0] = matrix.multiplyBy0E[hexMessage[0]] ^ matrix.multiplyBy0B[hexMessage[1]] ^ matrix.multiplyBy0D[hexMessage[2]] ^ matrix.multiplyBy09[hexMessage[3]];
        temp[1] = matrix.multiplyBy09[hexMessage[0]] ^ matrix.multiplyBy0E[hexMessage[1]] ^ matrix.multiplyBy0B[hexMessage[2]] ^ matrix.multiplyBy0D[hexMessage[3]];
        temp[2] = matrix.multiplyBy0D[hexMessage[0]] ^ matrix.multiplyBy09[hexMessage[1]] ^ matrix.multiplyBy0E[hexMessage[2]] ^ matrix.multiplyBy0B[hexMessage[3]];
        temp[3] = matrix.multiplyBy0B[hexMessage[0]] ^ matrix.multiplyBy0D[hexMessage[1]] ^ matrix.multiplyBy09[hexMessage[2]] ^ matrix.multiplyBy0E[hexMessage[3]];

        temp[4] = matrix.multiplyBy0E[hexMessage[4]] ^ matrix.multiplyBy0B[hexMessage[5]] ^ matrix.multiplyBy0D[hexMessage[6]] ^ matrix.multiplyBy09[hexMessage[7]];
        temp[5] = matrix.multiplyBy09[hexMessage[4]] ^ matrix.multiplyBy0E[hexMessage[5]] ^ matrix.multiplyBy0B[hexMessage[6]] ^ matrix.multiplyBy0D[hexMessage[7]];
        temp[6] = matrix.multiplyBy0D[hexMessage[4]] ^ matrix.multiplyBy09[hexMessage[5]] ^ matrix.multiplyBy0E[hexMessage[6]] ^ matrix.multiplyBy0B[hexMessage[7]];
        temp[7] = matrix.multiplyBy0B[hexMessage[4]] ^ matrix.multiplyBy0D[hexMessage[5]] ^ matrix.multiplyBy09[hexMessage[6]] ^ matrix.multiplyBy0E[hexMessage[7]];

        temp[8] = matrix.multiplyBy0E[hexMessage[8]] ^ matrix.multiplyBy0B[hexMessage[9]] ^ matrix.multiplyBy0D[hexMessage[10]] ^ matrix.multiplyBy09[hexMessage[11]];
        temp[9] = matrix.multiplyBy09[hexMessage[8]] ^ matrix.multiplyBy0E[hexMessage[9]] ^ matrix.multiplyBy0B[hexMessage[10]] ^ matrix.multiplyBy0D[hexMessage[11]];
        temp[10] = matrix.multiplyBy0D[hexMessage[8]] ^ matrix.multiplyBy09[hexMessage[9]] ^ matrix.multiplyBy0E[hexMessage[10]] ^ matrix.multiplyBy0B[hexMessage[11]];
        temp[11] = matrix.multiplyBy0B[hexMessage[8]] ^ matrix.multiplyBy0D[hexMessage[9]] ^ matrix.multiplyBy09[hexMessage[10]] ^ matrix.multiplyBy0E[hexMessage[11]];

        temp[12] = matrix.multiplyBy0E[hexMessage[12]] ^ matrix.multiplyBy0B[hexMessage[13]] ^ matrix.multiplyBy0D[hexMessage[14]] ^ matrix.multiplyBy09[hexMessage[15]];
        temp[13] = matrix.multiplyBy09[hexMessage[12]] ^ matrix.multiplyBy0E[hexMessage[13]] ^ matrix.multiplyBy0B[hexMessage[14]] ^ matrix.multiplyBy0D[hexMessage[15]];
        temp[14] = matrix.multiplyBy0D[hexMessage[12]] ^ matrix.multiplyBy09[hexMessage[13]] ^ matrix.multiplyBy0E[hexMessage[14]] ^ matrix.multiplyBy0B[hexMessage[15]];
        temp[15] = matrix.multiplyBy0B[hexMessage[12]] ^ matrix.multiplyBy0D[hexMessage[13]] ^ matrix.multiplyBy09[hexMessage[14]] ^ matrix.multiplyBy0E[hexMessage[15]];
    }
}
