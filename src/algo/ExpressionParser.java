package algo;

//TODO finish parser logic
public class ExpressionParser {
// |
// |-

    public static double parse(String expr){
        if(expr.startsWith("(") && expr.endsWith(")")){
            int st = expr.indexOf('(') + 1;
            int end = expr.lastIndexOf(')');
            String eval = expr.substring(st, end);

            int i = 0;
            for(; i < eval.length() && Character.isDigit(eval.charAt(i)); i++){}
            int num = Integer.parseInt(eval.substring(0, i));

            if(i >= eval.length()){
                return num;
            }

            char oper = eval.charAt(i);

            if(oper == '+') {
                return num + parse(eval.substring(i+1, eval.length()));
            } else if(oper == '-'){
                return num - parse(eval.substring(i+1, eval.length()));
            } else if(oper == '*') {
                return num * parse(eval.substring(i+1, eval.length()));
            } else if(oper == '/'){
                return num / parse(eval.substring(i+1, eval.length()));
            }

            return num;

        } else {
            return Integer.parseInt(expr);
        }



    }


    public static void main(String[] args) {
        double res = parse("(11+(16/(6+(4-2))))");
        System.out.println(res);
    }



}
