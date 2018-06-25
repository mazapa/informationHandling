package by.ryazantseva.handling.interpreter;

import java.util.ArrayDeque;

public class Context {
    private ArrayDeque<Integer> contextValues = new ArrayDeque<>();
    public Integer pop() {
        return contextValues.pop();
    }
    public void push(Integer value) {
        this.contextValues.push(value);
    }
}
