package second;

public class MixColumnsForDecr {
    private int[] temp = new int[16];

    public int[] getHexMessage(int[] hexMessage) {
        shuffle(hexMessage);
        System.arraycopy(temp, 0, hexMessage, 0, 16);
        return hexMessage;
    }

    private void shuffle(int[] hexMessage) {
        //---------------------//
        temp[0] = hexMessage[0];
        temp[1] = hexMessage[13];
        temp[2] = hexMessage[10];
        temp[3] = hexMessage[7];
        //---------------------//
        temp[4] = hexMessage[4];
        temp[5] = hexMessage[1];
        temp[6] = hexMessage[14];
        temp[7] = hexMessage[11];
        //---------------------//
        temp[8] = hexMessage[8];
        temp[9] = hexMessage[5];
        temp[10] = hexMessage[2];
        temp[11] = hexMessage[15];
        //---------------------//
        temp[12] = hexMessage[12];
        temp[13] = hexMessage[9];
        temp[14] = hexMessage[6];
        temp[15] = hexMessage[3];
    }
}
