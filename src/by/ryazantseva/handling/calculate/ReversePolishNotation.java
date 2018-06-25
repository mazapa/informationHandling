package by.ryazantseva.handling.calculate;

import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class ReversePolishNotation {
    private static final int LOW_PRIORITY = 1;
    private static final int HIGH_PRIORITY = 2;
    private final String OPERATORS = "+-*/";
    private static int i = 7;
    private static int j = 15;

    private ArrayDeque<String> operations = new ArrayDeque<>();
    private ArrayDeque<String> result = new ArrayDeque<>();

    private boolean isNumber(String token) {
        try {
           Double.parseDouble(token);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    private boolean isOpenBracket(String token) {
        return "(".equals(token);
    }

    private boolean isCloseBracket(String token) {
        return ")".equals(token);
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private int getPrecedence(String token) {
        if ("+".equals(token) || "-".equals(token)) {
            return LOW_PRIORITY;
        }
        return HIGH_PRIORITY;
    }

    public Integer parse(String expression) {
        operations.clear();
        result.clear();
        String output = "";
        expression = expression.replace("(-", "(0-")
                .replace(",-", ",0-").replace("--j", "(j-1)")
                .replace("j--", "(j-1)").replace("j++", "(j+1)")
                .replace("++j", "(j+1)").replace("i++", "(i+1)")
                .replace("++i", "(i+1)").replace("--i", "(i-1)")
                .replace("i--", "(i-1)").replace("i", String.valueOf(i))
                .replace("j", String.valueOf(j));
        if (expression.charAt(0) == '-') {
            expression = "0" + expression;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(expression,
                OPERATORS + "()", true);

        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (isOpenBracket(token)) {
                operations.push(token);
            } else if (isCloseBracket(token)) {
                while (!operations.isEmpty()
                        && !isOpenBracket(operations.getFirst())) {
                    result.push(operations.pop());
                }
                operations.pop();
                if (!operations.isEmpty()) {
                    result.push(operations.pop());
                }
            } else if (isNumber(token)) {
                result.push(token);
            } else if (isOperator(token)) {
                while (!operations.isEmpty()
                        && isOperator(operations.getFirst())
                        && getPrecedence(token) <= getPrecedence(operations
                        .getFirst())) {
                    result.push(operations.pop());
                }
                operations.push(token);
            }
        }
        while (!operations.isEmpty()) {
            result.push(operations.pop());
        }
        for (int i = result.size(); i >=0 ; i--) {
            output += result.pollLast() + " ";
        }
        return new CalculateFormula().parse(output);
    }
}
