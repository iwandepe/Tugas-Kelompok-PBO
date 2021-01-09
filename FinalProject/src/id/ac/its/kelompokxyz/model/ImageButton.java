package id.ac.its.kelompokxyz.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import id.ac.its.kelompokxyz.util.Commons;

public class ImageButton extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel label;
	String name = "";
	private BufferedImage image;
	
	public ImageButton(String name) {
		this.name = name;
        initComponents();
        
        try {                
            image = ImageIO.read(new File("src/resources/"+ name.toLowerCase() +".png"));
         } catch (IOException ex) {
              System.out.println("Error opening image");
         }
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }
	
	private void initComponents() {
        label = new JLabel();
        
        
        setBorder(new EmptyBorder(30, 30, 30, 30));
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setPreferredSize(new java.awt.Dimension(Commons.WIDTH/4, Commons.HEIGHT/2));
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

        label.setFont(new java.awt.Font("Century Gothic", 1, 20));
        label.setForeground(new Color(99, 99, 99));
        label.setText(name);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMouseEntered(evt);
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
        label.setForeground(Color.white);
        this.setBorder(BorderFactory.createBevelBorder(1, new Color(97, 204, 148), new Color(97, 204, 148), new Color(97, 204, 148), new Color(97, 204, 148)));

    }

    private void btnMouseExited(java.awt.event.MouseEvent evt) {
        this.setBackground(new Color(41, 54, 63));
        label.setForeground(new Color(99, 99, 99));
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
