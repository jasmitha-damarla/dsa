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

public class CountGoodNodesBinaryTree {

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int maxVal) {
        if(root == null) {
            return 0;
        }
        int res = root.val >= maxVal ? 1 : 0;
        maxVal = Math.max(root.val, maxVal);
        System.out.println("Before Left root.val, maxVal, res : " + root.val + ", " + maxVal + ", " + res);
        res += dfs(root.left, maxVal);
        System.out.println("After Left and Before Right root.val, maxVal, res : " + root.val + ", " + maxVal + ", " + res);
        res += dfs(root.right, maxVal);
        System.out.println("After right root.val, maxVal, res : " + root.val + ", " + maxVal + ", " + res);
        return res;
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

        CountGoodNodesBinaryTree countGoodNodesBinaryTree = new CountGoodNodesBinaryTree();
        System.out.println(countGoodNodesBinaryTree.goodNodes(firstTreeNode));
    }
}
