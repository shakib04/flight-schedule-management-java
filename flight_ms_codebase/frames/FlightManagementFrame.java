
package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import entity.*;
import repository.*;

public class FlightManagementFrame extends JFrame implements ActionListener{
	private JLabel sysLabel, flightLabel, fromLabel, toLabel,dateLabel1,deptTimeLabel,dateLabel2, arrvlTimeLabel;
	private JButton addBtn, updateBtn,searchBtn, removeBtn, backBtn,logoutBtn,getAllBtn,refreshBtn;
	private JTextField flightNoTF, fromTF, toTF,date1TF,deptTime1TF,deptTime2TF,date2TF,arrvlTime1TF,arrvlTime2TF;
	private JPanel panel;
	private JTable flightTable;
	private JScrollPane flightTableSP;

	FlightRepo fr;
	Person person;
	PersonRepo pr;


	public FlightManagementFrame(){
		super("Flight Management");
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		panel = new JPanel();
		panel.setLayout(null);

		sysLabel = new JLabel("Flight Schedule MS");
		sysLabel.setBounds(5,20,200,50);
		panel.add(sysLabel);

		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(680,20,100,30);
		panel.add(logoutBtn);

		flightLabel = new JLabel("Flight No. : ");
		flightLabel.setBounds(20,70,70,20);
		panel.add(flightLabel);

		flightNoTF = new JTextField();
		flightNoTF.setBounds(100,70,120,20);
		panel.add(flightNoTF);

		fromLabel = new JLabel("From : ");
		fromLabel.setBounds(20,100,70,20);
		panel.add(fromLabel);

		fromTF = new JTextField();
		fromTF.setBounds(100,100,120,20);
		panel.add(fromTF);

		dateLabel1 = new JLabel("Date : ");
		dateLabel1.setBounds(20,130,70,20);
		panel.add(dateLabel1);

		date1TF = new JTextField();
		date1TF.setBounds(100,130,120,20);
		panel.add(date1TF);

		deptTimeLabel = new JLabel("Dep. Time : ");
		deptTimeLabel.setBounds(20,160,70,20);
		panel.add(deptTimeLabel);

		deptTime1TF = new JTextField();
		deptTime1TF.setBounds(100,160,58,20);
		panel.add(deptTime1TF);
		
		deptTime2TF = new JTextField();
		deptTime2TF.setBounds(160,160,58,20);
		panel.add(deptTime2TF);



		toLabel = new JLabel("To : ");
		toLabel.setBounds(20,190,70,20);
		panel.add(toLabel);

		toTF = new JTextField();
		toTF.setBounds(100,190,120,20);
		panel.add(toTF);

		dateLabel2 = new JLabel("Date : ");
		dateLabel2.setBounds(20,220,70,20);
		panel.add(dateLabel2);

		date2TF = new JTextField();
		date2TF.setBounds(100,220,120,20);
		panel.add(date2TF);

		arrvlTimeLabel = new JLabel("Arr. Time : ");
		arrvlTimeLabel.setBounds(20,250,70,20);
		panel.add(arrvlTimeLabel);

		arrvlTime1TF = new JTextField();
		arrvlTime1TF.setBounds(100,250,58,20);
		panel.add(arrvlTime1TF);
		
		arrvlTime2TF = new JTextField();
		arrvlTime2TF.setBounds(160,250,58,20);
		panel.add(arrvlTime2TF);


		addBtn = new JButton("Add");
		addBtn.setBounds(20,400,100,30);
		addBtn.addActionListener(this);
		panel.add(addBtn);

		updateBtn = new JButton("Update");
		updateBtn.setBounds(130,400,100,30);
		updateBtn.setEnabled(false);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);

		searchBtn = new JButton("Search");
		searchBtn.setBounds(250,400,100,30);
		searchBtn.addActionListener(this);
		panel.add(searchBtn);

