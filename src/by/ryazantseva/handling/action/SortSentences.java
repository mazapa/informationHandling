package by.ryazantseva.handling.action;

import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.composite.TextComponent;
import by.ryazantseva.handling.composite.impl.TextComposite;
import by.ryazantseva.handling.exception.InvalidInputDataException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortSentences {

    public List<TextComponent> sort(TextComposite composite, TextPartType type) throws InvalidInputDataException {
        if (composite == null || composite.getType() != TextPartType.TEXT || composite.getChildren().isEmpty()) {
            throw new InvalidInputDataException("Incorrect input data");
        }
        List<TextComponent> sortSentences = new ArrayList<>();
        for (TextComponent paragraph : composite.getChildren()) {
            if (paragraph.getType() == TextPartType.PARAGRAPH) {
                for (TextComponent sentence : paragraph.getChildren()) {
                    sortSentences.add(sentence);
                }
            }
        }
        sortSentences.sort(Comparator.comparingInt(part -> findLength(part, type)));
        return sortSentences;
    }

    private int findLength(TextComponent sentence, TextPartType type) {
        int length = 0;
        for (TextComponent lexeme : sentence.getChildren()) {
            if (lexeme.getType() == type) {
                length++;
            }
        }
        return length;
    }

}
