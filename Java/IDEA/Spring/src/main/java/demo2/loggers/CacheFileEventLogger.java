package demo2.loggers;

import demo2.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize = 1;
    private List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        cache.stream().forEach(super::logEvent);
//        try {
//            FileUtils.writeLines(file, cache, true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public void destroy()  {
        if ( !cache.isEmpty() ) {
            writeEventsFromCache();
        }
    }
}
