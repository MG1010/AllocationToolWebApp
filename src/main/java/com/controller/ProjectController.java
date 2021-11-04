package com.controller;

import com.domain.Project;
import com.dao.ProjectDao;
import com.repository.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {

    private final int total = 10;
    private final ProjectDao projectDao;
    private final ProjectRepository repository;

    public ProjectController(ProjectRepository repository, ProjectDao projectDao) {
        this.repository = repository;
        this.projectDao = projectDao;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String showProjects(ModelMap model) {

//        int pageId = 1;
//        model.addAttribute("pageId", pageId);
//        model.addAttribute("projects", projectDao.findProjectsByPage(pageId, total));

        model.addAttribute("projects", repository.findAll());

        return "projects";
    }

    @RequestMapping(value = "/projects/{pageId}", method = RequestMethod.GET)
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
    public String showViewProject(@PathVariable int id, ModelMap model) {

        model.addAttribute("project", repository.findById(id));

        return "viewproject";
    }

    @RequestMapping(value = "/editproject/{id}", method = RequestMethod.GET)
    public String showEditProject(@PathVariable int id, ModelMap model) {

        model.addAttribute("project", repository.findById(id));

        return "editproject";
    }

    @RequestMapping(value = "/editproject/{id}", method = RequestMethod.POST)
    public String editProject(@PathVariable int id, @RequestParam String name, String desc) {

        Project project = repository.findById(id);
        project.setName(name);
        project.setDescription(desc);

        repository.save(project);

        return "redirect:/projects";
    }

    @RequestMapping(value = "/addproject", method = RequestMethod.GET)
    public String showAddProject() {
        return "addproject";
    }

    @RequestMapping(value = "/addproject", method = RequestMethod.POST)
    public String addProject(@RequestParam String name, String desc) {

        Project project = new Project(name, desc);

        repository.save(project);

        return "redirect:/projects";
    }

    @RequestMapping(value = "/deleteproject/{id}", method = RequestMethod.GET)
    public String deleteProject(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect:/projects";
    }

}
