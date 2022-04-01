package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo2038 {
    @Test
    public void demo2038(){
        String colors="";
        System.out.println(winnerOfGame(colors));
    }
    public boolean winnerOfGame(String colors) {
        if(colors==null||colors.length()<3){
            return false;
        }
        int[] container={0,0};
        int aCount=0,bCount=0;
        for (char c : colors.toCharArray()) {
            if('A'==c){
                bCount=0;
                ++aCount;
                if(aCount>2){
                    container[0]+=1;
                }
            }else if('B'==c){
                aCount=0;
                ++bCount;
                if(bCount>2){
                    container[1]+=1;
                }
            }
        }
        return (container[0] - container[1]) > 0;
    }
}
