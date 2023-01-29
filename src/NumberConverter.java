public class NumberConverter {
    int[] digits;
    int base;
    int tensNumber;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public String ArrayToString(int[] array) {
        String o = "";
        for (int i = 0; i < array.length; i++) {
            o = o + array[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int num = 0;
        for (int i = digits.length - 1; i >= 0; i--)
        {
            num += digits[i] * (int) Math.pow(base, digits.length - (i +1));
        }
        tensNumber = num;
        return makeArray("" + num);
    }

    public int[] convertToBinary()
    {
        int tens[] = convertToDecimal();
        int tensAsNum = tensNumber;
        String num = "";
        while (tensAsNum != 0)
        {
            num = tensAsNum % 2 + num;
            tensAsNum /= 2;
        }
        return makeArray(num);
    }

    public int[] convertToOctal() {
        int tens[] = convertToDecimal();
        int tensAsNum = tensNumber;
        String num = "";
        while (tensAsNum != 0)
        {
            num = tensAsNum % 8 + num;
            tensAsNum /= 8;
        }
        return makeArray(num);
    }

    private int[] makeArray(String numberString)
    {
        int[] intArray = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++)
        {
            intArray[i] = Integer.parseInt(numberString.substring(i, i + 1));
        }
        return intArray;
    }
}
