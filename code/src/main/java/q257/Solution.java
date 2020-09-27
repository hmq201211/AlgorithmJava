package q257;


import common.TreeNode;
import common.TreeNodeUtils;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> strings = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        dfs(root, stringBuilder, strings);
        return strings;
    }

    private void dfs(TreeNode treeNode, StringBuilder before, List<String> list) {
        if (treeNode == null)
            return;
        if (treeNode.left == null && treeNode.right == null) {
            list.add(before.toString() + treeNode.val);
        } else {
            before.append(treeNode.val).append("->");
            dfs(treeNode.left, before, list);
            dfs(treeNode.right, before, list);
            before.delete(before.length() - 2 - ("" + treeNode.val).length(), before.length());
        }
    }

    public static void main(String[] args) {
        String s = "[1,2,3,null,5,null,null]";
        TreeNode treeNode = TreeNodeUtils.parseString(s);
        List<String> strings = new Solution().binaryTreePaths(treeNode);
        System.out.println(strings);
    }

}