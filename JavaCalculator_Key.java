import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;


public class JavaCalculator_Key extends JFrame {

  private JButton jbtNum1;
  private JButton jbtNum2;
  private JButton jbtNum3;
  private JButton jbtNum4;
  private JButton jbtNum5;
  private JButton jbtNum6;
  private JButton jbtNum7;
  private JButton jbtNum8;
  private JButton jbtNum9;
  private JButton jbtNum0;
  private JButton jbtAdd;
  private JButton jbtSubtract;
  private JButton jbtMultiply;
  private JButton jbtDivide;
  private JButton jbtSolve;
  private JButton jbtClear;
  private JButton jbtAllClear;
  private JButton jbtPlusMinus;
  private JButton jbtDelete;
  private JButton jbtDecimal;
  private double TEMP;
  private double SolveTEMP;
  private JTextField jtfResult;
  private KeyEvent e;

  Boolean addBool = false;
  Boolean subBool = false;
  Boolean divBool = false;
  Boolean mulBool = false;
  Boolean resultant = false;

  String display = "";

  public JavaCalculator_Key() {
	super ("JavaCalculator");
	
    JPanel p1 = new JPanel();

    p1.setPreferredSize(new Dimension(600, 600));
    p1.setLayout(new GridLayout(5, 4));
    
    //Create Top row of buttons and change their font size
    jbtAllClear = new JButton("A/C");
    jbtAllClear.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    p1.add(jbtAllClear);
    
    jbtClear = new JButton("C");
    jbtClear.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    p1.add(jbtClear);
    
    jbtPlusMinus = new JButton("+/-");
    jbtPlusMinus.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    p1.add(jbtPlusMinus);
    
    jbtDivide = new JButton("/");
    jbtDivide.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    p1.add(jbtDivide);
	
    //Create number buttons and the operator buttons
    jbtNum1 = new JButton("1");
    jbtNum2 = new JButton("2");
    jbtNum3 = new JButton("3");
    jbtNum4 = new JButton("4");
    jbtNum5 = new JButton("5");
    jbtNum6 = new JButton("6");
    jbtNum7 = new JButton("7");
    jbtNum8 = new JButton("8");
    jbtNum9 = new JButton("9");
    jbtNum0 = new JButton("0");
    
    jbtMultiply = new JButton("*");
    jbtSubtract = new JButton("-");
    jbtAdd = new JButton("+");
    jbtDecimal = new JButton(".");
    jbtDelete = new JButton("DEL");
    jbtSolve = new JButton("=");
    
    //change the text size of those buttons
    jbtNum1.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtNum2.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtNum3.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtNum4.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtNum5.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtNum6.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtNum7.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtNum8.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtNum9.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtNum0.setFont(new Font("Times New Roman", Font.PLAIN, 40));
  
    jbtMultiply.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtSubtract.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtAdd.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtDecimal.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtDelete.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    jbtSolve.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    
    //Add those buttons to the Panel
    p1.add(jbtNum7);
    p1.add(jbtNum8);
    p1.add(jbtNum9);
    p1.add(jbtMultiply);

    p1.add(jbtNum4);
    p1.add(jbtNum5);
    p1.add(jbtNum6);
    p1.add(jbtSubtract);

    p1.add(jbtNum1);
    p1.add(jbtNum2);
    p1.add(jbtNum3);
    p1.add(jbtAdd);

    p1.add(jbtNum0);
    p1.add(jbtDecimal);
    p1.add(jbtDelete);
    p1.add(jbtSolve);
    
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout());
    jtfResult = new JTextField(20);
    jtfResult.setFont(new Font("Times New Roman", Font.PLAIN, 50 ));
    p2.add(jtfResult);
    jtfResult.setHorizontalAlignment(JTextField.RIGHT);
    jtfResult.setEditable(false);

    JPanel p = new JPanel(new BorderLayout());
    p.add(p2, BorderLayout.NORTH);
    p.add(p1, BorderLayout.SOUTH);

    add(p);

    jbtNum1.addActionListener(new ListenToOne());
    jbtNum2.addActionListener(new ListenToTwo());
    jbtNum3.addActionListener(new ListenToThree());
    jbtNum4.addActionListener(new ListenToFour());
    jbtNum5.addActionListener(new ListenToFive());
    jbtNum6.addActionListener(new ListenToSix());
    jbtNum7.addActionListener(new ListenToSeven());
    jbtNum8.addActionListener(new ListenToEight());
    jbtNum9.addActionListener(new ListenToNine());
    jbtNum0.addActionListener(new ListenToZero());

