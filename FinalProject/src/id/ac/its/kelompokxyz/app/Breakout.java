package id.ac.its.kelompokxyz.app;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

public class Breakout extends JFrame {

	private static final long serialVersionUID = 1L;
    public Breakout() {
        initUI();
    }
    
    private void initUI() {
    	
    	setLayout(new BorderLayout(10,10));
    	setLocation(10,10);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("JaBrick Java Game");
    	setResizable(false);
    	setContentPane(new MainPanel((JFrame)this));
    	pack();
    	
    }
    
    public void closeUI() {
    	dispose();
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {

            var game = new Breakout();
            game.setVisible(true);
        });
    }


}
