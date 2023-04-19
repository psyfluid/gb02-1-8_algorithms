package gb.hw04;


public class MyTree<V extends Comparable<V>> {

    private Node root;

    public boolean add(V value) {
        boolean result;
        if (root == null) {
            root = new Node(value);
            result = true;
        } else {
            result = addNode(root, value);
            root = rebalance(root);
        }

        root.color = Color.BLACK;
        return result;
    }

    private boolean addNode(Node node, V value) {
        if (node.value.equals(value)) return false;

        if (node.value.compareTo(value) > 0) {
            if (node.left != null) {
                boolean result = addNode(node.left, value);
                node.left = rebalance(node.left);
                return result;
            } else {
                node.left = new Node(value);
                return true;
            }
        } else {
            if (node.right != null) {
                boolean result = addNode(node.right, value);
                node.right = rebalance(node.right);
                return result;
            } else {
                node.right = new Node(value);
                return true;
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED
                    && (result.left == null || result.left.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }

            if (result.left != null && result.left.color == Color.RED
                    && result.left.left != null && result.left.left.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED
                    && result.right != null && result.right.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node betweenChild = right.left;
        right.left = node;
        node.right = betweenChild;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node betweenChild = left.right;
        left.right = node;
        node.left = betweenChild;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }


    public boolean contains(V value) {
        return find(root, value) != null;
    }

    private Node find(Node node, V value) {
        if (node == null) return null;
        if (node.value.equals(value)) return node;

        if (node.value.compareTo(value) > 0)
            return find(node.left, value);
        else
            return find(node.right, value);
    }


    private enum Color {
        RED, BLACK
    }

    private class Node {
        private V value;
        private Color color;
        private Node left;
        private Node right;

        public Node() {
            this.color = Color.RED;
        }

        public Node(V value) {
            this();
            this.value = value;
        }
    }

}