    jbtAdd.addActionListener(new ListenToAdd());
    jbtSubtract.addActionListener(new ListenToSubtract());
    jbtMultiply.addActionListener(new ListenToMultiply());
    jbtDivide.addActionListener(new ListenToDivide());
    jbtSolve.addActionListener(new ListenToSolve());
    jbtClear.addActionListener(new ListenToClear());
    jbtAllClear.addActionListener(new ListenToAllClear());
    jbtPlusMinus.addActionListener(new ListenToPlusMinus());
    jbtDelete.addActionListener(new ListenToDelete());
    jbtDecimal.addActionListener(new ListenToDecimal());
    jtfResult.setText("0");  
    
    
    //Ka: added key listener to improve the calculator
    //now we can input by keyboard instead of only pressing the button by mouse
    //create a keyPressd method
    //keyPressd method contains all the functions (same as the functions in actionListeners)
    //by clicking any button or textField in the panel
    //the computer will change the "focus" that button or text field
    //addKeyListener to all buttons/text fields to make 100% sure that user can type by keyboard 
    
    p.setFocusable(true);
    jbtAdd.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtSubtract.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtMultiply.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtDivide.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtSolve.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtClear.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtAllClear.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtPlusMinus.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtDelete.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtDecimal.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    
    jtfResult.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    
    jbtNum0.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    
    jbtNum1.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtNum2.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtNum3.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtNum4.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtNum5.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtNum6.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    
    jbtNum7.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtNum8.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtNum9.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
    jbtNum0.addKeyListener(new KeyAdapter()
    {
    	  public void keyPressed (KeyEvent e)
    	  {
    		  keyPressd(e);
    	  }
      });
	
