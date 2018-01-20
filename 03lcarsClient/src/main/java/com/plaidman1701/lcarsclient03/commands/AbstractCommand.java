package com.plaidman1701.lcarsclient03.commands;

import javax.servlet.http.HttpServletRequest;

import com.plaidman1701.lcarsclient03.service.StarshipServices;
import com.plaidman1701.lcarsclient03.service.StarshipServicesClient;

public abstract class AbstractCommand implements Command
{
	// connection to JNDI bean
	protected StarshipServices starshipServices;
	
	// independent connection for each command
	public AbstractCommand()
	{
		starshipServices = new StarshipServicesClient();
	}
	
	// per interface
	public abstract void execute(HttpServletRequest request);
}
