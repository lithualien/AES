package encryption;

import converter.StringToHex;
import first.TransformEnc;
import key.AddKey;
import key.KeyExpansion;
import second.MixColumnsForEnc;
import third.MultiplicationForEnc;
import java.io.IOException;

public class Encrypt {
    private StringToHex stringToHex = new StringToHex();
    private TransformEnc transformEnc = new TransformEnc();
    private MixColumnsForEnc mixColumnsForEnc = new MixColumnsForEnc();
    private MultiplicationForEnc multiplicationForEnc = new MultiplicationForEnc();
    private KeyExpansion keyExpansion = new KeyExpansion();
    private AddKey addKey = new AddKey();

    private int[] hexMessage = new int[16];

    public int[] encryptToAES(String message, int[] key) throws IOException {
        setHexMessage(message);
        int[] allKeys = keyExpansion.expansionKeyGeneration(key);
        hexMessage = addKey.getHexMessage(hexMessage, key);

        for(int i = 0; i < 10; i++) {
            int[] tempKey = new int[16];
            System.arraycopy(allKeys, 16 * (i + 1), tempKey, 0, 16);

            if(i == 9) {
                hexMessage = transformEnc.getHexMessage(hexMessage);
                hexMessage = mixColumnsForEnc.getHexMessage(hexMessage);
            }
            else {
                hexMessage = transformEnc.getHexMessage(hexMessage);
                hexMessage = mixColumnsForEnc.getHexMessage(hexMessage);
                hexMessage = multiplicationForEnc.getHexMessage(hexMessage);
            }

            hexMessage = addKey.getHexMessage(hexMessage, tempKey);
        }
        return hexMessage;
    }

    private void setHexMessage(String message) {
        String[] temp;
        temp = stringToHex.toHex(message).split(" ");

        for(int i = 0; i < 16; i++) {
            hexMessage[i] = Integer.parseInt(temp[i], 16);
        }
    }
}
