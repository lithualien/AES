package first;

import matrix.Matrix;

public class TransformEnc {
    private Matrix matrix = new Matrix();

    public int[] getHexMessage(int[] hexMessage) {
        for (int i = 0; i < 16; i++) {
            hexMessage[i] = matrix.sBox[hexMessage[i]];
        }
        return hexMessage;
    }
}
