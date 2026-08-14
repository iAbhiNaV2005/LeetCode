import java.util.*;

class Solution {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {

        // Empty subtree
        if (node == null) {
            return "#";
        }

        // Serialize left and right subtrees
        String left = serialize(node.left);
        String right = serialize(node.right);

        // Create unique representation
        String key = node.val + "," + left + "," + right;

        // Increase frequency
        int count = map.getOrDefault(key, 0);

        // Add only when it appears for the second time
        if (count == 1) {
            result.add(node);
        }

        map.put(key, count + 1);

        return key;
    }
}