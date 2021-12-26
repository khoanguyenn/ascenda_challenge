package util;
public class DecimalUtil {
    public static double formatDecimal(double number) {
        //11.81 32.19 31.10

        double lower = Math.floor(number); //11.0 32.0 31.0
        double decimals = number % lower; //0.81 0.19 0.10
        //When number equals to 0.1, 0.2, 0.3,... 0.9
        if ((int) (decimals * 100) % 10 == 0) {
            return number;
        }

        //Rouding into the nearst 0.05
        double rounding;
        if (Math.floor(decimals / 0.05) % 2 == 0) {
            rounding = Math.ceil(decimals / 0.05) * 0.05;
        } else {
            return number;
        }
        return lower + rounding; //11.85 32.2
    } 
}
