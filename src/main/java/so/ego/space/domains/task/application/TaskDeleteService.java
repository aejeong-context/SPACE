package so.ego.space.domains.task.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.task.damain.Task;
import so.ego.space.domains.task.damain.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskDeleteService {

    private final TaskRepository taskRepository;

    @Transactional
    public void deleteTask(Long taskId){
        Task task =  taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Invalid Task Index"));
        taskRepository.delete(task);
    }

}
