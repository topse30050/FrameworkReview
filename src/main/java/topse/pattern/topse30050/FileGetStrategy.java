package topse.pattern.topse30050;

import java.io.InputStream;

public interface FileGetStrategy {
    InputStream read(String filePath);
}
