package test.by.ryazantseva.handling.read;

import by.ryazantseva.handling.exception.DataFileReaderException;
import by.ryazantseva.handling.read.DataFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataFileReaderTest {

    @Test
    public void readDataPositiveTest() throws DataFileReaderException {
        DataFileReader dataFileReader = new DataFileReader();
        String expected = "    It has survived - not only (five) centuries, but also the leap into 13+i-- electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was popularised in the 5*(1*2*(3*(4*(5---j+4)-3)-2)-1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n" +
                "    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)-2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\r\n" +
                "    It is a (-5+1/2*(2+5*2---j))*1200 established fact that a reader will be of a page when looking at its layout.\r\n" +
                "    Bye.";
        String actual = dataFileReader.readFromFile("files/text.txt");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void readEmptyFileTest() throws DataFileReaderException {
        try {
            new DataFileReader().readFromFile("files/empty.txt");
            Assert.fail("File is empty");
        } catch (RuntimeException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void readNonexistentFileTest() throws DataFileReaderException {
        try {
            new DataFileReader().readFromFile("nonexistent.txt");
            Assert.fail("File is nonexistent");
        } catch (RuntimeException e) {
            Assert.assertTrue(true);

        }
    }


}

