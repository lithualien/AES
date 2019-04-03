import converter.HexToDecimal;
import converter.StringToHex;
import first.TransformEnc;
import second.MixColumnsForEnc;
import third.MultiplicationForEnc;

public class AES {

    private static final String MESSAGE = "TomasDominauskas";
    private static int[] intNumbers;
    private static int[][] transformedIntegers;
    private static TransformEnc transformEnc = new TransformEnc();
    private static HexToDecimal hexToDecimal = new HexToDecimal();
    private static StringToHex stringToHex = new StringToHex();
    private static MixColumnsForEnc mixColumnsForEnc = new MixColumnsForEnc();
    private static MultiplicationForEnc multiplicationForEnc = new MultiplicationForEnc();

    public static void main(String[] args) {
        setIntNumbers();
        setTransformedIntegers();
        transformedIntegers = mixColumnsForEnc.getTemporary(transformedIntegers);

    }

    private static void setIntNumbers() {
        String[] temp = hexToDecimal.toDecimal(stringToHex.toHex(MESSAGE)).split(" ");
        intNumbers = new int[temp.length];
        for(int i = 0; i < temp.length; i++) {
            intNumbers[i] = Integer.parseInt(temp[i]);
        }
    }

    private static void setTransformedIntegers() {
        transformedIntegers = new int[4][4];
        int tempCounter = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                transformedIntegers[i][j] = transformEnc.changeValues(intNumbers[tempCounter * 2], intNumbers[tempCounter * 2 + 1]);
                tempCounter++;
            }
        }
    }
}
