package trial;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class splash {

	public static void main(String[] args) {
		JWindow window = new JWindow();
		window.getContentPane().add(
		    new JLabel(new ImageIcon("src/resources/credmin.png")));
		window.setBounds(500, 150, 300, 200);
		window.setVisible(true);
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		JFrame frame = new JFrame();
		frame.add(new JLabel("Welcome"));
		frame.setVisible(true);
		frame.setSize(300,100);
		window.dispose();

	}

}
