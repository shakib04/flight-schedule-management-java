package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class FlightRepo implements iFlight
{
	DatabaseConnection dbc;
	
	public FlightRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertFlight(Flight f)
	{
		String query = "INSERT INTO flights VALUES ('"+f.getFlightNumber()+"','"+f.getJourneyFrom()+"',"+f.getDepartureTimeHrs()+","+f.getDepartureTimeMins()+",'"+f.getJourneyTo()+"',"+f.getArrivalTimeHrs()+","+f.getArrivalTimeMins()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void removeFlight(String flightNumber)
	{
		String query = "DELETE from flights WHERE flightNumber='"+flightNumber+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateFlight(Flight f)
	{
		String query = "UPDATE flights SET ,'"+f.getJourneyFrom()+"',"+f.getDepartureTimeHrs()+","+f.getDepartureTimeMins()+",'"+f.getJourneyTo()+"',"+f.getArrivalTimeHrs()+","+f.getDepartureTimeMins()+" WHERE flightNumber='"+f.getFlightNumber()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Flight searchFlight(String flightNumber)
	{
		Flight flt=null;
		String query = "SELECT `journeyFrom`, `departureTimeHrs`, `departureTimeMins`, `journeyTo`,`arrivalTimeHrs`,`arrivalTimeMins` FROM `flights` WHERE `flightNumber`='"+flightNumber+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String journeyFrom = dbc.result.getString("journeyFrom");
				int departureTimeHrs = dbc.result.getInt("departureTimeHrs");
				int departureTimeMins = dbc.result.getInt("departureTimeMins");
				String journeyTo = dbc.result.getString("journeyTo");
				int arrivalTimeHrs = dbc.result.getInt("arrivalTimeHrs");
				int arrivalTimeMins = dbc.result.getInt("arrivalTimeMins");
				
				flt = new Flight();
				flt.setFlightNumber(flightNumber);
				flt.setJourneyFrom(journeyFrom);
				flt.setDepartureTimeHrs(departureTimeHrs);
				flt.setDepartureTimeMins(departureTimeMins);
				flt.setJourneyTo(journeyTo);
				flt.setArrivalTimeHrs(arrivalTimeHrs);
				flt.setArrivalTimeMins(arrivalTimeMins);
			
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return flt;
	}
	public String[][] getAllFlight()
	{
		ArrayList<Flight> ar = new ArrayList<Flight>();
		String query = "SELECT * FROM Flight;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			while(dbc.result.next())
			{
				String flightNumber = dbc.result.getString("flightNumber");
				String journeyFrom = dbc.result.getString("journeyFrom");
				int departureTimeHrs = dbc.result.getInt("departureTimeHrs");
				int departureTimeMins = dbc.result.getInt("departureTimeMins");
				String journeyTo = dbc.result.getString("journeyTo");
				int arrivalTimeHrs = dbc.result.getInt("arrivalTimeHrs");
				int arrivalTimeMins = dbc.result.getInt("arrivalTimeMins");
				Flight flight = new Flight(flightNumber,journeyFrom,departureTimeHrs,departureTimeHrs,journeyTo,arrivalTimeHrs,arrivalTimeHrs);
				ar.add(flight);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][7];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Flight)obj[i]).getFlightNumber();
			data[i][1] = ((Flight)obj[i]).getJourneyFrom();
			data[i][2] = Integer.toString(((Flight)obj[i]).getDepartureTimeHrs());
			data[i][3] = Integer.toString(((Flight)obj[i]).getDepartureTimeMins());
			data[i][4] = ((Flight)obj[i]).getJourneyTo();
			data[i][5] = Integer.toString(((Flight)obj[i]).getArrivalTimeHrs());
			data[i][6] = Integer.toString(((Flight)obj[i]).getArrivalTimeMins());
		}
		return data;
	}
}

