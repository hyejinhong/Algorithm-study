package leetcode;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeetCode_1302 {


    static class TreeNode {
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

    static int maxDepth = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), ",");

        // 1,2,3,4,5,null,6,7,null,null,null,null,8
        int[] arr = new int[10001];
        int index = 0;
        while (stk.hasMoreTokens()) {
            String token = stk.nextToken();
            if(token.equals("null")) {
                arr[index++] = -1;
            }
            else {
                arr[index++] = Integer.parseInt(token);
            }
        }

        TreeNode root = new TreeNode(arr[0]);
        for(int i=0; i<index-1; i++) {
            TreeNode node = new TreeNode(arr[i]);

            int l = 2*i+1;
            int r = 2*i+2;

            // range check
            if(l >= index-1 || r >= index-1) {
                break;
            }

            // 자식이 없는 경우
            if(arr[l] == -1) {
                node.left = null;
            }
            else {
                node.left = new TreeNode(arr[l]);
            }

            if(arr[r] == -1) {
                node.right = null;
            }
            else {
                node.right = new TreeNode(arr[r]);
            }
        }

        deepestLeavesSum(root);
        System.out.println(sum);
    }

    public static int deepestLeavesSum(TreeNode root) {

        dfs(root, 0);

        return sum;
    }

    public static void dfs(TreeNode cur, int depth) {
        if(cur == null)
            return;

        // maxDepth보다 깊이 왔으면 갱신
        if (maxDepth < depth) {
            maxDepth = depth;
            sum = cur.val;
        }
        // 같은 깊이면 합해줌
        else if(maxDepth == depth) {
            sum += cur.val;
        }

        dfs(cur.left, depth+1);
        dfs(cur.right, depth+1);
    }
}
