package leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo599 {
    @Test
    public void demo599(){
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.asList(findRestaurant(list1,list2)));
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        if(Objects.isNull(list1)||Objects.isNull(list2)){
            return new String[0];
        }
        String[] main=list1.length>list2.length?list2:list1;
        String[] other=list1.length>list2.length?list1:list2;
        Map<String,Integer> otherMap=new HashMap<>();
        for (int i = 0; i < other.length; i++) {
            otherMap.put(other[i],i);
        }
        List<String> result=new ArrayList<>();
        int min=list1.length+list2.length;
        for (int i = 0; i < main.length; i++) {
            final String key = main[i];
            if(otherMap.containsKey(key)){
                int index=i+otherMap.get(key);
                if(min>index){
                    result.clear();
                    result.add(key);
                    min=i+otherMap.get(key);
                }else if(min==index){
                    result.add(key);
                }

            }
        }
        return result.toArray(new String[0]);
    }
}
