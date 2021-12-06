package application;

public class CurrencyConverter {
    // currency
    private final String CAD = "CAD";
    private final String USD = "USD";
    private final String YEN = "YEN";
    // CAD <---> USD
    private double cadToUsdRate = 0.75;
    private double usdToCadRate = 1.33;
    // CAD <---> YEN
    private double cadToYenRate = 83.49;
    private double yenToCadRate = 0.012;
    // USD <---> YEN
    private double usdToYenRate = 111.42;
    private double yenToUsdRate = 0.009;
    
    /**
     * do the calculation to convert the currency
     * @param left the left-side currency (the one user input the number)
     * @param right the right-side currency (the one user would like to see the conversion)
     * @param leftValue the user input value
     * @return the conversion of user input to the right-side currency value
     */
    public double currencyConversion(String left, String right, double leftValue){
        if(left.equals(right)){
            return leftValue;
        }
        double rate = matchRate(left, right);
        return leftValue * rate;
    }
    
    /**
     * find the match rate for the user provided currency
     * @param left the left-side currency
     * @param right the right-side currency
     * @return the rate for conversion between the 2 currencies
     */
    public double matchRate(String left, String right){
        double rate = 0;
        switch (left) {
            case CAD:
                if (right.equals(USD)) {
                    rate = cadToUsdRate;
                } else if (right.equals(YEN)) {
                    rate = cadToYenRate;
                }   break;
            case USD:
                if (right.equals(CAD)) {
                    rate = usdToCadRate;
                } else if (right.equals(YEN)) {
                    rate = usdToYenRate;
                }   break;
            case YEN:
                if (right.equals(CAD)) {
                    rate = yenToCadRate;
                } else if (right.equals(USD)) {
                    rate = yenToUsdRate;
                }   break;
            default:
                break;
        }
        return rate;
    }
}