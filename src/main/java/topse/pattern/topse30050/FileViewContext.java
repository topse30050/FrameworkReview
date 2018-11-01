package topse.pattern.topse30050;

import java.io.InputStream;

class FileViewContext {
    private FileGetStrategy reader;
    private FileViewStrategy viewer;

    InputStream read(String filePath) {
        return reader.read(filePath);
    }

    void show(InputStream input) {
        viewer.show(input);
    }


    void setReader(FileGetStrategy reader) {
        this.reader = reader;
    }

    void setViewer(FileViewStrategy viewer) {
        this.viewer = viewer;
    }
}
