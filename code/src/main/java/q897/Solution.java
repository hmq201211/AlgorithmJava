package q897;

import common.TreeNode;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.left != null){
            TreeNode left = increasingBST(root.left);
            left.left = null;
            TreeNode temp = left;
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = root;
            root.left = null;
            root.right = increasingBST(root.right);
            return left;
        }else if(root.right != null){
            root.right = increasingBST(root.right);
        }
        return root;
    }
}