		removeBtn = new JButton("Remove");
		removeBtn.setBounds(370,400,100,30);
		removeBtn.setEnabled(false);
		removeBtn.addActionListener(this);
		panel.add(removeBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(490,400,100,30);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		getAllBtn = new JButton("Show All");
		getAllBtn.setBounds(710,400,85,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);

		refreshBtn  = new JButton("Refresh");
		refreshBtn.setBounds(600,400,100,30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);


		String data[][]={{"","","","","","","","",""}};
		String head[]={"Flight No.","From", "Date","Time(Hrs)","Time(Mins)", "To","Date","Time(Hrs)","Time(Mins)"};
		flightTable = new JTable(data,head);
		flightTableSP = new JScrollPane(flightTable);
		flightTableSP.setBounds(230,60,550,320);
		flightTable.setEnabled(false);
		panel.add(flightTableSP);

		this.add(panel);

	}



	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(searchBtn.getText()))
		{
			if(!flightNoTF.getText().equals("") || !flightNoTF.getText().equals(null))
			{
				Flight f = fr.searchFlight(flightNoTF.getText());
				if(f!= null)
				{
					fromTF.setText(f.getJourneyFrom());
					dateLabel1.setText(f.getJourneyDate());
					deptTime1TF.setText(Integer.toString(f.getDepartureTimeHrs()));
					deptTime2TF.setText(Integer.toString(f.getDepartureTimeMins()));
					toTF.setText(f.getJourneyTo());
					dateLabel2.setText(f.getArrivalDate());
					arrvlTime1TF.setText(Integer.toString(f.getArrivalTimeHrs()));
					arrvlTime2TF.setText(Integer.toString(f.getArrivalTimeMins()));

					flightNoTF.setEnabled(false);
					fromTF.setEnabled(true);
					deptTime1TF.setEnabled(true);
					deptTime2TF.setEnabled(true);
					toTF.setEnabled(true);
					dateLabel2.setEnabled(true);
					arrvlTime1TF.setEnabled(true);
					arrvlTime2TF.setEnabled(true);
				
					
					searchBtn.setEnabled(false);
					removeBtn.setEnabled(true);
					addBtn.setEnabled(false);
					updateBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					backBtn.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Flight Id!");
				}
			}
		}
		else if(command.equals(addBtn.getText()))
		{
			Flight f = new Flight();
			Person p = new Person();
			Random rd = new Random();
			int x = rd.nextInt(99999)+100000;
			
			f.setFlightNumber(flightNoTF.getText());
			f.setJourneyFrom(fromTF.getText());
			f.setJourneyDate(date1TF.getText());
			f.setDepartureTimeHrs(Integer.parseInt(deptTime1TF.getText()));
			f.setDepartureTimeMins(Integer.parseInt(deptTime2TF.getText()));
			f.setJourneyTo(toTF.getText());
			f.setArrivalDate(date2TF.getText());
			f.setArrivalTimeHrs(Integer.parseInt(arrvlTime1TF.getText()));
			f.setArrivalTimeMins(Integer.parseInt(arrvlTime2TF.getText()));
			
			fr.insertFlight(f);
			
			JOptionPane.showMessageDialog(this, "Inserted Flight!");
			
			flightNoTF.setText("");
			fromTF.setText("");
			date1TF.setText("");
			deptTime1TF.setText("");
			deptTime2TF.setText("");
			toTF.setText("");
			date2TF.setText("");
			arrvlTime1TF.setText("");
			arrvlTime2TF.setText("");
			
			searchBtn.setEnabled(true);
			addBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			removeBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			backBtn.setEnabled(true);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			flightNoTF.setText("");
			fromTF.setText("");
			date1TF.setText("");
			deptTime1TF.setText("");
			deptTime2TF.setText("");
			toTF.setText("");
			date2TF.setText("");
			arrvlTime1TF.setText("");
			arrvlTime2TF.setText("");
			
		
			searchBtn.setEnabled(true);
			addBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			removeBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			backBtn.setEnabled(true);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Flight f = new Flight();
			
			f.setFlightNumber(flightNoTF.getText());
			f.setJourneyFrom(fromTF.getText());
			f.setJourneyDate(date1TF.getText());
			f.setDepartureTimeHrs(Integer.parseInt(deptTime1TF.getText()));
			f.setDepartureTimeMins(Integer.parseInt(deptTime2TF.getText()));
			f.setJourneyTo(toTF.getText());
			f.setArrivalDate(date2TF.getText());
			f.setArrivalTimeHrs(Integer.parseInt(arrvlTime1TF.getText()));
			f.setArrivalTimeMins(Integer.parseInt(arrvlTime2TF.getText()));
			fr.updateFlight(f);


		
			
			JOptionPane.showMessageDialog(this, "Updated!");
			


			flightNoTF.setText("");
			fromTF.setText("");
			date1TF.setText("");
			deptTime1TF.setText("");
			deptTime2TF.setText("");
			toTF.setText("");
			date2TF.setText("");
			arrvlTime1TF.setText("");
			arrvlTime2TF.setText("");
			
			searchBtn.setEnabled(true);
			addBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			removeBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			backBtn.setEnabled(true);
			
		}
		else if(command.equals(removeBtn.getText()))
		{
			fr.removeFlight(flightNoTF.getText());
			
			JOptionPane.showMessageDialog(this,"Flight Removed!");
			
			flightNoTF.setText("");
			fromTF.setText("");
			date1TF.setText("");
			deptTime1TF.setText("");
			deptTime2TF.setText("");
			toTF.setText("");
			date2TF.setText("");
			arrvlTime1TF.setText("");
			arrvlTime2TF.setText("");
			
			
			flightNoTF.setEnabled(true);
			fromTF.setEnabled(true);
			date1TF.setEnabled(true);
			deptTime1TF.setEnabled(true);
			deptTime2TF.setEnabled(true);
			toTF.setEnabled(true);
			date2TF.setEnabled(true);
			arrvlTime1TF.setEnabled(true);
			arrvlTime2TF.setEnabled(true);
	
			searchBtn.setEnabled(true);
			addBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			removeBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			backBtn.setEnabled(true);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = fr.getAllFlight();
			String head[] = {"Flight No.","From", "Date","Time(Hrs)","Time(Mins)", "To","Date","Time(Hrs)","Time(Mins)"};
			
			panel.remove(flightTableSP);
			
			flightTable = new JTable(data,head);
			flightTable.setEnabled(false);
			flightTableSP = new JScrollPane(flightTable);
			flightTableSP.setBounds(230,60,550,320);
			panel.add(flightTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			ManagerHome mh = new ManagerHome(person);
			mh.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(logoutBtn.getText())){
			LoginFrame lf =  new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else{

		}
		
	}
}