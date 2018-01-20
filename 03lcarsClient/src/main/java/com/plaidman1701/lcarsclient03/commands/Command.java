package com.plaidman1701.lcarsclient03.commands;

import javax.servlet.http.HttpServletRequest;

//every command needs an Execute, at least
public interface Command 
{
	// execute returns void, all data sent back goes to the UI attributes
	public void execute( HttpServletRequest request ) throws Exception;
}

