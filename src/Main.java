public class Main {
    static String findSum(String str1, String str2)
    {
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        String result = "";

        int str1Length = str1.length();
        int str2Length = str2.length();

        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < str1Length; i++) {
            int sum = (str1.charAt(i) - '0') + (str2.charAt(i) - '0') + carry;
            System.out.println("Sum: " + str1.charAt(i) + " + " + str2.charAt(i) + " + carry(" + carry + ") = " + sum);

            if (sum >= 10) {
                carry = sum / 10;
                result += (char)(sum % 10 + '0');
            } else {
                carry = 0;
                result += (char)(sum + '0');
            }
        }

        for (int i = str1Length; i < str2Length; i++) {
            int sum = (str2.charAt(i) - '0') + carry;
            System.out.println("Sum: " + str2.charAt(i) + " + carry(" + carry + ") = " + sum);

            if (sum >= 10) {
                carry = sum / 10;
                result += (char)(sum % 10 + '0');
            } else {
                carry = 0;
                result += (char)(sum + '0');
            }
        }

        if (carry > 0) {
            System.out.println(" carry: " + carry);

            result += (char)(carry + '0');
        }

        result = new StringBuilder(result).reverse().toString();

        return result;
    }

    public static void main(String[] args)
    {
        String number1 = "1234";
        String number2 = "56789";

        String result = findSum(number1, number2);
        System.out.println("Sum of digits: " + result);
    }
}