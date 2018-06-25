package by.ryazantseva.handling.composite;

import by.ryazantseva.handling.chain.TextPartType;

import java.util.List;

public interface TextComponent {

    void add(TextComponent c);
    int getChildrenSize();
    String toStringComponent();
    TextPartType getType();
    List<TextComponent> getChildren();
}
