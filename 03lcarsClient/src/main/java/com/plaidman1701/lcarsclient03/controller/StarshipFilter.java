package com.plaidman1701.lcarsclient03.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.plaidman1701.lcarsclient03.service.StarshipServices;
import com.plaidman1701.lcarsclient03.service.StarshipServicesClient;

@WebFilter(filterName="StarshipFilter", urlPatterns="/")
public class StarshipFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {

		StarshipServices starshipServices = new StarshipServicesClient();
		// get the starship list and assign it
		filterConfig.getServletContext().setAttribute("starships", starshipServices.getStarships());
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
