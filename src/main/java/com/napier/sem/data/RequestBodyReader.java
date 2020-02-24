package com.napier.sem.data;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class RequestBodyReader {
    InputStream requestBodyStream;

    public RequestBodyReader(InputStream stream) {
        requestBodyStream = stream;
    }

    public HashMap<String, Object> getBodyParams() {
        Scanner s = new Scanner(requestBodyStream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";

        HashMap<String, Object> bodyParams = new HashMap<>();
        String[] params = result.split("&");

        for(int i = 0; i < params.length; i++) {
            String[] keyVal = params[i].split("=");

            try {
                int val = Integer.parseInt(keyVal[1]);
                bodyParams.put(keyVal[0].toLowerCase(), val);
            } catch( Exception e ) {
                bodyParams.put(keyVal[0].toLowerCase(), keyVal[1].replace("+", " "));
            }
        }
        return bodyParams;
    }
}
