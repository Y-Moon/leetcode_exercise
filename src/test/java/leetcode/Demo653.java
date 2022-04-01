package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo653 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void demo653() {
        TreeNode root = new TreeNode();
        System.out.println(findTarget(root, 28));
    }

    public boolean findTarget(TreeNode root, int k) {
        TreeNode left=root;
        List<TreeNode> leftList=new ArrayList<>();
        leftList.add(left);
        Set<Integer> treeSet=new HashSet<>();
        while (leftList.size()>0){
            TreeNode remove = leftList.remove(leftList.size() - 1);
            if(treeSet.contains(k-remove.val)){
                return true;
            }
            treeSet.add(remove.val);
            if(remove.right!=null){
                leftList.add(remove.right);
            }
            if(remove.left!=null){
                leftList.add(remove.left);
            }
        }
        return false;
    }
}
