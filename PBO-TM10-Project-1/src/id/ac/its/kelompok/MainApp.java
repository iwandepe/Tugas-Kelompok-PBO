package id.ac.its.kelompok;

import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
				
		Shape[] shapes = new Shape[3];
		
		// Input Shape Type
		Object[] possibleShape = {"Circle", "Rectangle", "Triangle"};
		Object selectedShape = JOptionPane.showInputDialog(null,
				"Choose Your Shape", "Type of Shape",
				JOptionPane.QUESTION_MESSAGE, null,
				possibleShape, possibleShape[0]);
		
		// Check The Shape Type and do the class program
		if(selectedShape == possibleShape[0]) {
			String inpRadius = JOptionPane.showInputDialog("Enter radius : ");
			shapes[0] = new Circle(Integer.parseInt(inpRadius));
			
			JOptionPane.showMessageDialog(null, "The Area of Circle = " + shapes[0].getArea() + "\nThe Around of Circle = " + shapes[0].getAround(),
					"The Area of Shape", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(selectedShape == possibleShape[1]) {
			String inpWidth = JOptionPane.showInputDialog("Enter Width : ");
			String inpHeigth = JOptionPane.showInputDialog("Enter Heigth : ");
			shapes[1] = new Rectangle(Integer.parseInt(inpHeigth), Integer.parseInt(inpWidth));
			
			JOptionPane.showMessageDialog(null, "The Area of Circle = " + shapes[1].getArea() + "\nThe Around of Circle = " + shapes[1].getAround(),
					"The Area of Shape", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(selectedShape == possibleShape[2]) {
			String inpA = JOptionPane.showInputDialog("Enter A side : ");
			String inpB = JOptionPane.showInputDialog("Enter B side : ");
			String inpC = JOptionPane.showInputDialog("Enter C side : ");
			shapes[2] = new Triangle(Integer.parseInt(inpA), Integer.parseInt(inpB), Integer.parseInt(inpC));
			
			JOptionPane.showMessageDialog(null, "The Area of Circle = " + shapes[2].getArea() + "\nThe Around of Circle = " + shapes[2].getAround(),
					"The Area of Shape", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Something went wrong !",
					"Error !", JOptionPane.ERROR_MESSAGE);
		}
	}
}
