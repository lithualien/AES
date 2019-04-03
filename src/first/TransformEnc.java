package first;

public class TransformEnc {
    private SBox sBox = new SBox();

    public int changeValues(int x, int y) {
        return sBox.sbox[x][y];
    }
}
