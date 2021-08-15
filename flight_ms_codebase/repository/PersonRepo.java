package repository;

import java.lang.*;

import entity.*;
import interfaces.*;

public class PersonRepo implements iPerson
{
	DatabaseConnection dbc;
	
	public PersonRepo()
	{
		dbc = new DatabaseConnection();
	}
	public Person getPerson(String personId, String pass)
	{
		Person person = null;
		String query = "SELECT personId, password, status FROM person WHERE personId='"+personId+"' AND password='"+pass+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				person = new Person();
				person.setPersonId(dbc.result.getString("personId"));
				person.setPassword(dbc.result.getString("password"));
				person.setStatus(dbc.result.getInt("status"));
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return person;
	}
	public void insertPerson(Person p)
	{
		String query = "INSERT INTO person VALUES ('"+p.getPersonId()+"','"+p.getPassword()+"',"+p.getStatus()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updatePerson(Person p){
		
	}
	public void deletePerson(String personId)
	{
		String query = "DELETE from person  WHERE personId='"+personId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}