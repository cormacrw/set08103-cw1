import com.napier.sem.data.TextFileReader;
import com.napier.sem.elements.ListItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class TextFileReaderTest {
    @Test
    public void test() {
        ArrayList<ListItem> listItems = TextFileReader.getListItems("/homeListItems.txt");

    }
}
