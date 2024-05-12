package com.example.final_api.Services;

import com.example.final_api.Exception.ResourceNotFoundException;
import com.example.final_api.Model.Task;
import com.example.final_api.Repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {

    private TaskRepo taskRepository;

    @Autowired
    public TaskService(TaskRepo taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("task not found"));
    }

    public List<Task> getTasksByCourseId(Integer courseId) {
        return taskRepository.findByCourseCourseId(courseId);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Integer id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task does not exist with id : " + id));

        task.setTitle(taskDetails.getTitle());
        task.setDeadline(taskDetails.getDeadline());
        task.setType(taskDetails.getType());

        return taskRepository.save(task);
    }

    public Map<String, Boolean> deleteTask(Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not found."));

        taskRepository.delete(task);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}