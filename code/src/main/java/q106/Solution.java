package q106;

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode buildTree(int[] inorder, int in_start, int in_end,
                              int[] postorder, int post_start, int post_end){
        if(in_end<in_start||post_end<post_start)
            return null;
        int value = postorder[post_end];
        int index = in_start;
        for(int i = index; i <= in_end; i++){
            if(value == inorder[i]){
                index = i;
                break;
            }
        }
        int left_size = index - in_start;
        TreeNode root = new TreeNode(value);
        root.left = buildTree(inorder, in_start, index-1, postorder, post_start, post_start+left_size-1);
        root.right = buildTree(inorder,index+1,in_end,postorder, post_start+left_size,post_end-1);
        return root;
    }
}