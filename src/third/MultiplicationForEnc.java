package third;

import matrix.Matrix;

public class MultiplicationForEnc {
    private int[] temp = new int[16];
    private Matrix matrix = new Matrix();

    public int[] getHexMessage(int[] hexMessage) {
        multiplyMatrix(hexMessage);
        System.arraycopy(temp,0, hexMessage, 0, 16);
        return hexMessage;
    }

    private void multiplyMatrix(int[] hexMessage) {
        temp[0] = matrix.multiplyBy02[hexMessage[0]] ^ matrix.multiplyBy03[hexMessage[1]] ^ hexMessage[2] ^ hexMessage[3];
        temp[1] = hexMessage[0] ^ matrix.multiplyBy02[hexMessage[1]] ^ matrix.multiplyBy03[hexMessage[2]] ^ hexMessage[3];
        temp[2] = hexMessage[0] ^ hexMessage[1] ^ matrix.multiplyBy02[hexMessage[2]] ^ matrix.multiplyBy03[hexMessage[3]];
        temp[3] = matrix.multiplyBy03[hexMessage[0]] ^ hexMessage[1] ^ hexMessage[2] ^ matrix.multiplyBy02[hexMessage[3]];

        temp[4] = matrix.multiplyBy02[hexMessage[4]] ^ matrix.multiplyBy03[hexMessage[5]] ^ hexMessage[6] ^ hexMessage[7];
        temp[5] = hexMessage[4] ^ matrix.multiplyBy02[hexMessage[5]] ^ matrix.multiplyBy03[hexMessage[6]] ^ hexMessage[7];
        temp[6] = hexMessage[4] ^ hexMessage[5] ^ matrix.multiplyBy02[hexMessage[6]] ^ matrix.multiplyBy03[hexMessage[7]];
        temp[7] = matrix.multiplyBy03[hexMessage[4]] ^ hexMessage[5] ^ hexMessage[6] ^ matrix.multiplyBy02[hexMessage[7]];

        temp[8] = matrix.multiplyBy02[hexMessage[8]] ^ matrix.multiplyBy03[hexMessage[9]] ^ hexMessage[10] ^ hexMessage[11];
        temp[9] = hexMessage[8] ^ matrix.multiplyBy02[hexMessage[9]] ^ matrix.multiplyBy03[hexMessage[10]] ^ hexMessage[11];
        temp[10] = hexMessage[8] ^ hexMessage[9] ^ matrix.multiplyBy02[hexMessage[10]] ^ matrix.multiplyBy03[hexMessage[11]];
        temp[11] = matrix.multiplyBy03[hexMessage[8]] ^ hexMessage[9] ^ hexMessage[10] ^ matrix.multiplyBy02[hexMessage[11]];

        temp[12] = matrix.multiplyBy02[hexMessage[12]] ^ matrix.multiplyBy03[hexMessage[13]] ^ hexMessage[14] ^ hexMessage[15];
        temp[13] = hexMessage[12] ^ matrix.multiplyBy02[hexMessage[13]] ^ matrix.multiplyBy03[hexMessage[14]] ^ hexMessage[15];
        temp[14] = hexMessage[12] ^ hexMessage[13] ^ matrix.multiplyBy02[hexMessage[14]] ^ matrix.multiplyBy03[hexMessage[15]];
        temp[15] = matrix.multiplyBy03[hexMessage[12]] ^ hexMessage[13] ^ hexMessage[14] ^ matrix.multiplyBy02[hexMessage[15]];
    }
}