    p.addKeyListener(new KeyAdapter()
    {
  	  public void keyPressed (KeyEvent e)
  	  {
  		  keyPressd(e);
  	  }
    });
  } //JavaCaluclator()
  
  class ListenToClear implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        display = jtfResult.getText();
    	if (display.equals("error")){
      	  jtfResult.setText("0");
        }	
    	else if(display.equals("")) {
    	}
    	else if(resultant) {
        	  jtfResult.setText("0");
              resultant = false;
    	}
    	else if(Double.parseDouble(display)!=0){
        jtfResult.setText("0");
      }
    }
  }

  class ListenToAllClear implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      jtfResult.setText("0");
      addBool = false;
      subBool = false;
      mulBool = false;
      divBool = false;
      resultant = false;

      TEMP = 0;
      SolveTEMP = 0;
    }
  }

  class ListenToPlusMinus implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();

      if (display.equals("error")){
    	  jtfResult.setText("0");
      }
      else if(display.equals("")) {
      }
      else if(Double.parseDouble(jtfResult.getText())==0){
      }
      else if(display.contains("-")){
        jtfResult.setText(display.substring(1));
        if (resultant) TEMP=Double.parseDouble(jtfResult.getText());
      }            
      else{
        jtfResult.setText("-"+display);
        if (resultant) TEMP=Double.parseDouble(jtfResult.getText());
      }
    }
  }

  class ListenToDelete implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();

      if(display.equals("0")||display.equals("")){
      }
      else if (display.length()==1||display.equals("error")||resultant){
    	  jtfResult.setText("0");
    	  resultant = false;
      }
      else{
        jtfResult.setText(display.substring(0,display.length()-1));
      }
    }
  }
  
  class ListenToDecimal implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("error")||display.equals("")||resultant){
        jtfResult.setText("0.");
        resultant = false;
      }
      else if(display.contains(".")){
      }
      else{
        jtfResult.setText(display+".");
      }
    }
  }

  class ListenToOne implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("0")||display.equals("error")||resultant) {
    	  jtfResult.setText("1");
    	  resultant = false;
      }
      else
      jtfResult.setText(display + "1");
    }
  }

  class ListenToTwo implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("0")||display.equals("error")||resultant) {
    	  jtfResult.setText("2");
    	  resultant = false;
      }
      else
      jtfResult.setText(display + "2");
    }
  }

  class ListenToThree implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("0")||display.equals("error")||resultant) {
    	  jtfResult.setText("3");
    	  resultant = false;
      }
      else
      jtfResult.setText(display + "3");
    }
  }

  class ListenToFour implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("0")||display.equals("error")||resultant) {
    	  jtfResult.setText("4");
    	  resultant = false;
      }
      else
      jtfResult.setText(display + "4");
    }
  }

  class ListenToFive implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("0")||display.equals("error")||resultant) {
    	  jtfResult.setText("5");
    	  resultant = false;
      }
      else
      jtfResult.setText(display + "5");
    }
  }

  class ListenToSix implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("0")||display.equals("error")||resultant) {
    	  jtfResult.setText("6");
    	  resultant = false;
      }
      else
      jtfResult.setText(display + "6");
    }
  }

  class ListenToSeven implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("0")||display.equals("error")||resultant) {
    	  jtfResult.setText("7");
    	  resultant = false;
      }
      else
      jtfResult.setText(display + "7");
    }
  }

  class ListenToEight implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("0")||display.equals("error")||resultant) {
    	  jtfResult.setText("8");
    	  resultant = false;
      }
      else
      jtfResult.setText(display + "8");
    }
  }

  class ListenToNine implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("0")||display.equals("error")||resultant) {
    	  jtfResult.setText("9");
    	  resultant = false;
      }
      else
      jtfResult.setText(display + "9");
    }
  }

  class ListenToZero implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if(display.equals("error")||resultant){
        jtfResult.setText("0");
  	  	resultant = false;
      }
      else if(display.equals("0")){
      }
      else{
        jtfResult.setText(display + "0");
      }
    }
  }

  class ListenToAdd implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if (display.equals("error")){
    	  TEMP = 0;
      }
      else if(display.equals("")) {}
      else if(resultant) resultant = false;
      else{
    	  TEMP = Double.parseDouble(display);
      }
      jtfResult.setText("");
      addBool = true;
      subBool = false;
      mulBool = false;
      divBool = false;
    }
  }

  class ListenToSubtract implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if (display.equals("error")){
    	  TEMP = 0;
      }
      else if(display.equals("")) {}
      else if(resultant) resultant = false;
      else {
    	  TEMP = Double.parseDouble(display);
      }
      jtfResult.setText("");
      addBool = false;
      subBool = true;
      mulBool = false;
      divBool = false;
    }

  }

  class ListenToMultiply implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if (display.equals("error")){
    	  TEMP = 0;
      }
      else if(display.equals("")) {}
      else if(resultant) resultant = false;
      else {
    	  TEMP = Double.parseDouble(display);
      }
      jtfResult.setText("");
      addBool = false;
      subBool = false;
      mulBool = true;
      divBool = false;
    }
  }

  class ListenToDivide implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      display = jtfResult.getText();
      if (display.equals("error")){
    	  TEMP = 0;
      }
      else if(display.equals("")) {}
      else if(resultant) resultant = false;
      else {
    	  TEMP = Double.parseDouble(display);
      }
      jtfResult.setText("");
      addBool = false;
      subBool = false;
      mulBool = false;
      divBool = true;
    }
  }

  class ListenToSolve implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        display = jtfResult.getText();
    	if(display.equals("")||resultant) {
    	}
    	else {
    		if(display.equals("error")){
		    	TEMP = 0;
		    }
    		else {
    			SolveTEMP = Double.parseDouble(display);
    		}

    		if(addBool == true){
    			SolveTEMP = TEMP + SolveTEMP;
    			TEMP = SolveTEMP;
    		}

    		else if (subBool == true){
    			SolveTEMP = TEMP - SolveTEMP;
    			TEMP = SolveTEMP;
    		}

    		else if (mulBool == true){
    			SolveTEMP = TEMP * SolveTEMP;
    			TEMP = SolveTEMP;
    		}
    		else if ((divBool == true) && (SolveTEMP==0)){
    			jtfResult.setText("error");
    			TEMP=0.0;
    		}
		    else if ((divBool == true) && (SolveTEMP!=0)){
		    	SolveTEMP = TEMP / SolveTEMP;
		    	TEMP = SolveTEMP;
		    }
		    		    
    		DecimalFormat format = new DecimalFormat("0.######");
    		
    		if  (jtfResult.getText().equals("error")){
    		}    				
    		else if (SolveTEMP == 0)
    			jtfResult.setText("0");
    		else if((Math.abs(SolveTEMP)>1e8) || (Math.abs(SolveTEMP)<1e-8)) {
		    	jtfResult.setText(String.format("%6.3e",SolveTEMP));
		    	/*Explanation about the String.format pattern
		    	 * % starts off pattern
		    	 * 6 for the minimum length of string to represent this expression
		    	 * . for the decimal point
		    	 * 3 for the number of decimals represented
		    	 * e for the scientific notation format using e instead of E
		    	 * */
		    }
		    else
		    	jtfResult.setText(format.format(SolveTEMP));
   		
		    addBool = false;
		    subBool = false;
		    mulBool = false;
		    divBool = false;
		    resultant = true;
		    SolveTEMP = 0.0;
		    }
    }
  }
  

  
  public void keyPressd(KeyEvent e)
  {
	  if(e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("0")||display.equals("error")||resultant) {
				  jtfResult.setText("1");
				  resultant = false;
			  }
			  else
				  jtfResult.setText(display + "1");
		  }
	  }
	  else if(e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("0")||display.equals("error")||resultant) {
				  jtfResult.setText("2");
				  resultant = false;
			  }
			  else
				  jtfResult.setText(display + "2");
		  }
	  }
	  else if(e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("0")||display.equals("error")||resultant) {
				  jtfResult.setText("3");
				  resultant = false;
			  }
			  else
				  jtfResult.setText(display + "3");
		  }
	  }
	  else if(e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("0")||display.equals("error")||resultant) {
				  jtfResult.setText("4");
				  resultant = false;
			  }
			  else
				  jtfResult.setText(display + "4");
		  }
	  }
	  else if(e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_NUMPAD5)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("0")||display.equals("error")||resultant) {
				  jtfResult.setText("5");
				  resultant = false;
			  }
			  else
				  jtfResult.setText(display + "5");
		  }
	  }
	  else if(e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_NUMPAD6)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("0")||display.equals("error")||resultant) {
				  jtfResult.setText("6");
				  resultant = false;
			  }
			  else
				  jtfResult.setText(display + "6");
		  }
	  }
	  else if(e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_NUMPAD7)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("0")||display.equals("error")||resultant) {
				  jtfResult.setText("7");
				  resultant = false;
			  }
			  else
				  jtfResult.setText(display + "7");
		  }
	  }
	  else if(e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_NUMPAD8)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("0")||display.equals("error")||resultant) {
				  jtfResult.setText("8");
				  resultant = false;
			  }
			  else
				  jtfResult.setText(display + "8");
		  }
	  }
	  else if(e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_NUMPAD9)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("0")||display.equals("error")||resultant) {
				  jtfResult.setText("9");
				  resultant = false;
			  }
			  else
				  jtfResult.setText(display + "9");
		  }
	  }
	  else if(e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_NUMPAD0)
	  {
		  {
		      display = jtfResult.getText();
		      if(display.equals("error")||resultant){
		        jtfResult.setText("0");
		  	  	resultant = false;
		      }
		      else if(display.equals("0")){
		      }
		      else{
		        jtfResult.setText(display + "0");
		      }
		  }
	  }
	  
	  //Add
	  else if(e.getKeyCode() == KeyEvent.VK_ADD || e.getKeyCode() == KeyEvent.VK_A)
	  {
		  {
		      display = jtfResult.getText();
		      if (display.equals("error")){
		    	  TEMP = 0;
		      }
		      else if(display.equals("")) {}
		      else if(resultant) resultant = false;
		      else{
		    	  TEMP = Double.parseDouble(display);
		      }
		      jtfResult.setText("");
		      addBool = true;
		      subBool = false;
		      mulBool = false;
		      divBool = false;
		   }
	  }
	  
	  //Substract
	  else if(e.getKeyCode() == KeyEvent.VK_SUBTRACT|| e.getKeyCode() == KeyEvent.VK_S)
	  {
		  {
		      display = jtfResult.getText();
		      if (display.equals("error")){
		    	  TEMP = 0;
		      }
		      else if(display.equals("")) {}
		      else if(resultant) resultant = false;
		      else{
		    	  TEMP = Double.parseDouble(display);
		      }
		      jtfResult.setText("");
		      addBool = false;
		      subBool = true;
		      mulBool = false;
		      divBool = false;
		   }
	  }
	  
	  //Multiply
	  else if(e.getKeyCode() == KeyEvent.VK_MULTIPLY|| e.getKeyCode() == KeyEvent.VK_M)
	  {
		  {
		      display = jtfResult.getText();
		      if (display.equals("error")){
		    	  TEMP = 0;
		      }
		      else if(display.equals("")) {}
		      else if(resultant) resultant = false;
		      else{
		    	  TEMP = Double.parseDouble(display);
		      }
		      jtfResult.setText("");
		      addBool = false;
		      subBool = false;
		      mulBool = true;
		      divBool = false;
		   }
	  }
	  
	  //Divide
	  else if(e.getKeyCode() == KeyEvent.VK_DIVIDE|| e.getKeyCode() == KeyEvent.VK_D)
	  {
		  {
		      display = jtfResult.getText();
		      if (display.equals("error")){
		    	  TEMP = 0;
		      }
		      else if(display.equals("")) {}
		      else if(resultant) resultant = false;
		      else{
		    	  TEMP = Double.parseDouble(display);
		      }
		      jtfResult.setText("");
		      addBool = false;
		      subBool = false;
		      mulBool = false;
		      divBool = true;
		   }
	  }
	  
	  //Clear
	  else if(e.getKeyCode() == KeyEvent.VK_C)
	  {
		  {
			  display = jtfResult.getText();
			  if (display.equals("error")){
			  	  jtfResult.setText("0");
			  }	
			  else if(display.equals("")) {
			  }
			  else if(resultant) {
			  	  jtfResult.setText("0");
			        resultant = false;
			  }
			  else if(Double.parseDouble(display)!=0){
			  jtfResult.setText("0");
		   }
		  }
	  }
	  
	  //All Clear
	  else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
	  {
		  {
			  jtfResult.setText("0");
			  addBool = false;
			  subBool = false;
			  mulBool = false;
			  divBool = false;
			  resultant = false;

			  TEMP = 0;
			  SolveTEMP = 0;
		   }
	  }
	  
	  //+-
	  else if(e.getKeyCode() == KeyEvent.VK_N)
	  {
		  {
			  display = jtfResult.getText();

			  if (display.equals("error")){
			  	  jtfResult.setText("0");
			  }
			  else if(display.equals("")) {
			  }
			  else if(Double.parseDouble(jtfResult.getText())==0){
			  }
			  else if(display.contains("-")){
			    jtfResult.setText(display.substring(1));
			    if (resultant) TEMP=Double.parseDouble(jtfResult.getText());
			  }            
			  else{
			    jtfResult.setText("-"+display);
			    if (resultant) TEMP=Double.parseDouble(jtfResult.getText());
			  }

		   }
	  }
	  
	  //Delete
	  else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
	  {
		  {
			  display = jtfResult.getText();

			  if(display.equals("0")||display.equals("")){
			  }
			  else if (display.length()==1||display.equals("error")||resultant){
			  	  jtfResult.setText("0");
			  	  resultant = false;
			  }
			  else{
			    jtfResult.setText(display.substring(0,display.length()-1));
			  }
		   }
	  }
	  
	  //Decimal
	  else if(e.getKeyCode() == KeyEvent.VK_PERIOD)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("error")||display.equals("")||resultant){
			    jtfResult.setText("0.");
			    resultant = false;
			  }
			  else if(display.contains(".")){
			  }
			  else{
			    jtfResult.setText(display+".");
			  }
		   }
	  }
	  
	  //Solve
	  else if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE)
	  {
		  {
			  display = jtfResult.getText();
			  if(display.equals("")||resultant) {
			  }
			  else {
			  	if(display.equals("error")){
			      	TEMP = 0;
			      }
			  	else {
			  		SolveTEMP = Double.parseDouble(display);
			  	}

			  	if(addBool == true){
			  		SolveTEMP = TEMP + SolveTEMP;
			  		TEMP = SolveTEMP;
			  	}

			  	else if (subBool == true){
			  		SolveTEMP = TEMP - SolveTEMP;
			  		TEMP = SolveTEMP;
			  	}

			  	else if (mulBool == true){
			  		SolveTEMP = TEMP * SolveTEMP;
			  		TEMP = SolveTEMP;
			  	}
			  	else if ((divBool == true) && (SolveTEMP==0)){
			  		jtfResult.setText("error");
			  		TEMP=0.0;
			  	}
			      else if ((divBool == true) && (SolveTEMP!=0)){
			      	SolveTEMP = TEMP / SolveTEMP;
			      	TEMP = SolveTEMP;
			      }
			      		    
			  	DecimalFormat format = new DecimalFormat("0.######");
			  	
			  	if  (jtfResult.getText().equals("error")){
			  	}    				
			  	else if (SolveTEMP == 0)
			  		jtfResult.setText("0");
			  	else if((Math.abs(SolveTEMP)>1e8) || (Math.abs(SolveTEMP)<1e-8)) {
			      	jtfResult.setText(String.format("%6.3e",SolveTEMP));
			      }
			      else
			      	jtfResult.setText(format.format(SolveTEMP));
			  	
			      addBool = false;
			      subBool = false;
			      mulBool = false;
			      divBool = false;
			      resultant = true;
			      SolveTEMP = 0.0;
			      }
		   }
	  }
	  
	  
  }
} //JavaCalculator