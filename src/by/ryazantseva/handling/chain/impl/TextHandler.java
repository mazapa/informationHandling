package by.ryazantseva.handling.chain.impl;

import by.ryazantseva.handling.chain.DataHandler;
import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.composite.impl.TextComposite;
import by.ryazantseva.handling.exception.InvalidInputDataException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler implements DataHandler {
    private static final String PATTERN_PARAGRAPH = "\\s{4}(.|!|\\?)+";
    private ParagraphHandler paragraphHandler = new ParagraphHandler();

    @Override
    public TextComposite handleRequest(String text) throws InvalidInputDataException {
        if(text.isEmpty()){
            throw new InvalidInputDataException("String is empty");
        }
        TextComposite textComposite = new TextComposite(TextPartType.TEXT);
        Pattern pattern = Pattern.compile(PATTERN_PARAGRAPH);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            textComposite.add(paragraphHandler.handleRequest(text.substring(matcher.start(), matcher.end())));
        }
        return textComposite;
    }
    }
