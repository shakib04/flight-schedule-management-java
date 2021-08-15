package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;


public class LoginFrame extends JFrame implements ActionListener, MouseListener
{
	JLabel title, userLabel, passLabel, regLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn, frgtBtn, showPassBtn, regBtn;
	JPanel panel;
	
	public LoginFrame()
	{
		super("Flight Scheduling System - Login Window");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Flight Scheduling System");
		title.setBounds(300, 50, 200, 30);
		panel.add(title);
		
		userLabel = new JLabel("User ID:");
		userLabel.setBounds(290 , 170, 70, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(360, 170, 150, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password:");
		passLabel.setBounds(290, 220, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(360, 220, 150, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);

		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(510, 220, 70, 30);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(260, 300, 80, 30);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(460, 300, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		frgtBtn = new JButton("Forgot");
		frgtBtn.setBounds(360, 300, 80, 30);
		frgtBtn.addActionListener(this);
		panel.add(frgtBtn);

		regLabel = new JLabel("Are you new?");
		regLabel.setBounds(300, 350, 120, 30);
		panel.add(regLabel);

		regBtn = new JButton("click here");
		regBtn.setBounds(400, 350, 100, 30);
		regBtn.addActionListener(this);
		panel.add(regBtn);
		
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			PersonRepo pr = new PersonRepo();
			Person person = pr.getPerson(userTF.getText(), passPF.getText());
			
			if(person != null)
			{
				if(person.getStatus() == 0 || person.getStatus() == 1)
				{
					ManagerHome mh = new ManagerHome(person);
					mh.setVisible(true);
					this.setVisible(false);
				}
				else if(person.getStatus() == 2)
				{
					
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
		}
		 else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(command.equals(frgtBtn.getText()))
		{
			ForgotFrame ff = new ForgotFrame(this);
			ff.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(regBtn.getText()))
		{

		}
		else{}
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	
}