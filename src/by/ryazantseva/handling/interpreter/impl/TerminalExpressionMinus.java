package by.ryazantseva.handling.interpreter.impl;

import by.ryazantseva.handling.interpreter.Context;
import by.ryazantseva.handling.interpreter.MathExpression;

public class TerminalExpressionMinus extends MathExpression {
    @Override
    public void interpret(Context context) {
        int x = context.pop();
        int y = context.pop();
        context.push((y - x));

    }
}
