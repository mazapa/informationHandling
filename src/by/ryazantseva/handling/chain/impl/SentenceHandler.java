package by.ryazantseva.handling.chain.impl;

import by.ryazantseva.handling.calculate.ReversePolishNotation;
import by.ryazantseva.handling.chain.DataHandler;
import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.composite.impl.TextComposite;
import by.ryazantseva.handling.exception.InvalidInputDataException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler implements DataHandler {
    private static final String PATTERN_WORD = "[a-zA-Z]+";
    private static final String PATTERN_LEXEME = "\\s[^\\s]+[,.!?-]*";
    private static final String PATTERN_FORMULA = "(\\d(\\+|\\-|\\*|\\/))|((\\+{2}|\\-{2})[a-z])|([a-z](\\+{2}|\\-{2}))";
    private LexemeHandler lexemeHandler = new LexemeHandler();
    private WordHandler wordHandler = new WordHandler();

    @Override
    public TextComposite handleRequest(String sentence) throws InvalidInputDataException {
        TextComposite sentenceComposite = new TextComposite(TextPartType.SENTENCE);
        Pattern patternLexeme = Pattern.compile(PATTERN_LEXEME);
        Matcher matcherLexeme = patternLexeme.matcher(sentence);
        while (matcherLexeme.find()) {
            String lexeme = sentence.substring(matcherLexeme.start(), matcherLexeme.end());
            if (isFormula(lexeme)) {
                System.out.println(lexeme);
                ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
                lexeme = String.valueOf(reversePolishNotation.parse(lexeme));

            }
            Pattern patternWord = Pattern.compile(PATTERN_WORD);
            Matcher matcherWord = patternWord.matcher(lexeme);
            if (matcherWord.find()) {
                sentenceComposite.add(wordHandler.handleRequest(lexeme.substring(matcherWord.start(), matcherWord.end())));
            }
            sentenceComposite.add(lexemeHandler.handleRequest(lexeme));
        }
        return sentenceComposite;
    }

    private boolean isFormula(String lexeme) {
        Pattern pattern = Pattern.compile(PATTERN_FORMULA);
        Matcher matcher = pattern.matcher(lexeme);
        return matcher.find();
    }
}
