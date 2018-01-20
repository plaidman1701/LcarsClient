package com.plaidman1701.lcarsclient03.commands;

import javax.servlet.http.HttpServletRequest;

public class FindStarshipCommand extends AbstractCommand {
	
	@Override
	public void execute(HttpServletRequest request)
	{
		String starshipToFind = request.getParameter("stringToFind");
		request.setAttribute("findResponseCode", starshipServices.findStarship(starshipToFind));
		
		request.setAttribute("tabtoload", "searchSelected");
	}
}
