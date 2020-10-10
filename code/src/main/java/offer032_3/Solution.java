package offer032_3;

import common.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return null;
        boolean fromLeft = false;
        List<List<Integer>> toReturn = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        Queue<Deque<TreeNode>> queue = new LinkedList<>();
        queue.add(deque);
        while (!queue.isEmpty()) {
            Deque<TreeNode> treeNodes = queue.poll();
            List<Integer> temp = new ArrayList<>();
            Deque<TreeNode> next = new LinkedList<>();
            while (!treeNodes.isEmpty()) {
                TreeNode treeNode = treeNodes.pollFirst();
                if (fromLeft) {
                    if (treeNode.right != null) {
                        next.addFirst(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        next.addFirst(treeNode.left);
                    }
                } else {
                    if (treeNode.right != null) {
                        next.addLast(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        next.addLast(treeNode.left);
                    }
                }
                fromLeft = !fromLeft;
            }
            toReturn.add(temp);
            queue.add(next);

        }
        return toReturn;
    }
}

