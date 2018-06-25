package by.ryazantseva.handling.interpreter.impl;

import by.ryazantseva.handling.interpreter.Context;
import by.ryazantseva.handling.interpreter.MathExpression;

public class NotTerminalExpression extends MathExpression {
    private  int number;

    public NotTerminalExpression(int number){
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.push(number);
    }
}
