package annotations.loggers;

import annotations.beans.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class FileEventLogger implements EventLogger {

    private File file;

    @Value("${events.file:target/events_log.txt}")
    private String filename;

    public FileEventLogger(){
    }

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    @PostConstruct
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

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
