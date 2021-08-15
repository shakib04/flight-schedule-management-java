package entity;

import java.lang.*;

public class Person
{
	private String personId;
	private String password;
	private int status;
	
	public Person(){}
	public Person(String personId, String password, int status)
	{
		this.personId = personId;
		this.password = password;
		this.status = status;
	}
	
	public void setPersonId(String personId){this.personId = personId;}
	public void setPassword(String password){this.password = password;}
	public void setStatus(int status){this.status = status;}
	
	public String getPersonId(){return personId;}
	public String getPassword(){return password;}
	public int getStatus(){return status;}
}