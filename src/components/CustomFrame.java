package components;

import java.awt.Color;

import javax.swing.JFrame;

public class CustomFrame extends JFrame{

  private void initialize(){
    
    setSize(800,500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(0xFBFBFB));
    setUndecorated(true);

    setVisible(true);
  }

  public CustomFrame(){
    super();
    initialize();
    
  }


}
