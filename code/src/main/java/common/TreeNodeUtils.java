package common;


/**
 * @Description:
 * @Author: Mingqing Hou
 * @Create: 2020-09-08 14:18
 **/
public class TreeNodeUtils {
    public static TreeNode parseString(String string) {
        String usefulPart;
        if (string.length() < 2 || (usefulPart = string.substring(1, string.length() - 1)).length() == 0)
            return null;
        String[] split = usefulPart.split(",");
        TreeNode[] treeNodes = new TreeNode[split.length];
        for (int i = 0; i < split.length; i++) {
            if (!"null".equals(split[i]))
                treeNodes[i] = new TreeNode(Integer.parseInt(split[i]));
            else {
                treeNodes[i] = null;
            }
        }
        for (int i = 0; i < split.length; i++) {
            if (treeNodes[i] != null) {
                if (2 * i + 1 < split.length) {
                    treeNodes[i].left = treeNodes[2 * i + 1];
                }
                if (2 * i + 2 < split.length) {
                    treeNodes[i].right = treeNodes[2 * i + 2];
                }
            }
        }
        return treeNodes[0];
    }

    public static void printTree(TreeNode root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.println(root);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = parseString("[0,null,1,null,null,2,3]");
        printTree(treeNode);
    }
}
