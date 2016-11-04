import java.util.Stack;

/**
 * Created by John on 11/4/16.
 */
public class DijkstrasTwoStack {

    public static double evaluate(String exp){
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            String s = Character.toString(exp.charAt(i));

            //Do nothing
            if(s.equals("("));
            else if(s.equals("+")) ops.push(s);
            else if(s.equals("-")) ops.push(s);
            else if(s.equals("*")) ops.push(s);
            else if(s.equals("/")) ops.push(s);
            else if(s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if(op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }
        return(vals.pop());
    }

}
