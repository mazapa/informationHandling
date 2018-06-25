package by.ryazantseva.handling.chain.impl;
import by.ryazantseva.handling.chain.DataHandler;
import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.composite.impl.Symbol;
import by.ryazantseva.handling.composite.impl.TextComposite;
import by.ryazantseva.handling.exception.InvalidInputDataException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler implements DataHandler {

    private static final String PATTERN_SYMBOL = "\\S";
    @Override
    public TextComposite handleRequest(String word) throws InvalidInputDataException {
        TextComposite wordComposite = new TextComposite(TextPartType.WORD);
        Pattern p = Pattern.compile(PATTERN_SYMBOL);
        Matcher m = p.matcher(word);
        while (m.find()) {
            Symbol symbol = new Symbol(word.substring(m.start(), m.end()),TextPartType.SYMBOL);
            wordComposite.add(symbol);
        }
        return wordComposite;
    }

}
