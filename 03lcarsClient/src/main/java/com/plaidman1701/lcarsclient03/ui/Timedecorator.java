package com.plaidman1701.lcarsclient03.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.displaytag.decorator.TableDecorator;

import com.plaidman1701.lcarsserver03.entity.Starship;

public class Timedecorator extends TableDecorator {
	
	public String getLaunched()
	{
		String blankString = "";
		
		Date launched = ((Starship)(this.getCurrentRowObject())).getLaunched();
		
		if ((launched==null) || (blankString.equals(launched)))
		{
			return blankString;
		}
		
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		return formatter.format(launched);
	}

}
