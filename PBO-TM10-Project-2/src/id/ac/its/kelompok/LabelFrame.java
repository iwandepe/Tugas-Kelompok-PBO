package id.ac.its.kelompok;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.*;


public class LabelFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private final JLabel label3;
	
	public LabelFrame(String nama, String nrp) {
		super("Display Biodata");
		setLayout(new FlowLayout());
		
		ImageIcon photo = new ImageIcon(getClass().getResource(nama+".jpg"));
		Image image = photo.getImage();
		Image resizedImage = image.getScaledInstance(400, 400,  java.awt.Image.SCALE_SMOOTH);
		photo = new ImageIcon(resizedImage);
		

		label3 = new JLabel();
		label3.setText("<html>Nama : " + nama + "<br/>" + "NRP : " + nrp + "</html>");
		label3.setIcon(photo);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText(nama);
		add(label3);
		
		
		
	}
	
	

}
