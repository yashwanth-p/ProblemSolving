package DSA.Trees;

public class SyntaxTree {
    private ExpressionNode root;

    public void evaluateExpression() {
        System.out.println("\nValue of evaluated expression: "+evaluateExpressionHelper(root));
    }

    private int evaluateExpressionHelper(ExpressionNode current) {
        if (current != null) {
            if (current.symbol instanceof Integer) {
                return (int) current.symbol;
            }
            int left = evaluateExpressionHelper(current.left);
            int right = evaluateExpressionHelper(current.right);
            return solve(left, right, current.symbol);
        }
        return -1;
    }

    private int solve(int left, int right, Object symbol) {
        if (symbol instanceof Character) {
            switch ((char) symbol) {
                case '+':
                    return left + right;
                case '-':
                    return left - right;
                case '*':
                    return left * right;
                case '/':
                    return left / right;
                default:
                    return 0;
            }
        }
        return 0;
    }

    void buildTree() {
        root = new ExpressionNode('+');
        root.left = new ExpressionNode('*');
        root.left.left = new ExpressionNode(5);
        root.left.right = new ExpressionNode(4);
        root.right = new ExpressionNode('-');
        root.right.left = new ExpressionNode(100);
        root.right.right = new ExpressionNode('/');
        root.right.right.left = new ExpressionNode(20);
        root.right.right.right = new ExpressionNode(2);

    }

    static class ExpressionNode {
        ExpressionNode left;
        ExpressionNode right;
        Object symbol;

        ExpressionNode(Object symbol) {
            this.symbol = symbol;
        }
    }
}
