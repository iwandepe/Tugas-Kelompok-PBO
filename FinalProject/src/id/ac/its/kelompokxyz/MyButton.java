package id.ac.its.kelompokxyz;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyButton extends JPanel {
	private static final long serialVersionUID = 1L;
	JPanel btn;
	JLabel label;
	String name = "";
    public MyButton(String name) {
    	this.name = name;
        initComponents();
    }
    
    private void initComponents() {
        label = new javax.swing.JLabel();

        this.setBackground(new java.awt.Color(41, 54, 63));
        this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setPreferredSize(new java.awt.Dimension(150, 46));
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMouseReleased(evt);
            }
        });

        label.setFont(new java.awt.Font("Century Gothic", 1, 14));
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText(name);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelMouseEntered(evt);
            }
            public void mouseClicked(MouseEvent evt) {
            	btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnLayout = new javax.swing.GroupLayout(this);
        this.setLayout(btnLayout);
        
        btnLayout.setHorizontalGroup(
            btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
            .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(label)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnLayout.setVerticalGroup(
            btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
            .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(label)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        
    }

    private void btnMouseEntered(java.awt.event.MouseEvent evt) {
        this.setBackground(new Color(28, 41, 50));
        this.setForeground(new Color(97, 204, 148));
        label.setForeground(new Color(97, 204, 148));
        this.setBorder(BorderFactory.createBevelBorder(1, new Color(97, 204, 148), new Color(97, 204, 148), new Color(97, 204, 148), new Color(97, 204, 148)));

    }

    private void labelMouseEntered(java.awt.event.MouseEvent evt) {
    	btnMouseEntered(evt);
    }

    private void btnMouseExited(java.awt.event.MouseEvent evt) {
        this.setBackground(new Color(41, 54, 63));
        label.setForeground(Color.WHITE);
        this.setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));

    }

    private void btnMousePressed(java.awt.event.MouseEvent evt) {
        this.setBackground(new Color(16, 29, 38));
    }

    private void btnMouseReleased(java.awt.event.MouseEvent evt) {
        this.setBackground(new Color(41, 54, 63));
    }

    public void btnMouseClicked(java.awt.event.MouseEvent evt) {
    	
    }

}

