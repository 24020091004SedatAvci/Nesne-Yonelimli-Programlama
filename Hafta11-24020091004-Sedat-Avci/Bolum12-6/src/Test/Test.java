
package Test;
public class Test {

    public static int hex2Dec(String hexString) {

        int decimalValue = 0;
        hexString = hexString.toUpperCase();

        for (int i = 0; i < hexString.length(); i++) {
            char ch = hexString.charAt(i);

            // Hex kontrolü
            if (!((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F'))) {
                throw new NumberFormatException(
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

    // Test için main
    public static void main(String[] args) {

        try {
            System.out.println(hex2Dec("1A3F")); // doğru
            System.out.println(hex2Dec("12G5")); // hata
        } catch (NumberFormatException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}
