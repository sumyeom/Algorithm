/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        inOrder(root);
        return list;
    }

    public void inOrder(TreeNode node){
        if(node != null){
            if(node.left!=null) inOrder(node.left);
            list.add(node.val);
            if(node.right!=null) inOrder(node.right);
        }
    }
}