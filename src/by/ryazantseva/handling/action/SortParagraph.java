package by.ryazantseva.handling.action;

import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.composite.impl.TextComposite;
import by.ryazantseva.handling.exception.InvalidInputDataException;
import java.util.Comparator;

public class SortParagraph {

    public TextComposite sort(TextComposite composite) throws InvalidInputDataException {
        if (composite == null || composite.getType() != TextPartType.TEXT ||composite.getChildren().isEmpty()) {
            throw new InvalidInputDataException("Incorrect input data");
        }
        composite.getChildren().sort(Comparator.comparingInt(part -> part.getChildrenSize()));
        return composite;
    }

}
