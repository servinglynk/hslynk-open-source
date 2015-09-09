package com.servinglynk.hmis.warehouse.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.servinglynk.hmis.warehouse.model.HmisType;
import com.servinglynk.hmis.warehouse.model.HmisUser;
import com.servinglynk.hmis.warehouse.model.Sync;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;

@Controller
@RequestMapping(value="/user")
public class HmisUserController {

	@Autowired
	@Qualifier("serviceFactory")
	private ParentServiceFactory parentServiceFactory;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addHmisUser() {
		ModelAndView modelAndView = new ModelAndView("user-add");
		modelAndView.addObject("user", new HmisUser());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingStrategy(@ModelAttribute HmisUser user) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		user.setId(UUID.randomUUID());
		user.setGender(com.servinglynk.hmis.warehouse.enums.HmisUserGenderEnum.ONE);
		//user.setOrganization(HmisUserOrganizationEnum.ONE);
		user.setSsn(user.getSsn());
		user.setDateCreated(LocalDate.now());
		user.setDateUpdated(LocalDate.now());
		parentServiceFactory.getHmisUserService().addHmisUser(user);
		
		String message = "User was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfHmisUsers() {
		ModelAndView modelAndView = new ModelAndView("user-list");
		List<HmisUser> hmisUsers = parentServiceFactory.getHmisUserService().getHmisUsers("id");
		modelAndView.addObject("users", hmisUsers);
		
		return modelAndView;
	}
	@RequestMapping(value="/listSync")
	public ModelAndView listOfSyncs() {
		ModelAndView modelAndView = new ModelAndView("user-synclist");
		List<Sync> syncs = parentServiceFactory.getSyncListService().getSyncs();
		modelAndView.addObject("syncs", syncs);
		return modelAndView;
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editStrategyPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("user-edit");
		HmisUser user = parentServiceFactory.getHmisUserService().getHmisUser(String.valueOf(id));
		modelAndView.addObject("user",user);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingStrategy(@ModelAttribute HmisUser hmisUser, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		parentServiceFactory.getHmisUserService().updateStrategy(hmisUser);
		
		String message = "User was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteStrategy(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		parentServiceFactory.getHmisUserService().deleteHmisUser(String.valueOf(id));
		String message = "User was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
