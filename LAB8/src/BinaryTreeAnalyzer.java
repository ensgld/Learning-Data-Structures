import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeAnalyzer {

    private BinaryTree tree;
    private ArrayList<ArrayList<Node>> levels;

    public BinaryTreeAnalyzer(BinaryTree tree) {
        this.tree = tree;
        this.levels = new ArrayList<>();
        traverseTree();
    }

    private void traverseTree() {
        if (tree.root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Node> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode);

                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }

            levels.add(currentLevel);
        }
    }

    public void printLevels() {
        for (int i = 0; i < levels.size(); i++) {
            System.out.print("Level " + i + ": ");
            for (Node node : levels.get(i)) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
    }

    public void traverseInOrder(Node node) {
        if (node == null) return;

        traverseInOrder(node.left);
        System.out.print(node.value + " ");
        traverseInOrder(node.right);
    }

    public void traversePreOrder(Node node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public void traversePostOrder(Node node) {
        if (node == null) return;

        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node("A");
        tree.root.left = new Node("B");
        tree.root.right = new Node("C");
        tree.root.left.left = new Node("D");
        tree.root.left.right = new Node("E");
        tree.root.right.left = new Node("F");
        tree.root.right.right = new Node("G");

        BinaryTreeAnalyzer analyzer = new BinaryTreeAnalyzer(tree);
        System.out.println("Inorder Traversal:");
        analyzer.traverseInOrder(tree.root);
        System.out.println("\nPreorder Traversal:");
        analyzer.traversePreOrder(tree.root);
        System.out.println("\nPostorder Traversal:");
        analyzer.traversePostOrder(tree.root);

        System.out.println("\n\nLevels:");
        analyzer.printLevels();
    }
}
