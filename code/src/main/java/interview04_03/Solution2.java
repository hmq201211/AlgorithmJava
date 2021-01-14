package interview04_03;

import common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> toReturn = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return toReturn;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            toReturn.add(temp.val);
            for (int i = temp.children.size() - 1; i >= 0; i--) {
                stack.push(temp.children.get(i));
            }
        }
        return toReturn;
    }
}