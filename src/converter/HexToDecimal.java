package converter;

public class HexToDecimal {
    public String toDecimal(String hexNumbers) {
        char[] temp = hexNumbers.toCharArray();
        StringBuilder dec = new StringBuilder();
        for(char cr : temp) {
            dec.append(Integer.parseInt(Character.toString(cr), 16)).append(" ");
        }
        return dec.toString();
    }
}
