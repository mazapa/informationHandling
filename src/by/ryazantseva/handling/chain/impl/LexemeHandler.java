package by.ryazantseva.handling.chain.impl;

import by.ryazantseva.handling.chain.DataHandler;
import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.composite.impl.Symbol;
import by.ryazantseva.handling.composite.impl.TextComposite;
import by.ryazantseva.handling.exception.InvalidInputDataException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeHandler implements DataHandler {
    private static final String PATTERN_SYMBOL = "\\S";

    @Override
    public TextComposite handleRequest(String lexeme) throws InvalidInputDataException {
        TextComposite lexemeComposite = new TextComposite(TextPartType.LEXEME);
        Pattern p = Pattern.compile(PATTERN_SYMBOL);
        Matcher m = p.matcher(lexeme);
        while (m.find()) {
            Symbol symbol = new Symbol(lexeme.substring(m.start(), m.end()), TextPartType.SYMBOL);
            lexemeComposite.add(symbol);
        }
        return lexemeComposite;
    }
}
