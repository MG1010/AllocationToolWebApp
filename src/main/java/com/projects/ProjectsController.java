package com.projects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectsController {

	
		@RequestMapping(value = "/projects", method = RequestMethod.GET)
		public String showPage() {
			return "projects";
		}
}
