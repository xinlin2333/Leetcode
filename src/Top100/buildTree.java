package Top100;

import java.util.Arrays;

/**
 * @author canoeYang
 * @Date 2020-03-06 22:09
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class buildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        root.val = preorder[0];
        int pos = 0;
        while (inorder[pos] != preorder[0]) {
            pos++;
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, pos + 1), Arrays.copyOfRange(inorder, 0, pos));
        root.right = buildTree(Arrays.copyOfRange(preorder, pos + 1, preorder.length), Arrays.copyOfRange(inorder, pos + 1, inorder.length));
        return root;
    }
}
