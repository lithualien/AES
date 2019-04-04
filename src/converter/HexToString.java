package converter;

public class HexToString {
    public String toString(int[] hexNumbers) {
        String[] hexNumbs = new String[hexNumbers.length];
        for(int i = 0; i < hexNumbers.length; i++) {
            hexNumbs[i] = Integer.toHexString(hexNumbers[i]);
        }

        StringBuilder dec = new StringBuilder();
        for(String temp : hexNumbs) {
            dec.append((char) Integer.parseInt(temp, 16));
        }
        return dec.toString();
    }
}
