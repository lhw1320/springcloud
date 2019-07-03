package com.qdfae.jdk.domain;

import java.util.ArrayList;
import java.util.List;

public class RefundParam {
	
	private Person person;
	
	private List<Project> projects = new ArrayList<>();

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
