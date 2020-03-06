package Top100;

public class flatten {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
        }
        if (root.right != null) {
            flatten(root.right);
        }
        if (root.left != null) {
            root.right = root.left;
            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            node.right = root.right;
            root.left = null;
        }
    }
}
