package second;

public class MixColumnsForEnc {
    private int[][] temporary = new int[4][4];

    private void setTemporary(int[][] transformedIntegers) {
        this.temporary = transformedIntegers;
    }

    public int[][] getTemporary(int[][] transformedIntegers) {
        setTemporary(transformedIntegers);
        shuffle();
        return temporary;
    }

    private void shuffle() {
        int[] temp = new int[4];

        for(int i = 1; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                temp[j] = temporary[i][(j + i) % 4];
            }
            for(int j = 0; j < 4; j++) {
                temporary[i][j] = temp[j];
            }
        }
    }

}
