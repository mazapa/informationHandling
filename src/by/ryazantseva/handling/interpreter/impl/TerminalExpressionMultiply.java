package by.ryazantseva.handling.interpreter.impl;

import by.ryazantseva.handling.interpreter.Context;
import by.ryazantseva.handling.interpreter.MathExpression;

public class TerminalExpressionMultiply extends MathExpression {
    @Override
    public void interpret(Context context) {
        context.push((context.pop() * context.pop()));

    }
}
