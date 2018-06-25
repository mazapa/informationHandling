package by.ryazantseva.handling.composite.impl;

import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.composite.TextComponent;
import by.ryazantseva.handling.exception.InvalidInputDataException;

import java.util.List;

public class Symbol implements TextComponent {
    private static final int ONE_SYMBOL = 1;
    private String symbol;
    private TextPartType type;

    public Symbol(String symbol, TextPartType type) throws InvalidInputDataException {
        if (symbol == null || symbol.length() != ONE_SYMBOL || type != TextPartType.SYMBOL) {
            throw new InvalidInputDataException();
        }
        this.type = type;
        this.symbol = symbol;
    }


    @Override
    public void add(TextComponent c) {

    }

    @Override
    public int getChildrenSize() {
        return 0;
    }

    @Override
    public String toStringComponent() {
        return symbol;
    }

    @Override
    public TextPartType getType() {
        return type;
    }

    @Override
    public List<TextComponent> getChildren() {
        return null;
    }

}
