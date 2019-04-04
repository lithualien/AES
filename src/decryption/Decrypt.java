package decryption;

import first.TransformDecr;
import key.AddKey;
import key.KeyExpansion;
import second.MixColumnsForDecr;
import third.MultiplicationForDecr;

public class Decrypt {
    KeyExpansion keyExpansion = new KeyExpansion();

    private AddKey addKey = new AddKey();
    private MixColumnsForDecr mixColumnsForDecr = new MixColumnsForDecr();
    private MultiplicationForDecr multiplicationForDecr = new MultiplicationForDecr();
    private TransformDecr transformDecr = new TransformDecr();

    public void decryptToHex(int[] message, int[] key) {
        int[] allKeys = keyExpansion.expansionKeyGeneration(key);
        int[] hexMessage = message;

        int[] tempKey = new int[16];

        System.arraycopy(allKeys, 160, tempKey, 0, 16);

        hexMessage = addKey.getHexMessage(hexMessage, tempKey);
        hexMessage = mixColumnsForDecr.getHexMessage(hexMessage);
        hexMessage = transformDecr.getHexMessage(hexMessage);

        for(int i = 8; i >= 0; i--) {
            tempKey = new int[16];
            System.arraycopy(allKeys, 16 * (i + 1), tempKey, 0, 16);

            hexMessage = addKey.getHexMessage(hexMessage, tempKey);
            hexMessage = multiplicationForDecr.getHexMessage(hexMessage);
            hexMessage = mixColumnsForDecr.getHexMessage(hexMessage);
            hexMessage = transformDecr.getHexMessage(hexMessage);
        }

        hexMessage = addKey.getHexMessage(hexMessage, key);

        System.out.print("\n");

        for(int i = 0; i < 16; i++) {
            System.out.print(Integer.toHexString(hexMessage[i]) + " ");
            if(i == 3 || i == 7 || i == 11 || i == 15) {
                System.out.println();
            }
        }

    }
}
