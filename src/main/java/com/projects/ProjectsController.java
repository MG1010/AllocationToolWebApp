package com.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectsController {

    final int total = 10;

    @Autowired
    ProjectDao projectDao;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String showProjects(ModelMap model) {

        int pageId = 1;
        model.addAttribute("pageId", pageId);
        model.addAttribute("projects", projectDao.findProjectsByPage(pageId, total));

        return "projects";
    }

    @RequestMapping(value = "/projects/{pageId}")
    public String showProjectsByPageID(@PathVariable int pageId, ModelMap model) {

        model.addAttribute("pageId", pageId);

        if (pageId <= 1 ) {
            pageId = 1;
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        model.addAttribute("projects", projectDao.findProjectsByPage(pageId, total));

        return "projects";
    }

    @RequestMapping(value = "/editproject", method = RequestMethod.GET)
    public String showEditProject() {

        return "editproject";
    }

//    @RequestMapping(value = "/editproject/{id}")
//    public String ShowProjectByID(@PathVariable Integer id, Model model) {
//
//        model.addAttribute("project", projectDao.getProjectByID(id));
//
//        return "editproject";
//    }

//		@RequestMapping(value = "/editproject", method = RequestMethod.POST)
//		public String add(@RequestParam String name, String desc) {
//			projectDao.add(new Project(name, desc));
//			return "redirect:/projects";

    @RequestMapping(value = "/addproject", method = RequestMethod.GET)
    public String showAddProject() {
        return "addproject";
    }

    @RequestMapping(value = "/addproject", method = RequestMethod.POST)
    public String add(@RequestParam String name, String desc) {
        projectDao.add(new Project(name, desc));
        return "redirect:/projects";
    }

    @RequestMapping(value = "/deleteproject/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        projectDao.delete(id);
        return "redirect:/projects";
    }

}
