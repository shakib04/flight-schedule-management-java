package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import entity.*;
import interfaces.*;

public class ForgotFrame extends JFrame implements ActionListener
{
	private JButton submitBtn, backBtn;
	private JTextField userTF;
	private JLabel title,userLabel;
	private JPanel panel;
	private LoginFrame lf;
	
	public ForgotFrame(LoginFrame lf)
	{
		super("Forgot Password?");
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.lf = lf;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Flight Scheduling System");
		title.setBounds(300, 50, 200, 30);
		panel.add(title);
		
		userLabel = new JLabel("User ID:");
		userLabel.setBounds(290 , 220, 70, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(360, 220, 150, 30);
		panel.add(userTF);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(310, 300, 80, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(410, 300, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		/*if(command.equals(loginBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(userTF.getText());
			
			if(user != null)
			{
				if(user.getStatus() == 0 || user.getStatus() == 1)
				{
					if(command.equals(submitBtn.getText()))
		{
			JOptionPane.showMessageDialog(this, "Your New Password is : ");
		}
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Name");
			}
			
		} */
		if(command.equals(backBtn.getText()))
		{
			this.setVisible(false);
			lf.setVisible(true);
		}
		else{}
	}
}