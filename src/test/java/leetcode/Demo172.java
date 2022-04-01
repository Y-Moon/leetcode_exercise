package leetcode;

import org.junit.Test;

public class Demo172 {
    @Test
    public void demo172(){
        System.out.println(trailingZeroes(50));
    }
    public int trailingZeroes(int n) {
        return powerComputer(n,1);
    }
    public int powerComputer(int baseNumber,int power){
        double pow = Math.pow(5, power);
        if(baseNumber<pow){
            return 0;
        }
        return (int)(baseNumber/pow+powerComputer(baseNumber,power+1));
    }
}
