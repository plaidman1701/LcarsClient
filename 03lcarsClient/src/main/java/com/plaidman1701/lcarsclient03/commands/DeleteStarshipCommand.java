package com.plaidman1701.lcarsclient03.commands;

import javax.servlet.http.HttpServletRequest;

import com.plaidman1701.lcarsserver03.entity.ResponseCode;

public class DeleteStarshipCommand extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request) {

		ResponseCode rCode = starshipServices.removeStarship(request.getParameter("registry"));
		request.setAttribute("delResponseCode", rCode);
		
		request.setAttribute("tabtoload", "removeSelected");
	}
}