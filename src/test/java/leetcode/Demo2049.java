package leetcode;

import org.junit.Test;

import java.util.*;

public class Demo2049 {
//    long maxScore = 0;
//    int cnt = 0;
//    int n;
    List<Integer>[] children;
    int[] left, right;
    //最大分数, 注意溢出，这里用 long
    long maxScore;
    //最大分数量
    int cnt;
    //整棵树大小
    int n;
    @Test
    public void demo2049(){
        int[] parents={-1,2,0,2,0};
        System.out.println(countHighestScoreNodes2(parents));
    }


    public int countHighestScoreNodes2(int[] parents) {
        n = parents.length;
        left = new int[n];
        right = new int[n];
        //初始化树的表示，-1表示空节点
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        //构建树的表示
        for (int i = 1; i < n; i++) {
            //填充左右节点无所谓，这里优先填左节点
            if (left[parents[i]] == -1) {
                left[parents[i]] = i;
            } else {
                right[parents[i]] = i;
            }
        }
        //dfs处理更新相关值
        dfs(0);
        return cnt;
    }

    //返回以此节点为根节点的子树的大小
    private long dfs(int node) {
        if (node == -1) {
            return 0;
        }
        //dfs 获取左右子树大小
        long leftSize = dfs(left[node]), rightSize = dfs(right[node]);
        //计算三个联通块的乘积
        long score = Math.max(leftSize, 1) * Math.max(rightSize, 1) * Math.max(n - leftSize - rightSize - 1, 1);
        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return leftSize + rightSize + 1;
    }
    public int countHighestScoreNodes1(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        Map<Integer,Integer> cache=new HashMap<>();
        dfs(0,cache);
        return cnt;
    }

    public int dfs(int node,Map<Integer,Integer> cache) {
        if(cache.containsKey(node)){
            return cache.get(node);
        }
        long score = 1;
        int size = n - 1;
        for (int c : children[node]) {
            int t = dfs(c,cache);
            score *= t;
            size -= t;
            if(!cache.containsKey(c)){
                cache.put(c,t);
            }
        }
        if (node != 0) {
            score *= size;
        }
        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return n - size;
    }

//    public int countHighestScoreNodes(int[] parents) {
//        Map<Integer, List<Integer>> nodeMap=new HashMap<>();
//        for (int i = 0; i < parents.length; i++) {
//            if(!nodeMap.containsKey(parents[i])){
//                nodeMap.put(parents[i],new ArrayList<>());
//            }
//            List<Integer> list = nodeMap.get(parents[i]);
//            list.add(i);
//        }
//    }
    public int countHighestScoreNodes(int[] parents) {
        Map<Integer, List<Integer>> nodeMap=new HashMap<>();
        Map<Integer,Integer> cache=new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            if(!nodeMap.containsKey(parents[i])){
                nodeMap.put(parents[i],new ArrayList<>());
            }
            List<Integer> list = nodeMap.get(parents[i]);
            list.add(i);
        }
        long max=0;
        int maxCount=0;
        long nodeSize=0;
        for (int i = 0; i < parents.length; i++) {
            if(nodeMap.containsKey(i)){
                nodeSize=nodeCount(parents,i,nodeMap,cache);
            }else{
                nodeSize=parents.length-1;
            }
            if(nodeSize>max){
                max=nodeSize;
                maxCount=1;
            }else if(nodeSize==max){
                ++maxCount;
            }
        }
        return maxCount;
    }
    public long nodeCount(int[] parents,int delNode,Map<Integer,List<Integer>> nodeMap,Map<Integer,Integer> cache){
        List<Integer> nodeList = nodeMap.get(delNode);
        long count=0;
        if(nodeList!=null){
            long otherCount=parents.length-1;
            for (Integer children : nodeList) {
                List<Integer> stack=new ArrayList<>();
                int childrenCount=0;
                stack.add(children);
                while (stack.size()>0){
                    Integer remove = stack.remove(stack.size() - 1);
                    if(cache.containsKey(remove)){
                        childrenCount+=cache.get(remove);
                    }else{
                        ++childrenCount;
                        List<Integer> list = nodeMap.get(remove);
                        if(list!=null){
                            for (int i = list.size()-1; i >=0 ; i--) {
                                stack.add(list.get(i));
                            }
                        }
                    }
                }
                if(!cache.containsKey(children)){
                    cache.put(children,childrenCount);
                }
                count=count==0?childrenCount:count*childrenCount;
                otherCount-=childrenCount;
            }
            if(count>0&&otherCount>0){
                count=count*otherCount;
            }
        }
        return count;
    }
}
