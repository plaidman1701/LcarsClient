package com.plaidman1701.lcarsclient03.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.plaidman1701.lcarsclient03.commands.Command;
import com.plaidman1701.lcarsclient03.service.StarshipServices;
import com.plaidman1701.lcarsclient03.service.StarshipServicesClient;

@WebServlet(name="StarshipServlet", urlPatterns="/starshipApp")
public class StarshipServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1380213578838938090L;
	private static final String COMMANDS_FILE = "/data/commands.properties";
	
	// Initial command, also good to demo the logic here
	private static final String SERVICE_INIT_ACTION = "service.getStarships";
	
	private Logger logger = Logger.getLogger(StarshipServlet.class);

	private static Properties commandsProps;
	private StarshipServices starshipServices;
	
	public StarshipServlet()
	{
		super();
	}
	
	private Command getCommand(String action) throws Exception 
	{
		// First time in, call initialization command
		if ( action == null ) 
		{
			action = SERVICE_INIT_ACTION;
		}
		
		// Simple factory for the commands
		String classToFind = commandsProps.getProperty(action);
		Command command  = (Command) Class.forName(classToFind).newInstance();
		
		return command;	
	}
	
	@Override
	public void init() throws ServletException
	{
		super.init();
		
		// get JNDI reference
		starshipServices = new StarshipServicesClient();
		
		commandsProps = new Properties();
		try 
		{
			commandsProps.load(new FileInputStream(getServletContext().getRealPath(COMMANDS_FILE)));
		}
		catch (FileNotFoundException e) 
		{
			logger.fatal("Can't find " + COMMANDS_FILE, e);
		} 
		catch (IOException e) 
		{
			logger.fatal("Problem loading " + COMMANDS_FILE , e);
		}
		catch (Exception e)
		{
			logger.fatal("something went wrong " + e);
		}
		
		/*
		// new load process, different from v02
		try {
			commandsProps.load(new FileInputStream("commands.properties"));
		} catch (FileNotFoundException e) {
			logger.fatal("Can't find " + COMMANDS_FILE, e);
		} catch (IOException e) {
			logger.fatal("Problem loading " + COMMANDS_FILE , e);
		} catch (Exception e) {
			logger.fatal("something went wrong " + e);
		}
		 */
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// magic time
		String commandAction = request.getParameter("action");
		try
		{
			/* Locate the command and execute it */
			Command commandToRun = getCommand(commandAction);
			commandToRun.execute(request);
			
			response.setCharacterEncoding("UTF-8");
			request.getServletContext().setAttribute("starships", starshipServices.getStarships());
			
			request.getRequestDispatcher("/landing.jsp").forward(request, response);

		}
		catch (Exception e) 
		{
			logger.error("An exception occurred processing an action request : " + e);
			
			// set error attributes in UI
			request.setAttribute("errorTitle", e);
			request.setAttribute("errorMsg", (e.getCause() != null ? e.getCause().getMessage() : e.getMessage()));
			e.printStackTrace();
			request.getRequestDispatcher("/errors.jsp").forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
}
