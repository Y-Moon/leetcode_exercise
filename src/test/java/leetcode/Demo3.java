package leetcode;

import org.junit.Test;

import java.util.*;

public class Demo3 {
    @Test
    public void leetcode(){
        System.out.println(subString("abba"));
    }
    public int subString(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        int maxLength=0,start=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(map.containsKey(c)){
                maxLength=Math.max(maxLength,i-start);
                start= Math.max(start, (map.get(c) + 1));
            }
            map.put(c,i);
        }
        maxLength=Math.max(maxLength,s.length()-start);
        return maxLength;
    }
}
