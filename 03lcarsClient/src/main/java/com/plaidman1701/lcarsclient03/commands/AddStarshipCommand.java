// INCOMPLETE

package com.plaidman1701.lcarsclient03.commands;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.plaidman1701.lcarsclient03.ui.PresentationUtil;
import com.plaidman1701.lcarsserver03.entity.ResponseCode;
import com.plaidman1701.lcarsserver03.entity.Starship;

public class AddStarshipCommand extends AbstractCommand{

	@Override
	public void execute(HttpServletRequest request) {
		
		Starship starshipToAdd = new Starship();
		
		// parse details from form
		starshipToAdd.setRegistry(request.getParameter("registry"));
		starshipToAdd.setName(request.getParameter("name"));
		starshipToAdd.setStatus(request.getParameter("status"));
		starshipToAdd.setVesselclass(request.getParameter("vesselclass"));
		
		// check for bad Date format, if no good build a homegrown response code and send it back to the ui
		try
		{
			starshipToAdd.setLaunched(getDateFromString(request.getParameter("launched")));
		}
		catch (ParseException e)
		{
			ResponseCode rcode = new ResponseCode();
			
			rcode.setCode(PresentationUtil.getString("error.add.starship.invalidDate.code"));
			rcode.setDesc(PresentationUtil.getString("error.add.starship.invalidDate.desc"));
			
			// need to pad it out in a collection, as that's what addStarship.jsp is expecting
			List<ResponseCode> responseErrors = new ArrayList<ResponseCode>();
			responseErrors.add(rcode);
			
			request.setAttribute("addResponseCode", responseErrors);
			return;
		}
		
		request.setAttribute("addResponseCode", starshipServices.addStarship(starshipToAdd));

		request.setAttribute("tabtoload", "addSelected");
	}
	
	private Date getDateFromString(String dateAsString) throws ParseException
	{
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.parse(dateAsString);
	}
}