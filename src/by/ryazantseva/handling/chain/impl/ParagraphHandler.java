package by.ryazantseva.handling.chain.impl;

import by.ryazantseva.handling.chain.DataHandler;
import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.composite.impl.TextComposite;
import by.ryazantseva.handling.exception.InvalidInputDataException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler implements DataHandler {
    private static final String PATTERN_SENTENCE = "\\s+[^.?!]*[.?!]";
    private SentenceHandler sentenceHandler = new SentenceHandler();

    @Override
    public TextComposite handleRequest(String paragraph) throws InvalidInputDataException {
        TextComposite paragraphComposite = new TextComposite(TextPartType.PARAGRAPH);
        Pattern pattern = Pattern.compile(PATTERN_SENTENCE);
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()) {
            paragraphComposite.add(sentenceHandler.handleRequest(paragraph.substring(matcher.start(), matcher.end())));
        }
        return paragraphComposite;
    }
}
