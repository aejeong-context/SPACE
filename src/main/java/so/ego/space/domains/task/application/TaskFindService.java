package so.ego.space.domains.task.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.task.application.dto.TaskFindResponse;
import so.ego.space.domains.task.damain.Task;
import so.ego.space.domains.task.damain.TaskRepository;

import java.util.LinkedList;
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
                .title(task.getTitle())
                .content(task.getContent())
                .status(task.getStatus())
                .start_date(task.getStart_date())
                .end_date(task.getEnd_date())
                .build();
    }

    //업무 리스트
    @Transactional
    public List<TaskFindResponse> findAllTasks(Long projectId) {
        List<TaskFindResponse> taskFindResponseList = new LinkedList<>();

        List<Task> taskList = taskRepository.findByProjectId(projectId).orElseThrow(() -> new IllegalArgumentException("Invalid ProjectId Index"));
        for (Task task : taskList) {
            taskFindResponseList.add(TaskFindResponse.builder()
                    .title(task.getTitle())
                    .content(task.getContent())
                    .status(task.getStatus())
                    .start_date(task.getStart_date())
                    .end_date(task.getEnd_date())
                    .build());
        }
        return taskFindResponseList;
    }

    //업무 검색
    @Transactional
    public List<TaskFindResponse> searchTask(String searchTaskTitle, Long projectId) {
        List<TaskFindResponse> taskFindResponseList = new LinkedList<>();
        List<Task> taskList = taskRepository.findByTitleIsContainingAndProjectId(searchTaskTitle, projectId);

        for (Task task : taskList) {
            taskFindResponseList.add(TaskFindResponse.builder()
                    .title(task.getTitle())
                    .content(task.getContent())
                    .status(task.getStatus())
                    .start_date(task.getStart_date())
                    .end_date(task.getEnd_date())
                    .build());
        }
        return taskFindResponseList;
    }
}
