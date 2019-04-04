package key;

public class AddKey {
    public int[] getHexMessage(int[] hexMessage, int[] key) {
        for (int i = 0; i < 16; i++) {
            hexMessage[i] ^= key[i];
        }
        return hexMessage;
    }
}
