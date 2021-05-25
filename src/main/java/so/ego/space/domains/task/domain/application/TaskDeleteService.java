package so.ego.space.domains.task.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.task.domain.damain.Task;
import so.ego.space.domains.task.domain.damain.TaskRepository;

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
