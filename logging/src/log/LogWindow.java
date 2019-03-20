package log;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import org.apache.log4j.*;
import org.apache.log4j.spi.LoggingEvent;

public class LogWindow extends JInternalFrame
{
    
    private static TextArea m_logContent;

    public LogWindow() 
    {
        super("Начало логирования", true, true, true, true);
        m_logContent = new TextArea("");
        m_logContent.setSize(200, 500);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_logContent, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
        //updateLogContent("Start");
    }

    public static void updateLogContent(String log_string)
    {
        m_logContent.append(log_string + "\n");
        m_logContent.invalidate();
    }
    

}
