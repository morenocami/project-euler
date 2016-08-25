package questions;

public class Question17 {

    public static void main(String[] args) {
        Question17 q17 = new Question17();
        long totalAlphaCharacters = 0;
        for (int number = 1; number <= 1000; number++) {
            String numberInWords = q17.makeNumberUpTo1000IntoWords(number);
            System.out.println(numberInWords);
            totalAlphaCharacters += q17.countAlphaCharacters(numberInWords);
        }
        System.out.println(totalAlphaCharacters);
    }

    public String makeNumberUpTo1000IntoWords(int number) {
        if (number < 0) {
            return "Invalid input.";
        }
        if (number < 10) {
            return oneDigitNumberToWord(number);
        }
        if (number < 100) {
            return makeNumberUpTo99InWords(number);
        }
        if (number < 1000) {
            return makeNumberUpTo999InWords(number);
        }
        if (number == 1000) {
            return "one thousand";
        }
        return "Number too large.";
    }

    private String oneDigitNumberToWord(int input) {
        switch (input) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }
        return "zero";
    }

    private String makeNumberUpTo99InWords(int number) {
        String stringOfDigits = oneDigitNumberToWord(number % 10)
         + " " + oneDigitNumberToWord(getTensDigitFromInteger(number));
        String[] digitList = stringOfDigits.split(" ");
        String word = addTensPlace(digitList);
        if (digitList[1].equals("one")) {
            return word;
        }
        if (!digitList[0].equals("zero")) {
            word += "-" + oneDigitNumberToWord(number % 10);
        }
        return word;
    }

    private String makeNumberUpTo999InWords(int number) {
        String stringOfDigits = oneDigitNumberToWord(number % 10) + " " +
                oneDigitNumberToWord(getTensDigitFromInteger(number)) + " " +
                oneDigitNumberToWord(getHundredsDigitFromInteger(number));
        String[] digitList = stringOfDigits.split(" ");
        String word = oneDigitNumberToWord(getHundredsDigitFromInteger(number)) + " hundred ";
        if (!(digitList[0].equals("zero") && digitList[1].equals("zero"))) {
            word += "and " + makeNumberUpTo99InWords(number);
        }
        return word;
    }

    private int getTensDigitFromInteger(int number) {
        return ((number - (number % 10)) / 10) % 10;
    }

    private int getHundredsDigitFromInteger(int number) {
        return (number - (number % 100)) / 100;
    }

    private String addTensPlace(String[] list) {
        switch (list[1]) {
            case "one":
                return integerTensToString(list[0]);
            case "two":
                return "twenty";
            case "three":
                return "thirty";
            case "four":
                return "forty";
            case "five":
                return "fifty";
            case "six":
                return "sixty";
            case "seven":
                return "seventy";
            case "eight":
                return "eighty";
            case "nine":
                return "ninety";
        }
        return "";
    }

    private String integerTensToString(String s) {
        switch (s) {
            case "one":
                return "eleven";
            case "two":
                return "twelve";
            case "three":
                return "thirteen";
            case "four":
                return "fourteen";
            case "five":
                return "fifteen";
            case "six":
                return "sixteen";
            case "seven":
                return "seventeen";
            case "eight":
                return "eighteen";
            case "nine":
                return "nineteen";
        }
        return "ten";
    }

    private long countAlphaCharacters(String numberInWords) {
        numberInWords = numberInWords.replace(" ", "");
        numberInWords = numberInWords.replace("-", "");
        return numberInWords.length();
    }
}
