package decryption;

import converter.HexToString;
import first.TransformDecr;
import key.AddKey;
import key.KeyExpansion;
import second.MixColumnsForDecr;
import third.MultiplicationForDecr;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Decrypt {
    private KeyExpansion keyExpansion = new KeyExpansion();
    private AddKey addKey = new AddKey();
    private MixColumnsForDecr mixColumnsForDecr = new MixColumnsForDecr();
    private MultiplicationForDecr multiplicationForDecr = new MultiplicationForDecr();
    private TransformDecr transformDecr = new TransformDecr();
    private HexToString hexToString = new HexToString();
    private int[] hexMessage = new int[16];

    public String decryptToHex(int[] key) throws IOException {
        int[] allKeys = keyExpansion.expansionKeyGeneration(key);
        setHexMessage();
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

        return hexToString.toString(hexMessage);
    }

    private String readFile() throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get("AES.txt"));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    private void setHexMessage() throws IOException {
        String[] temp = readFile().split(" ");

        for(int i = 0; i < 16; i++) {
            hexMessage[i] = Integer.parseInt(temp[i], 16);
        }

    }
}
