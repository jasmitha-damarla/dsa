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

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    int l = 0;
    int r = 0;

    public boolean isBalancedDfs(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int l = dfs(root.left);
        if(l == -1) return -1;
        
        int r = dfs(root.right);
        if(r == -1) return -1;

        if(Math.abs(l-r)>1) {
            return -1;
        }

        return 1 + Math.max(l, r);
        
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

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println(balancedBinaryTree.isBalanced(firstTreeNode) ? "Yes.!" : "No!");
        System.out.println(balancedBinaryTree.isBalancedDfs(firstTreeNode) ? "Yes.!" : "No!");

    }
    
}
