package demo2.loggers;

import demo2.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger extends AbstractLogger {
    private String filename;
    protected File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void init() throws IOException {
        file = new File(filename);

        if(file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("can't write to file " + file.getAbsolutePath());
        } else if (!file.exists()){
            try {
                file.createNewFile();
            } catch (Exception e) {
                throw new IllegalArgumentException("can't create file " + file.getAbsolutePath(), e);
            }
        }
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
