package com.plaidman1701.lcarsclient03.service;

import java.util.List;

import com.plaidman1701.lcarsserver03.entity.ResponseCode;
import com.plaidman1701.lcarsserver03.entity.Starship;

public interface StarshipServices {
	
	List<Starship> getStarships();
	ResponseCode findStarship(String stringToFind);
	List<ResponseCode> addStarship(Starship starshipToAdd);
	ResponseCode removeStarship(String registryToRemove);

}
