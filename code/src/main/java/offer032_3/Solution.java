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
                if (treeNode != null) {
                    temp.add(treeNode.val);
                    if (fromLeft) {
                        next.addFirst(treeNode);
                    } else {
                        next.addLast(treeNode);
                    }
                }
                fromLeft = !fromLeft;
            }
            if (!next.isEmpty() && !temp.isEmpty()) {
                toReturn.add(temp);
                queue.add(next);
            }
        }
        return toReturn;
    }
}

