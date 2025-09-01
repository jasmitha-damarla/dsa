package Trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { this.val = val; }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBTWithPreAndInOrder {

    int preIdx = 0, inIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int limit) {
        if(preIdx >= preorder.length) {
            return null;
        }
        if(inorder[inIdx] == limit) {
            inIdx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        root.left = dfs(preorder, inorder, root.val);
        root.right = dfs(preorder, inorder, limit);
        return root;

    }

    public void printPostorder(TreeNode node) {
        if (node == null) return;
        
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
        
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        
        ConstructBTWithPreAndInOrder constructBTWithPreAndInOrder = new ConstructBTWithPreAndInOrder();
        TreeNode root = constructBTWithPreAndInOrder.buildTree(preorder, inorder);
        constructBTWithPreAndInOrder.printPostorder(root);
    }
}
