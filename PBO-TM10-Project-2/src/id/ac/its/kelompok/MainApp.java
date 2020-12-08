package id.ac.its.kelompok;

import javax.swing.JFrame;

public class MainApp {

	public static void main(String[] args) {
		
		LabelFrame[] labelFrames = new LabelFrame[3];	
		
		labelFrames[0] = new LabelFrame("Mohammad Faderik", "05111940000023");
		labelFrames[0].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelFrames[0].setBounds(0, 0, 450, 500);
		labelFrames[0].setVisible(true);
		
		labelFrames[1] = new LabelFrame("Iwan Dwi Prakoso", "05111940000229");
		labelFrames[1].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelFrames[1].setBounds(450, 0, 450, 500);
		labelFrames[1].setVisible(true);
		
		labelFrames[2] = new LabelFrame("Dias Tri Kurniasari", "05111940000035");
		labelFrames[2].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelFrames[2].setBounds(900, 0, 450, 500);
		labelFrames[2].setVisible(true);
		
	}

}
