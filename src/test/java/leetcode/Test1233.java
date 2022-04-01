package leetcode;

import cn.hutool.core.io.file.FileReader;
import org.junit.Test;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test1233 {
    @Test
    public void testFile() throws IOException {
        FileReader fileReader1=new FileReader(new File("D:\\study\\leetcode\\src\\main\\java\\com\\shunwang\\hotel_old.txt"));
        FileReader fileReader2=new FileReader(new File("D:\\study\\leetcode\\src\\main\\java\\com\\shunwang\\hotel_new.txt"));
        final String s1 = fileReader1.readString();
        final String s2 = fileReader2.readString();
        System.out.println(s1.equals(s2));
    }
    @Test
    public void testMap() throws InterruptedException {
        HashMap<Integer,Integer> map=new HashMap<>();
        IntStream.range(999,0).forEach(i-> {
            System.out.println(i);
            map.put(i, i);
        });
        Thread.sleep(1000);
        System.out.println(map);
    }
    @Test
    public void testMa1p()  {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=99999;
        for (int i1 = i; i1 > 0; i1--) {
            map.put(i1,i1);
        }
        System.out.println(map.keySet().iterator().next());
        System.out.println(map.keySet().iterator().next());
    }
}
