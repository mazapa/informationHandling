package by.ryazantseva.handling.composite.impl;

import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.composite.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private TextPartType type;
    private List<TextComponent> children;

    public TextComposite(TextPartType type) {
        this.type = type;
        children = new ArrayList<>();
    }

    @Override
    public String toStringComponent() {
        if(isType(TextPartType.WORD)){
            return "";
        }
        String result = "";
        if (isType(TextPartType.PARAGRAPH)) {
            result += "    ";
        }
        for (TextComponent component : children) {
            result += component.toStringComponent();
        }
        if (isType(TextPartType.PARAGRAPH)) {
            return result += "\n";
        }
        return result + " ";
    }


    @Override
    public TextPartType getType() {
        return type;
    }

    private boolean isType(TextPartType type) {
        return this.type == type;
    }

    @Override
    public void add(TextComponent c) {
        children.add(c);
    }

    @Override
    public int getChildrenSize() {
        return children.size();
    }

    public List<TextComponent> getChildren() {
        return children;
    }

}
