package com.projects;

import java.util.Date;
import java.util.List;
import com.team.TeamMember;

public class Project {

	private Integer id;
	private String name;
	private String description;
//	private Date startDate;
//	private Date endDate;
//	private List <TeamMember> teamMembers;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Project() {
	}

	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format(
				"Project[name=%d, description='%s']",
				name, description);
	}

}
