package coba2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
  public Main() {
	  setExtendedState(MAXIMIZED_BOTH);
    JPanel parentPanel = new JPanel();
    parentPanel.setLayout(new BorderLayout(10, 10));

    JPanel childPanel1 = new JPanel();
    childPanel1.setBackground(Color.red);
    childPanel1.setPreferredSize(new Dimension(300, 40));

    JPanel childPanel2 = new JPanel();
    childPanel2.setBackground(Color.blue);
    childPanel2.setPreferredSize(new Dimension(800, 600));

    JButton myButton = new JButton("Add Component ");
    myButton.addActionListener(e -> {
      parentPanel.remove(childPanel1);
      parentPanel.add(childPanel2, BorderLayout.CENTER);
      parentPanel.revalidate();
      parentPanel.repaint();
      pack();
    });
    setLocation(10, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    parentPanel.add(childPanel1, BorderLayout.CENTER);
    parentPanel.add(myButton, BorderLayout.SOUTH);
    add(parentPanel);
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    new Main();
  }
}