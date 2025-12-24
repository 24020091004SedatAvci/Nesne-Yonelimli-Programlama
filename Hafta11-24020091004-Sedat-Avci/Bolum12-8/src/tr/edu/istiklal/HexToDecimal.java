
package tr.edu.istiklal;

public class HexToDecimal {

    public static int hex2Dec(String hexString) throws HexFormatException {

        int decimalValue = 0;
        hexString = hexString.toUpperCase();

        for (int i = 0; i < hexString.length(); i++) {
            char ch = hexString.charAt(i);

            if (!((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F'))) {
                throw new HexFormatException(
                        "Gecersiz hex karakteri: " + ch
                );
            }

            decimalValue = decimalValue * 16 + hexCharToDecimal(ch);
        }

        return decimalValue;
    }

    private static int hexCharToDecimal(char ch) {
        if (ch >= '0' && ch <= '9')
            return ch - '0';
        else
            return ch - 'A' + 10;
    }
}

