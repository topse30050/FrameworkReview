package topse.pattern.topse30050.tools;

import org.apache.http.client.fluent.Request;
import topse.pattern.topse30050.framework.FileGetStrategy;

import java.io.IOException;
import java.io.InputStream;

public class HttpGetter implements FileGetStrategy {
    @Override
    public InputStream read(String filePath) {
        InputStream fileAsString = null;

        try {
            fileAsString = Request.Get(filePath)
                    .connectTimeout(1000)
                    .socketTimeout(1000)
//                    .viaProxy(new HttpHost("", 0))
                    .execute()
                    .returnContent()
                    .asStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileAsString;
    }
}
