package util;

public class TaxCalculator {
    private static final double SERVICE_TAX_RATE = 0.14;
    private static final double SWACHH_BHARAT_CESS_RATE = 0.005;
    private static final double KRISHI_KALYAN_CESS_RATE = 0.005;

    public static double calculateServiceTax(double amount) {
        return amount * SERVICE_TAX_RATE;
    }

    public static double calculateSwachhBharatCess(double amount) {
        return amount * SWACHH_BHARAT_CESS_RATE;
    }

    public static double calculateKrishiKalyanCess(double amount) {
        return amount * KRISHI_KALYAN_CESS_RATE;
    }
}
