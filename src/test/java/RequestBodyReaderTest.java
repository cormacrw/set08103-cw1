import com.napier.sem.data.RequestBodyReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

public class RequestBodyReaderTest {

    @Test
    public void test() {
        String testBody = "firstParam=1&secondParam=test&thirdParam=true";

        InputStream inputStream = new ByteArrayInputStream( testBody.getBytes() );

        RequestBodyReader requestBodyReader = new RequestBodyReader(inputStream);
        Map<String, Object> params = requestBodyReader.getBodyParams();

        assertTrue(params.containsKey("firstparam"));
        assertEquals(params.get("firstparam"), 1);

        assertTrue(params.containsKey("secondparam"));

        assertTrue(params.containsKey("thirdparam"));
    }
}
