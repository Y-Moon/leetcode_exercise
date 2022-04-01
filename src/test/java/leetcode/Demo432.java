package leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

//no ac
public class Demo432 {
    HashMap<String, Integer> container=null;
    HashMap<Integer,Set<String>> countContainer=null;
    @Test
    public void demo432(){

    }
    public Demo432() {
        container = new HashMap<>();
        countContainer=new HashMap<>();
    }

    public void inc(String key) {
        int count = container.getOrDefault(key, 0)+1;
        container.put(key,count);
        Set<String> countSet = countContainer.computeIfAbsent(count, t -> new HashSet<>());
        countSet.add(key);
        if(count>1){
            Set<String> lastSet = countContainer.get(count-1);
            lastSet.remove(key);
            if(lastSet.size()==0){
                countContainer.remove(count-1);
            }
        }
    }

    public void dec(String key) {
        Integer count = container.getOrDefault(key,0);
        if(count==null||count==0){
            return;
        }
        if(count>0){
            Set<String> lastSet = countContainer.get(count);
            if(lastSet!=null){
                lastSet.remove(key);
                if(lastSet.size()==0){
                    countContainer.remove(count);
                }
            }
            if(count==1){
                container.remove(key);
            }else{
                container.put(key,count-1);
                Set<String> countSet = countContainer.computeIfAbsent(count - 1,t-> new HashSet<>());
                countSet.add(key);
            }
        }
    }

    public String getMaxKey() {
        Set<String> strings = countContainer.get(0);
        return strings.iterator().next();
    }

    public String getMinKey() {
        Set<String> strings = countContainer.get(0);
        return strings.iterator().next();
    }
}
