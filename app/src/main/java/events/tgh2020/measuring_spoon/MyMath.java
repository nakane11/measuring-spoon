package events.tgh2020.measuring_spoon;

public class MyMath {

    static double parse(String ratio) {
        if (ratio.contains("/")) {
            String[] rat = ratio.split("/");
            return Double.parseDouble(rat[0])/Double.parseDouble(rat[1]);
        } else {
            return Double.parseDouble(ratio);
        }
    }

    static double ratio(double amount){
        double i;
        if(amount>0.5){
            i=1d;
            while(true){
                if(i*i*(3-i)/2 > amount){
                    i-=0.001;
                    continue;
                }else{
                    break;
                }
            }
        }else{
            i=0d;
            while(true){
                if(i*i*(3-i)/2 < amount){
                    i+=0.001;
                    continue;
                }else{
                    break;
                }
            }
        }

        return Math.sqrt(i*(2-i));
    }
}
