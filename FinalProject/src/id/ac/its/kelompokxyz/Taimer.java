package id.ac.its.kelompokxyz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Taimer implements ActionListener{
 
 JFrame frame = new JFrame();
 JButton startButton = new JButton("START");
 JButton resetButton = new JButton("RESET");
 JLabel timeLabel = new JLabel();
 
 int elapsedTime = 0;
 int sec = 0;
 int min = 0;
 boolean started = false;
 
 public String sec_string = String.format("%02d", sec);
 public String min_string = String.format("%02d", min);
 
 Timer timer = new Timer(1000, new ActionListener() {
  
  public void actionPerformed(ActionEvent e) {
   
   elapsedTime = elapsedTime+1000;
   min = (elapsedTime/60000) % 60;
   sec = (elapsedTime/1000) % 60;
   sec_string = String.format("%02d", sec);
   min_string = String.format("%02d", min);
   timeLabel.setText(min_string+":"+sec_string);
  }
  
 });
 
 
 Taimer(){
  
  timeLabel.setText(min_string+":"+sec_string);
  timeLabel.setBounds(100,100,200,100);
//  timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
  timeLabel.setBorder(BorderFactory.createBevelBorder(1));
  timeLabel.setOpaque(true);
  timeLabel.setHorizontalAlignment(JTextField.CENTER);
  
  startButton.setBounds(100,200,100,50);
//  startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
  startButton.setFocusable(false);
  startButton.addActionListener(this);
  
  resetButton.setBounds(200,200,100,50);
//  resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
  resetButton.setFocusable(false);
  resetButton.addActionListener(this);
  
  frame.add(startButton);
  frame.add(resetButton);
  frame.add(timeLabel);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(420,420);
  frame.setLayout(null);
  frame.setVisible(true);
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(e.getSource()==startButton) {
   
   if(started==false) {
    started=true;
    startButton.setText("STOP");
    start();
   }
   else {
    started=false;
    startButton.setText("START");
    stop();
   }
   
  }
  if(e.getSource()==resetButton) {
   started=false;
   startButton.setText("START");
   reset();
  }
  
 }
 
 void start() {
  timer.start();
 }
 
 void stop() {
  timer.stop();
 }
 
 void reset() {
  timer.stop();
  elapsedTime=0;
  sec =0;
  min=0;
  sec_string = String.format("%02d", sec);
  min_string = String.format("%02d", min);
  timeLabel.setText(min_string+":"+sec_string);
 }
 
 public static void main(String[] args) {
	 new Taimer();
 }

}
