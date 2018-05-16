package org.buzztrax.jceff;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.panda_lang.pandomium.Pandomium;
import org.panda_lang.pandomium.settings.PandomiumSettings;
import org.panda_lang.pandomium.wrapper.PandomiumBrowser;
import org.panda_lang.pandomium.wrapper.PandomiumClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        PandomiumSettings settings = PandomiumSettings.getDefaultSettings();

        final Pandomium pandomium = new Pandomium(settings);
        pandomium.initialize();

        PandomiumClient client = pandomium.createClient();
        PandomiumBrowser browser = client.loadURL("https://panda-lang.org");

        final JFrame frame = new JFrame();
        frame.getContentPane().add(browser.toAWTComponent(), BorderLayout.CENTER);
        frame.pack();

        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                pandomium.dispose();
                frame.dispose();
            }
        });

        frame.setTitle("Pandomium");
        frame.setSize(1380, 760);
        frame.setVisible(true);
    }
}
