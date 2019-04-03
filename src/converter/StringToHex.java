package converter;

public class StringToHex {
    public String toHex(String message) {
        char[] temp = message.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (char ch : temp) {
            hex.append(Integer.toHexString((int) ch));
        }
        return hex.toString();
    }
}
