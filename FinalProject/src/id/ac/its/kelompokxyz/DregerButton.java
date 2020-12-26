package id.ac.its.kelompokxyz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

// DregerButton.java
// Copyright Kyle Dreger 2012
// To make JButtons suck less
// https://gist.github.com/4646029

public class DregerButton extends JButton implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	Font defaultFont = new Font("Gill Sans MT",Font.BOLD,14);
    Color textColor = Color.decode("#ffffff");
    Color backgroundColor = new Color(1f,0f,0f,.0f );
    Color hoverColor = new Color(1f,0f,0f,.0f );
    
    public DregerButton(String s) {
        s = s.toUpperCase();
        this.setFocusPainted(false);
        this.setText(s);
        this.setBorder(null);
        this.setForeground(textColor);
        this.setBackground(backgroundColor);
        this.setFont(defaultFont);
        this.setOpaque(true);
        addMouseListener(this);
    }
    public DregerButton(String s, Color backgroundColor, Color hoverColor) {
        s = s.toUpperCase();
        this.setFocusPainted(false);
        this.setText(s);
        this.setBorder(null);
        this.setHoverColor(hoverColor);
        this.setBackground(backgroundColor);
        this.setFont(defaultFont);
        this.setOpaque(true);
        addMouseListener(this);
    }
    
    public void setBackgroundColor(Color color) {
        backgroundColor = color; 
    }
    public void setHoverColor(Color colorSubmitted) {
        hoverColor = colorSubmitted; 
    }

    @Override public void mouseClicked(MouseEvent me) {}
    @Override public void mouseReleased(MouseEvent me) {}
    @Override public void mousePressed(MouseEvent me) {}
    
    @Override
    public void mouseEntered(MouseEvent e) { 
        if (e.getSource()==this) {  
            this.setBackground(this.hoverColor); 
        }
    }
    @Override
    public void mouseExited(MouseEvent e) { 
        if (e.getSource()==this) { 
            this.setBackground(this.backgroundColor); 
        }
    }
}