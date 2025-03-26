package Utils;

public class StringManager {

    public int extractNumfromPrice(String inputStr){
        String digitsOnly = inputStr.replaceAll("\\D+", "");
        String numStr = digitsOnly.substring(0, digitsOnly.length()-2);
        int numInt = Integer.parseInt(numStr);
        return numInt;
    }
}
