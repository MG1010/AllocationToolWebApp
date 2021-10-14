package com.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectsController {

@Autowired
ProjectDao projectDao;

		@RequestMapping(value = "/projects", method = RequestMethod.GET)
		public String showProjects(ModelMap model) {

			model.addAttribute("projects",projectDao.findAll());

			return "projects";
			}

		}
