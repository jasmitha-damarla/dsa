package Trees;

import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreeRightView {

    List<Integer> sol = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        dfs(root, 0);
        return sol;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (sol.size() == depth) {
            sol.add(node.val);
        }

        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
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

        BinaryTreeRightView binaryTreeRightView = new BinaryTreeRightView();
        System.out.println(binaryTreeRightView.rightSideView(firstTreeNode));
    }
    
}
