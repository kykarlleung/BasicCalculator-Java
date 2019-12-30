import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import java.util.*;
 

class main_Key{
	
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static int x0 = (int)(screenSize.getWidth()/2);	//Center X coordinate of screen 
	private static int y0 = (int)(screenSize.getHeight()/2); //Center Y coordinate of screen
	
  public static void main(String[] args) {
      JavaCalculator_Key calc = new JavaCalculator_Key();
      calc.pack();
      calc.setMinimumSize(new Dimension(calc.getWidth(),calc.getHeight()));	//Prevents user from compromising the spacing of the JFrame
      calc.setLocation(  x0-calc.getWidth(),  y0-calc.getHeight());	//Centers the GUI in the center of the screen regardless of computer/device. by Daniel
      calc.setLocationRelativeTo(null);
              calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      calc.setVisible(true);
  }


}






