import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);
        while (!(base == 2 || base == 8 || base == 10|| base == 16))
        {
            System.out.print("Enter a VALID base of your number (2, 8, 10, or 16): ");
            choice = s.nextLine();
            base = Integer.parseInt(choice);
        }

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        String values = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";

        for (int i = 0; i < number.length(); i++)
        {
            if (!(values.substring(0,base).contains(number.substring(i, i +1))))
            {
                System.out.println("Enter a VALID number of your base.");
                number = s.nextLine();
                i--;
            }
        }

        NumberConverter nc = new NumberConverter(number, base);
        int[] digits = nc.getDigits();

        if (base == 2)
        {
            System.out.println("\n\nHexadecimal Number: " + nc.arrayToString(nc.convertToOther(16)));
            System.out.println("Decimal Number: " + nc.arrayToString(nc.convertToDecimal()));
            System.out.println("Octal Number: " + nc.arrayToString(nc.convertToOther(8)));
        }
        if (base == 8)
        {
            System.out.println("\n\nHexadecimal Number: " + nc.arrayToString(nc.convertToOther(16)));
            System.out.println("Decimal Number: " + nc.arrayToString(nc.convertToDecimal()));
            System.out.println("Binary Number: " + nc.arrayToString(nc.convertToOther(2)));
        }

        if (base == 10)
        {
            System.out.println("\n\nHexadecimal Number: " + nc.arrayToString(nc.convertToOther(16)));
            System.out.println("Octal Number: " + nc.arrayToString(nc.convertToOther(8)));
            System.out.println("Binary Number: " + nc.arrayToString(nc.convertToOther(2)));
        }

        if (base == 16)
        {
            System.out.println("\n\nDecimal Number: " + nc.arrayToString(nc.convertToDecimal()));
            System.out.println("Octal Number: " + nc.arrayToString(nc.convertToOther(8)));
            System.out.println("Binary Number: " + nc.arrayToString(nc.convertToOther(2)));
        }

        System.out.println("Bonus option: Convert to any other base 1 - 64 from base 10?");
        System.out.print("Y/N: ");
        String input = s.nextLine();
        if (input.equals("Y") || input.equals("y"))
        {
            System.out.println("Enter a base 10 number:");
            int baseTenNum = s.nextInt();

            System.out.println("Enter a new base:");
            int newBase = s.nextInt();
            while (newBase < 1 || newBase > 64 || newBase == 10)
            {
                System.out.println("Enter a VALID base:");
                newBase = s.nextInt();
            }
            NumberConverter nb = new NumberConverter(baseTenNum + "", 10);
            System.out.println("Your Number in base " + newBase + ": " + nb.arrayToString(nb.convertToOther(newBase)));
        }
        else
        {
            System.out.println("Okay! Goodbye!");
        }
    }
}
