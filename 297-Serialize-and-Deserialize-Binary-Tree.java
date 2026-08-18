import java.util.*;

public class Codec {
    private static final String NULL_NODE = "null";
    private static final String DELIMITER = ",";

    // Encodes a tree to a single string using Preorder DFS (Root -> Left -> Right).
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }

    private void serializeDFS(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_NODE).append(DELIMITER);
            return;
        }
        // Append root value, then traverse left and right
        sb.append(node.val).append(DELIMITER);
        serializeDFS(node.left, sb);
        serializeDFS(node.right, sb);
    }

    // Decodes your encoded data back to the binary tree.
    public TreeNode deserialize(String data) {
        // Split values by delimiter and store them sequentially in a Queue
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        return deserializeDFS(nodes);
    }

    private TreeNode deserializeDFS(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals(NULL_NODE)) {
            return null;
        }

        // Reconstruct the node and its subtrees
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeDFS(nodes);
        node.right = deserializeDFS(nodes);
        return node;
    }
}