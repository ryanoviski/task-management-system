package com.ryanoviski.task_management_system.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanoviski.task_management_system.model.Task;
import com.ryanoviski.task_management_system.repository.TaskRepository;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	private final TaskRepository repository;

	public TaskController(TaskRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public ResponseEntity<Task> create(@RequestBody Task task) {
		Task saved = repository.save(task);
		return ResponseEntity.ok(saved);
	}

	@GetMapping
	public ResponseEntity<List<Task>> listAll() {
		List<Task> tasks = repository.findAll();
		return ResponseEntity.ok(tasks);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id) {
		return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task newTask) {
		return repository.findById(id).map(task -> {
			task.setName(newTask.getName());
			task.setDueDate(newTask.getDueDate());
			task.setAssignee(newTask.getAssignee());
			Task update = repository.save(task);
			return ResponseEntity.ok(update);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}