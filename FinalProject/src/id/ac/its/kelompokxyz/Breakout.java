package id.ac.its.kelompokxyz;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

public class Breakout extends JFrame {

	private static final long serialVersionUID = 1L;
    public Breakout() {
        
        initUI();
    }
    
    private void initUI() {
    	
    	setLayout(new BorderLayout(10,10));
    	    	
    	setLocation(100,200);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("BRICK");
    	setResizable(false);
    	add(new MainPanel());
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
