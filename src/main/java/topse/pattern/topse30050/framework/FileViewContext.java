package topse.pattern.topse30050.framework;

import java.io.InputStream;

public class FileViewContext {
    private FileGetStrategy reader;
    private FileViewStrategy viewer;

    public InputStream read(String filePath) {
        return reader.read(filePath);
    }

    public void show(InputStream input) {
        viewer.show(input);
    }


    public void setReader(FileGetStrategy reader) {
        this.reader = reader;
    }

    public void setViewer(FileViewStrategy viewer) {
        this.viewer = viewer;
    }
}
