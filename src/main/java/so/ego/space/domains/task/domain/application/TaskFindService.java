package so.ego.space.domains.task.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.task.domain.application.dto.TaskFindResponse;
import so.ego.space.domains.task.domain.damain.Task;
import so.ego.space.domains.task.domain.damain.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskFindService {

    private final TaskRepository taskRepository;

    //업무 상세 조회
    @Transactional
    public TaskFindResponse findOneTask(Long taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Invalid Task Index"));

        return TaskFindResponse.builder()
                .content(task.getContent())
                .status(task.getStatus())
                .start_date(task.getStart_date())
                .end_date(task.getEnd_date())
                .build();
    }

    public List<TaskFindResponse> findAllTasks(Long projectId){
        TaskFindResponse taskFindResponse = new Link
    }

}
