package org.example.algorithm;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。​
 * 路径和 是路径中各节点值的总和。​
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 ​
 *
 * 输入=[1,2,3]。输出6​
 * 输入是=[-10,9,20,null,null,15,7]；输出42​
 *
 *   1​
 * 2. 3​
 *  -10​
 * 9    20​
 *     15  7
 */
public class MyTreeNode {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        private int maxSum;

        public int maxPathSum(TreeNode root) {
            maxSum = Integer.MIN_VALUE;
            maxAdd(root); // 初始化最大路径和的计算
            return maxSum;
        }

        private int maxAdd(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // 递归计算左子树和右子树的最大路径和增益
            int left = Math.max(maxAdd(node.left), 0);
            int right = Math.max(maxAdd(node.right), 0);

            // 计算经过当前节点的最大路径和，并更新全局最大路径和
            int curSum = node.val + left + right;
            maxSum = Math.max(maxSum, curSum);

            // 返回以当前节点为根的子树中，经过当前节点的最大路径和增益
            return node.val + Math.max(left, right);
        }
    }
    public static void main(String[] args) {
        // 构造第一个测试用例的二叉树
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(root1)); // 输出应为6

        // 构造第二个测试用例的二叉树
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);

        System.out.println(solution.maxPathSum(root2)); // 输出应为42
    }
}
