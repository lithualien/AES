package key;

import matrix.Matrix;

public class KeyExpansion {
    private Matrix matrix = new Matrix();

    private int[] expandedKey = new int[176];

    private void expandTheKey(int[] key) {
        System.arraycopy(key, 0, expandedKey, 0, 16);
    }

    public int[] expansionKeyGeneration(int[] key) {
        expandTheKey(key);

        int bytesGenerated = 16;
        int rConst = 1;
        int[] temp = new int[4]; // w

        while (bytesGenerated < 176) {
            System.arraycopy(expandedKey, bytesGenerated - 4, temp, 0, 4);

            if(bytesGenerated % 16 == 0) {
                keyExpansionCore(temp, rConst);
                rConst++;
            }

            for(int i = 0; i < 4; i++) {
                expandedKey[bytesGenerated] = expandedKey[bytesGenerated - 16] ^ temp[i];
                bytesGenerated++;
            }
        }
        return expandedKey;
    }

    private void keyExpansionCore(int[] temp ,int rConst) {
        int t = temp[0];

        //----------------------------//
        temp[0] = temp[1];
        temp[1] = temp[2];
        temp[2] = temp[3];
        temp[3] = t;
        //----------------------------//
        temp[0] = matrix.sBox[temp[0]];
        temp[1] = matrix.sBox[temp[1]];
        temp[2] = matrix.sBox[temp[2]];
        temp[3] = matrix.sBox[temp[3]];
        //----------------------------//
        temp[0] ^= matrix.rCon[rConst];
    }
}
