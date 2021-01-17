package iterativeTreeTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> toReturn = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        if(root == null){
            return toReturn;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            Object pop = stack.pop();
            if(pop instanceof Integer){
                toReturn.add((Integer) pop);
            }else{
                TreeNode temp = (TreeNode)pop;
                if(temp.right != null)
                    stack.push(temp.right);
                stack.push(temp.val);
                if(temp.left != null)
                    stack.push(temp.left);
            }
        }
        return toReturn;
    }
}
