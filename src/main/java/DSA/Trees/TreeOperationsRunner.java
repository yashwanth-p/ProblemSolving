package DSA.Trees;

public class TreeOperationsRunner {
    public static void main(String[] args) {
        simpleTreeOperations();
        syntaxTreeOperations();
    }

    private static void syntaxTreeOperations() {
        int i = 0;
        SyntaxTree syntaxTree = new SyntaxTree();
        syntaxTree.buildTree();
        syntaxTree.evaluateExpression();
    }

    private static void simpleTreeOperations() {
        BinaryTree sampleTree = new BinaryTree();
        sampleTree.getASampleTree();
        sampleTree.printLevelOrder();
        sampleTree.levelOrderInsert(11);
        sampleTree.printLevelOrder();
        sampleTree.clearTree();
        sampleTree.levelOrderInsert(2);
        sampleTree.levelOrderInsert(3);
        sampleTree.levelOrderInsert(4);
        sampleTree.levelOrderInsert(5);
        sampleTree.levelOrderInsert(9);
        sampleTree.levelOrderInsert(7);
        sampleTree.printLevelOrder();
        sampleTree.clearTree();
    }
}
