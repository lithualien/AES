package converter;

public class HexToDecimal {
    public String toDecimal(String hexNumbers) {
        char[] temp = hexNumbers.toCharArray();
        StringBuilder dec = new StringBuilder();
        int counter = 0;
        for(char cr : temp) {
            dec.append(cr);
            if(counter % 2 == 1) {
                dec.append(" ");
            }
            counter++;
        }
        return dec.toString();
    }
}
