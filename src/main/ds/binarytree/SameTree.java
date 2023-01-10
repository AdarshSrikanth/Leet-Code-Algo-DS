package main.ds.binarytree;

import main.Util;
import main.Util.TreeNode;
import java.util.Queue;
import java.util.LinkedList;

public class SameTree {
    public static void main(String[] args) {
        Util.TreeNode p = new Util.TreeNode(1);
        p.left = new Util.TreeNode(2);
        p.right = new Util.TreeNode(3);
        Util.TreeNode q = new Util.TreeNode(1);
        q.left = new Util.TreeNode(2);
        // q.right = new Util.TreeNode(3);
        Util.println("Trees are same - " + isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> t1 = new LinkedList<TreeNode>();
        Queue<TreeNode> t2 = new LinkedList<TreeNode>();

        t1.add(p);
        t2.add(q);

        while(!t1.isEmpty() && !t2.isEmpty()) {
            TreeNode tc1 = t1.remove();
            TreeNode tc2 = t2.remove();
            if (tc1 != null && tc2 != null && tc1.val == tc2.val) {
                // equal value nodes. add children to queue
                t1.add(tc1.left);
                t1.add(tc1.right);
                t2.add(tc2.left);
                t2.add(tc2.right);
            }
            else if (tc1 == null && tc2 == null) {
                // equal value null nodes
                continue;
            }
            else {
                // One of them is not equal or not null
                return false;
            }
        }

        if (t1.isEmpty() != t2.isEmpty()) {
            return false;
        }

        return true;
    }
}
