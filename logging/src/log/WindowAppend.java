package log;


import org.apache.log4j.*;
import org.apache.log4j.spi.LoggingEvent;

public /*static*/ class WindowAppend extends AppenderSkeleton {
   

    @Override
    protected void append(LoggingEvent event) {
        System.out.println(event.getMessage());
        LogWindow.updateLogContent
        (
        		event.getLevel() + "    "
                + event.getRenderedMessage() + "    "
        		+ event.getLoggerName()
        		+ event.getThrowableInformation()
        );   
    }
 
    public void close() {
    }

    public boolean requiresLayout() {
        return false;
    }

}
