package by.ryazantseva.handling.interpreter.impl;

import by.ryazantseva.handling.interpreter.Context;
import by.ryazantseva.handling.interpreter.MathExpression;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TerminalExpressionDivide extends MathExpression {
    private static Logger logger = LogManager.getLogger();
    @Override
    public void interpret(Context context) {
        int x = context.pop();
        int y = context.pop();
        try{
            context.push((y / x));
        }catch (ArithmeticException e){
            logger.log(Level.ERROR, "Divide by zero!");
        }
    }
}
