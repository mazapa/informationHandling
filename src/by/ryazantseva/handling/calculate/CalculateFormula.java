package by.ryazantseva.handling.calculate;

import by.ryazantseva.handling.interpreter.*;
import by.ryazantseva.handling.interpreter.impl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CalculateFormula {
    private final String OPERATORS = "+-*/";
    private final String SEPARATOR = " ";
    private List<MathExpression> expressionList;

    public CalculateFormula() {
        expressionList = new ArrayList<>();
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }


    public Integer parse(String expression) {
        StringTokenizer stringTokenizer = new StringTokenizer(expression,
                OPERATORS + SEPARATOR, true);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (isNumber(token)) {
                expressionList.add(new NotTerminalExpression(Integer.parseInt(token)));
            } else if (isOperator(token)) {
                switch (token) {
                    case "+":
                        expressionList.add(new TerminalExpressionPlus());
                        break;
                    case "-":
                        expressionList.add(new TerminalExpressionMinus());
                        break;
                    case "/":
                        expressionList.add(new TerminalExpressionDivide());
                        break;
                    case "*":
                        expressionList.add(new TerminalExpressionMultiply());
                        break;
                }

            }
        }
        return calculate();
    }

    private Integer calculate() {
        Context context = new Context();
        for (MathExpression expression : expressionList) {
            expression.interpret(context);
        }
        return context.pop();
    }
}

