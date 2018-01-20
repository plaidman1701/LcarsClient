package com.plaidman1701.lcarsclient03.service;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.plaidman1701.lcarsserver03.entity.ResponseCode;
import com.plaidman1701.lcarsserver03.entity.Starship;
import com.plaidman1701.lcarsserver03.service.StarshipServicesRemote;

public class StarshipServicesClient implements StarshipServices {
	
	StarshipServicesRemote starshipServicesRemote;
	
	public StarshipServicesClient()
	{
		try
		{
			System.out.println("getting SSR");

			starshipServicesRemote = getSSR();
			
			System.out.println("got SSR");
		}
		catch (NamingException e)
		{
			System.out.println("Could not get SSR!");
			e.printStackTrace();			
		}
		
	}
	
	private StarshipServicesRemote getSSR() throws NamingException
	{
		InitialContext context = new InitialContext();
		System.out.println("Got context!");
		StarshipServicesRemote ssr = (StarshipServicesRemote)context.lookup("java:global/03lcarsServer/StarshipServicesImp!com.plaidman1701.lcarsserver03.service.StarshipServicesRemote");
		
		
		return ssr;
	}

	@Override
	public List<Starship> getStarships() {
		// TODO Auto-generated method stub
		return starshipServicesRemote.getStarshipList();
	}

	@Override
	public ResponseCode findStarship(String stringToFind) {
		// TODO Auto-generated method stub
		return starshipServicesRemote.findStarship(stringToFind);
	}

	public List<ResponseCode> addStarship(Starship starshipToAdd) {
		// TODO Auto-generated method stub
		return starshipServicesRemote.addStarship(starshipToAdd);
	}

	public ResponseCode removeStarship(String registryToRemove) {
		// TODO Auto-generated method stub
		return starshipServicesRemote.removeStarship(registryToRemove);
	}

}
