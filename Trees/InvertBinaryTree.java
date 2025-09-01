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


public class InvertBinaryTree {
    
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public void preOrderPrint(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val + " ");
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

    public static void main(String[] args) {
        
        TreeNode firstTreeNode = new TreeNode(1);
        TreeNode secondTreeNode = new TreeNode(2);
        TreeNode thirdTreeNode = new TreeNode(3);
        TreeNode fourthTreeNode = new TreeNode(4);
        TreeNode fifthTreeNode = new TreeNode(5);
        TreeNode sixthTreeNode = new TreeNode(6);
        TreeNode seventhTreeNode = new TreeNode(7);

        firstTreeNode.left = secondTreeNode;
        firstTreeNode.right = thirdTreeNode;

        secondTreeNode.left = fourthTreeNode;
        secondTreeNode.right = fifthTreeNode;

        thirdTreeNode.left = sixthTreeNode;
        thirdTreeNode.right = seventhTreeNode;

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode result = invertBinaryTree.invertTree(firstTreeNode);
        invertBinaryTree.preOrderPrint(result);
    }
}
