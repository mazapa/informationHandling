package test.by.ryazantseva.handling.action;

import by.ryazantseva.handling.action.SortSentences;
import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.chain.impl.TextHandler;
import by.ryazantseva.handling.composite.TextComponent;
import by.ryazantseva.handling.composite.impl.TextComposite;
import by.ryazantseva.handling.exception.DataFileReaderException;
import by.ryazantseva.handling.exception.InvalidInputDataException;
import by.ryazantseva.handling.read.DataFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SortSentencesTest {
    @Test
    public void sortSentencesLexemePositiveTest() throws DataFileReaderException, InvalidInputDataException {
        List<String> expected = new ArrayList<>();
        expected.add("Bye.  ");
        expected.add("It is a -6000 established fact that a reader will be of a page when looking at its layout. ");
        expected.add("It has survived - not only (five) centuries, but also the leap into 19 electronic typesetting, remaining 8 essentially -3 unchanged.");
        expected.add("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.  ");
        expected.add("The point of using 224 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English. ");
        expected.add("It was popularised in the -715 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. ");

        DataFileReader dataFileReader = new DataFileReader();
        String text = dataFileReader.readFromFile("files/text.txt");
        TextHandler textHandler = new TextHandler();
        TextComposite composite = textHandler.handleRequest(text);
        SortSentences sortSentences = new SortSentences();
        List<TextComponent> sortList = sortSentences.sort(composite, TextPartType.LEXEME);
        List<String> actual = new ArrayList<>();
        for (TextComponent component : sortList) {
            actual.add(component.toStringComponent());
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sortSentencesWordPositiveTest() throws DataFileReaderException, InvalidInputDataException {
        List<String> expected = new ArrayList<>();
        expected.add("Bye.  ");
        expected.add("It has survived - not only (five) centuries, but also the leap into 19 electronic typesetting, remaining 8 essentially -3 unchanged.  ");
        expected.add("It is a -6000 established fact that a reader will be of a page when looking at its layout.");
        expected.add("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ");
        expected.add("The point of using 224 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.  ");
        expected.add("It was popularised in the -715 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. ");

        DataFileReader dataFileReader = new DataFileReader();
        String text = dataFileReader.readFromFile("files/text.txt");
        TextHandler textHandler = new TextHandler();
        TextComposite composite = textHandler.handleRequest(text);
        SortSentences sortSentences = new SortSentences();
        List<TextComponent> sortList = sortSentences.sort(composite, TextPartType.WORD);
        List<String> actual = new ArrayList<>();
        for (TextComponent component : sortList) {
            actual.add(component.toStringComponent());
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sortSentencesIsNotTextNegativeTest() {
        try {
            SortSentences sortSentences = new SortSentences();
            TextComposite textComposite = new TextComposite(TextPartType.LEXEME);
            sortSentences.sort(textComposite, TextPartType.WORD);
            Assert.fail("Composite is not text");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void sortSentencesIsEmptyNegativeTest() {
        try {
            SortSentences sortSentences = new SortSentences();
            TextComposite textComposite = new TextComposite(TextPartType.TEXT);
            sortSentences.sort(textComposite,TextPartType.WORD);
            Assert.fail("Composite is empty");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);
        }
    }
}
