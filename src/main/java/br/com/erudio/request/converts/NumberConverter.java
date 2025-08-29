package br.com.erudio.request.converts;

import br.com.erudio.exception.UnsuportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null && strNumber.isEmpty())
            throw new UnsuportedMathOperationException("Please set a numeric value");
        return Double.parseDouble(strNumber);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null && strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));


    }

}
