/**
 * Created by jhunter on 2/27/17.
 */
public class AST {



    public float evaluate(ASTNode node){
        if (node.value != null){
            return node.value;
        }

        if (node.operation.equals("+")){
            return evaluate(node.leftNode) + evaluate(node.rightNode);
        }

        if (node.operation.equals("-")){
            return evaluate(node.leftNode) - evaluate(node.rightNode);
        }

        if (node.operation.equals("/")){
            return evaluate(node.leftNode) / evaluate(node.rightNode);
        }

        if (node.operation.equals("*")){
            return evaluate(node.leftNode) * evaluate(node.rightNode);
        }

        return 0.0f;
    }

    public static void main(String[] args) {
        // 5 + 25 * 3
        ASTNode node5 = new ASTNode(null, null, null, 5.0f);
        ASTNode node3 = new ASTNode(null, null, null, 3.0f);
        ASTNode node25 = new ASTNode(null, null, null, 25.0f);
        ASTNode multiplyNode = new ASTNode("*", node25, node3, null);
        ASTNode plusNode = new ASTNode("+", multiplyNode, node5, null);

        AST tree = new AST();
        System.out.println(tree.evaluate(plusNode));
    }

}
