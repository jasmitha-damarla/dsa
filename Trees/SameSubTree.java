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

public class SameSubTree {
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        } 
        
        if(subRoot == null) {
            return true;
        }

        if(isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
            
        } 
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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

        TreeNode sfirstTreeNode = new TreeNode(1);
        TreeNode ssecondTreeNode = new TreeNode(2);
        TreeNode sthirdTreeNode = new TreeNode(3);

        sfirstTreeNode.left = ssecondTreeNode;
        sfirstTreeNode.right = sthirdTreeNode;

        SameSubTree sameSubTree = new SameSubTree();
        System.out.println(sameSubTree.isSubtree(firstTreeNode, sfirstTreeNode) ? "Yes.!" : "No!");

    }
}
