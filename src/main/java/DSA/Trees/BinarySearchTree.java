package DSA.Trees;

public class BinarySearchTree extends BinaryTree {

    @Override
    Node delete(int key) {
        return delete(root, key);
    }

    Node delete(Node root, int key) {
        if (root == null) return root;
        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) return root.left;
            else if (root.right == null) return root.right;

            root.data = minValue(root, root.right);
        }
        return root;
    }

    private int minValue(Node parent, Node cur) {
        while (cur.left != null) {
            parent = cur;
            cur = cur.left;
        }
        if (parent.right == cur) parent.right = null;
        else parent.left = null;

        return cur.data;
    }


    @Override
    public Node buildTree(int[] elements) {
        for (int i : elements) {
            root = insert(root, i);
        }
        return root;
    }

    private Node insert(Node root, int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        }
        if (val > root.data) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    @Override
    void insert(int data) {
        root = insert(root, data);
    }

}
