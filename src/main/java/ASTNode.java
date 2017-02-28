/**
 * Created by jhunter on 2/27/17.
 */
public class ASTNode{
    public String operation;
    public ASTNode leftNode;
    public ASTNode rightNode;
    public Float value;

    public ASTNode(String operation, ASTNode leftNode, ASTNode rightNode, Float value) {
        this.operation = operation;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }
}