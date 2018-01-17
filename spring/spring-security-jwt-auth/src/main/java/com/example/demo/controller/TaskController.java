package com.example.demo.controller;

import java.util.List;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TaskRepository;
import com.example.demo.model.Task;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private TaskRepository taskRepository;

	public TaskController(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}
	
	@GetMapping
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}

	@PostMapping
	public Task addTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}

	@PutMapping("/{id}")
	public Task updateTask(@RequestBody Task task, @PathVariable long id) {
		Task existingTask = taskRepository.findOne(id);
		Assert.notNull(existingTask, "Task unavailable");
		existingTask.setDescription(task.getDescription());
		return taskRepository.save(existingTask);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable long id) {
		taskRepository.delete(id);
	}

}
