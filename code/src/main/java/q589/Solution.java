package q589;

import common.Node;

import java.util.ArrayList;
import java.util.List;

public  class Solution {
    List<Integer> toReturn = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null)
            return toReturn;
        toReturn.add(root.val);
        for(Node temp : root.children){
            preorder(temp);
        }
        return toReturn;
    }
}