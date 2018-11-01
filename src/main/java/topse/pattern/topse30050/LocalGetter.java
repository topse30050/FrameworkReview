package topse.pattern.topse30050;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class LocalGetter implements FileGetStrategy {
    @Override
    public InputStream read(String filePath) {
        InputStream fileAsString = null;

        try {
            fileAsString = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileAsString;
    }
}
