package interview04_03;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null){
            return null;
        }
        ArrayList<ListNode> toReturn = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            for(int size = queue.size(); size>0 ; size-- ){
                TreeNode temp = queue.poll();
                current.next = new ListNode(temp.val);
                current = current.next;
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            toReturn.add(dummy.next);
        }
        return toReturn.toArray(new ListNode[0]);
    }
}