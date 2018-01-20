package com.plaidman1701.lcarsclient03.commands;

import javax.servlet.http.HttpServletRequest;

public class GetAllStarshipsCommand extends AbstractCommand{

	@Override
	public void execute(HttpServletRequest request) {
		// nothing needs to be done here since list of ships is handled in the filter

	}
}