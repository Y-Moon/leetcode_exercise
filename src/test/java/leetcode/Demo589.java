package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo589 {
    @Test
    public void demo589(){
        Node node=new Node(1);
        node.children=new ArrayList<>();
        node.children.add(new Node(3));
        node.children.add(new Node(2));
        node.children.add(new Node(4));
        node.children.get(0).children=new ArrayList<>();
        node.children.get(0).children.add(new Node(5));
        node.children.get(0).children.add(new Node(6));
        final List<Integer> preorder = preorder(node);
        System.out.println(preorder);
    }
    public List<Integer> preorder(Node root) {
        Node cur=root;
        List<Node> stack=new ArrayList<>();
        if(root!=null){
            stack.add(cur);
        }
        List<Integer> result=new ArrayList<>();
        while (stack.size()>0){
            Node removeNode = stack.remove(stack.size()-1);
            result.add(removeNode.val);
            List<Node> children = removeNode.children;
            if(children!=null&&children.size()>0){
                for (int i = children.size()-1; i >= 0; i--) {
                    if(children.get(i)!=null){
                        stack.add(children.get(i));
                    }
                }
            }
        }
        return result;
    }
// Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
