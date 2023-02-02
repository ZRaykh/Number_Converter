public class NumberConverter {
    private int[] digits;
    private int base;
    private int tensNumber;
    private String values = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";


    public NumberConverter(String number, int base) {
        digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = values.indexOf((number.charAt(i)));
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

    public String arrayToString(int[] array) {
        String o = "";
        for (int i = 0; i < array.length; i++) {
            o += values.charAt(array[i]);
        }
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int[] digitsNum;
        int num = 0;
        int power = 0;
        int scale = 0;
        for (int i = digits.length - 1; i >= 0; i--)
        {
            num += digits[i] * Math.pow(base, scale);
            scale++;
        }
        scale = 0;
        while (Math.pow(10, power) <= num)
        {
            power++;
        }
        digitsNum = new int[power];
        power--;
        for (int i = 0; i < digitsNum.length; i++)
        {
            digitsNum[i] = (int) (num / Math.pow(10, power));
            num -= digitsNum[i] * Math.pow(10, power);
            power--;
        }
        return digitsNum;
    }

    public int[] convertToOther(int newBase)
    {
        int num;
        int power = 0;
        int converted[];
        if (base != newBase)
        {
            if (base == 10)
            {
                num = Integer.parseInt(arrayToString(digits));
            }
            else
            {
                num = Integer.parseInt(arrayToString(convertToDecimal()));
            }
            if (newBase == 1)
            {
                converted = new int[num];
                for (int i = 0; i < num; i++)
                {
                    converted[i] = 1;
                }
                return converted;
            }
            while (Math.pow(newBase, power) <= num)
            {
                power++;
            }
            converted = new int[power];
            power--;
            for (int i = 0; i < converted.length; i++)
            {
                converted[i] = num / (int) (Math.pow(newBase, power));
                num %= (int) (Math.pow(newBase, power));
                power --;
            }
            return converted;
        }
        return null;
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