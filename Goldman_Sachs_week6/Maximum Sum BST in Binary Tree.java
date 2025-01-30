package Goldman_Sachs_week6;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    class Pair {
        int sum;
        boolean isBst;
        int maxLeft;
        int minRight;

        public Pair(int sum, boolean isBst, int maxLeft, int minRight) {
            this.sum = sum;
            this.isBst = isBst;
            this.maxLeft = maxLeft;
            this.minRight = minRight;
        }
    }

    int ansSum = 0;

    public Pair traversal(TreeNode root) {
        if (root == null) {
            return new Pair(0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Pair left = traversal(root.left);
        Pair right = traversal(root.right);
        if (left.isBst && right.isBst && root.val > left.maxLeft && root.val < right.minRight) {
            int currSum = left.sum + right.sum + root.val;
            ansSum = Math.max(ansSum, currSum);
            return new Pair(currSum, true, Math.max(right.maxLeft, root.val), Math.min(left.minRight, root.val));
        } else {
            return new Pair(0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    public int maxSumBST(TreeNode root) {
        traversal(root);
        return ansSum;
    }
}
