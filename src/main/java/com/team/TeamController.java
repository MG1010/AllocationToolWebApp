package com.team;

import com.projects.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeamController {

	@Autowired
	ProjectDao TeamDao;

	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String showTeam(ModelMap model) {

		model.addAttribute("team",TeamDao.findAll());

		return "team";
	}
}
