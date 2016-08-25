package questions;

import java.math.BigInteger;

public class Question16 {

    public static void main(String[] args) {
        BigInteger base = new BigInteger("2");
        String result = base.pow(1000).toString();
        int answer = 0;
        for (int x = 0; x < result.length(); x++) {
            answer += Integer.parseInt(result.substring(x,x+1));
        }
        System.out.println(answer);
    }
}
