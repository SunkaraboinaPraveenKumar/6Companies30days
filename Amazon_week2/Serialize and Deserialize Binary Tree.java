import java.util.*;

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
class Codec {
    private static String DELIMITER=",";
    private static String NULL_NODE="null";
    // Encodes a tree to a single string.
    StringBuilder sb=new StringBuilder();
    public void preOrder(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(NULL_NODE);
            sb.append(DELIMITER);
            return;
        }
        sb.append(root.val);
        sb.append(DELIMITER);
        preOrder(root.left,sb);
        preOrder(root.right,sb);
    }
    public String serialize(TreeNode root) {
        preOrder(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q=new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        return buildTree(q);
    }
    public TreeNode buildTree(Queue<String> q){
        String val=q.poll();
        if(NULL_NODE.equals(val)){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(val));
        root.left = buildTree(q);
        root.right=buildTree(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));