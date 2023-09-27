package com.neon.mainsource;



import com.neon.mainsource.myframe;
import com.neon.mainsource.myframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
  
    JTextField textf;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton add,sub, mul , div ,neg ,dec, equ , del , clr ;
	Font fn1=new Font("Arial",Font.BOLD,22);
	Font fn2=new Font("DigifaceWide",Font.BOLD,22);
    Font fn3 = new Font("Arial", Font.BOLD, 33);
    double num1 = 0, num2 = 0, result = 0;

    char operator;

	JPanel panel;
	
    Calculator()
    {
		//Designing Frame instances
		
        myframe frame = new myframe();

         frame.setLayout(null);

         textf = new JTextField();
         textf.setBounds(50, 25, 300, 50);
         textf.setFont(fn3);
         textf.setBackground(Color.PINK);
         textf.setForeground(Color.black);
         textf.setEditable(false);
         
         add = new JButton("+");
    
		sub = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		dec = new JButton(".");
		equ = new JButton("=");
		del = new JButton("Del");
		clr = new JButton("Clr");
		neg = new JButton("(-)");
		
		functionButtons[0] = add;
		functionButtons[1] = sub;
		functionButtons[2] = mul;
		functionButtons[3] = div;
		functionButtons[4] = dec;
		functionButtons[5] = equ;
		functionButtons[6] = del;
		functionButtons[7] = clr;
        functionButtons[8] = neg;


        for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(fn2);
            functionButtons[i].setBackground(Color.black);
            functionButtons[i].setForeground(Color.red);
			functionButtons[i].setFocusable(false);
		}
        for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(Color.black);
            numberButtons[i].setFont(fn2);
            numberButtons[i].setForeground(Color.green);
			numberButtons[i].setFocusable(false);
		}
        neg.setBounds(50,430,100,50);
		del.setBounds(150,430,100,50);
		clr.setBounds(250,430,100,50);

        panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));

        panel.setBackground(Color.black);
        panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(add);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(sub);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mul);
		panel.add(dec);
		panel.add(numberButtons[0]);
		panel.add(equ);
		panel.add(div);


        frame.add(panel);
        frame.add(neg);
		frame.add(del);
		frame.add(clr);
         frame.add(textf);
        frame.setVisible(true);
        
       


    }


	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> new Calculator());
	}


    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textf.setText(textf.getText().concat(String.valueOf(i)));
			}
		}

        if(e.getSource()==dec) {
			textf.setText(textf.getText().concat("."));
		}

        if(e.getSource()==add) {
			num1 = Double.parseDouble(textf.getText());
			operator ='+';
			textf.setText("");
		}
		if(e.getSource()==sub) {
			num1 = Double.parseDouble(textf.getText());
			operator ='-';
			textf.setText("");
		}
		if(e.getSource()==mul) {
			num1 = Double.parseDouble(textf.getText());
			operator ='*';
			textf.setText("");
		}
        if (e.getSource() == div) {
            num1 = Double.parseDouble(textf.getText());
            operator = '/';
            textf.setText("");
        }
        if (e.getSource() == equ) {
            num2 = Double.parseDouble(textf.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textf.setText(String.valueOf(result));
            num1 = result;
        }
  
        if(e.getSource()==clr) {
			textf.setText("");
		              }
		if(e.getSource()==del) {
			String string = textf.getText();
			textf.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textf.setText(textf.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==neg) {
			double temp = Double.parseDouble(textf.getText());
			temp*=-1;
			textf.setText(String.valueOf(temp));
		}



    }


    public static void setVisible(boolean b) {
    }
}


