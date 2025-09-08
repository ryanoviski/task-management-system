package com.ryanoviski.task_management_system.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Task name is required")
	@Column(nullable = false, length = 100)
	private String name;
	
	@FutureOrPresent(message = "The date must be in the present or future")
	@Column(name = "due_date", nullable = false)
	private LocalDate dueDate;
	
	@NotBlank(message = "Assignee is required")
	private String assignee;

	public Task() {
	}

	public Task(Long id, String name, LocalDate dueDate, String assignee) {
		this.id = id;
		this.name = name;
		this.dueDate = dueDate;
		this.assignee = assignee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
}