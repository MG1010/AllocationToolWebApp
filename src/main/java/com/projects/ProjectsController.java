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
    ProjectRepository repository;

    @Autowired
    ProjectDao projectDao;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String showProjects(ModelMap model) {

//        int pageId = 1;
//        model.addAttribute("pageId", pageId);
//        model.addAttribute("projects", projectDao.findProjectsByPage(pageId, total));

        model.addAttribute("projects", repository.findAll());

        return "projects";
    }

    @RequestMapping(value = "/projects/{pageId}")
    public String showProjectsByPageID(@PathVariable int pageId, ModelMap model) {

        model.addAttribute("pageId", pageId);

        if (pageId <= 1) {
            pageId = 1;
        } else {
            pageId = (pageId - 1) * total + 1;
        }
        model.addAttribute("projects", projectDao.findProjectsByPage(pageId, total));

        return "projects";
    }

    @RequestMapping(value = "/viewproject/{id}", method = RequestMethod.GET)
    public String view(@PathVariable int id, ModelMap model) {

        model.addAttribute("project", repository.findById(id));

        return "viewproject";
    }

    @RequestMapping(value = "/editproject/{id}", method = RequestMethod.GET)
    public String showEditProject(@PathVariable int id, ModelMap model) {

        model.addAttribute("project", repository.findById(id));

        return "editproject";
    }

/*    @RequestMapping(value = "/editproject/{id}", method = RequestMethod.POST)
    public String editProject(@RequestParam Integer id,String name, String desc) {

        Project project = new Project(name, desc);

        repository.save(project);

        return "redirect:/projects";
    }*/

    @RequestMapping(value = "/addproject", method = RequestMethod.GET)
    public String showAddProject() {
        return "addproject";
    }

    @RequestMapping(value = "/addproject", method = RequestMethod.POST)
    public String add(@RequestParam String name, String desc) {

        Project project = new Project(name, desc);
        System.out.println(project.getId());
        System.out.println(project.getName());
        System.out.println(project.getDescription());

        repository.save(project);

        return "redirect:/projects";
    }

    @RequestMapping(value = "/deleteproject/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect:/projects";
    }

}
