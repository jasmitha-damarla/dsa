package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class LevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> sol = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            
            for(int i = q.size(); i > 0; i--) {
                TreeNode cur = q.poll();
                if(cur != null) {
                    level.add(cur.val);
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            if(level.size() > 0) {
                sol.add(level);
            }
        }
        return sol;
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

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.levelOrder(firstTreeNode).forEach(node -> System.out.println(node));
    }
}
