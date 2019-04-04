package encryption;

import converter.StringToHex;
import first.TransformEnc;
import key.AddKey;
import key.KeyExpansion;
import second.MixColumnsForEnc;
import third.MultiplicationForEnc;

import java.io.BufferedWriter;
import java.io.FileWriter;
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

        for(int i = 0; i < 16; i++) {
            //System.out.print(Integer.toHexString(hexMessage[i]) + " ");
            if(i == 3 || i == 7 || i == 11 || i == 15) {
               // System.out.println();
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("AES.txt"));

        for(int i = 0; i < 16; i++) {
            writer.write(Integer.toHexString(hexMessage[i]) + " ");
        }

        writer.close();

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
