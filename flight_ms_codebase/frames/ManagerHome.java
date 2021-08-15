package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class ManagerHome extends JFrame implements ActionListener 
{
	JLabel title;
	JButton logoutBtn, schBtn, empBtn;
	JPanel panel;
	
	Person person;
	Flight flight;
	
	public ManagerHome(Person person)
	{
		super("Manager Window");
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.person = person;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Flight Scheduling System");
		title.setBounds(300, 30, 200, 30);
		panel.add(title);
		
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(700 , 20, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		schBtn = new JButton("Manage Schedule");
		schBtn.setBounds(150, 200, 240, 150);
		schBtn.addActionListener(this);
		panel.add(schBtn);
				
		empBtn = new JButton("Manage Employee");
		empBtn.setBounds(410, 200, 240, 150);
		empBtn.addActionListener(this);
		panel.add(empBtn);
		
		
		
		this.add(panel);
	
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		if(command.equals(empBtn.getText()))
		{
			if(person.getStatus()==0)
			{
				EmployeeManagementFrame emf = new EmployeeManagementFrame(person);
				emf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		if(command.equals(schBtn.getText()))
		{
			if(person.getStatus()==0)
			{
				FlightManagementFrame fmf = new FlightManagementFrame();
				fmf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
	}
}