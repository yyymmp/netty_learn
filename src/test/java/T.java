import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author jlz
 * @className: T
 * @date 2021/4/23 15:01
 * @description todo
 **/
public class T {

    static {
//        i = 0;  // 给变量赋值可以正常编译通过
//            System.out.println(i);  // 这句编译器会提示“非法向前引用”
    }
    static int i = 2;
    static {
        System.out.println(i);
    }
    public class TreeNode {
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


    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return sum;
    }

    public void traverse(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        //中序遍历
        traverse(root.left, low, high);

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        traverse(root.right, low, high);
    }

    public static void main(String[] args) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{17}$";

        String s = "123a456789124567a";
        System.out.println(s.matches(regex));
    }
}
