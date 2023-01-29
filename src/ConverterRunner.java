import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);
        while (!(base == 2 || base == 8 || base == 10))
        {
            System.out.print("Enter a VALID base of your number (2, 8 or 10): ");
            choice = s.nextLine();
            base = Integer.parseInt(choice);
        }

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);
        for (int i = 0; i < number.length(); i++)
        {
            for (int invalid = base; invalid < 10; invalid++)
            {
                if (number.contains("" + invalid))
                {
                    i = -1;
                    System.out.print("Enter a VALID number: ");
                    number = s.nextLine();
                    n = Integer.parseInt(number);
                }
            }
        }

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());

        if (base == 2)
        {
            System.out.println("Decimal Number: " + nc.ArrayToString(nc.convertToDecimal()));
            System.out.println("Octal Number: " + nc.ArrayToString(nc.convertToOctal()));
        }
        if (base == 8)
        {
            System.out.println("Decimal Number: " + nc.ArrayToString(nc.convertToDecimal()));
            System.out.println("Binary Number: " + nc.ArrayToString(nc.convertToBinary()));
        }

        if (base == 10)
        {
            System.out.println("Octal Number: " + nc.ArrayToString(nc.convertToOctal()));
            System.out.println("Binary Number: " + nc.ArrayToString(nc.convertToBinary()));
        }
    }
}
