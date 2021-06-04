package so.ego.space.domains.task.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.task.application.dto.*;
import so.ego.space.domains.task.damain.Task;
import so.ego.space.domains.task.damain.TaskRepository;
import so.ego.space.domains.task.damain.TaskStatus;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskFindService {

    private final TaskRepository taskRepository;

    //업무 상세 조회
    @Transactional
    public TaskFIndDetailResponse findOneTask(Long taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Invalid Task Index"));

        return TaskFIndDetailResponse.builder()
                .taskId(task.getId())
                .title(task.getTitle())
                .content(task.getContent())
                .status(task.getStatus())
                .start_date(task.getStart_date())
                .end_date(task.getEnd_date())
                .build();
    }

    //업무 리스트
    @Transactional
    public TaskFindResponse findAllTasks(Long projectId) {
        List<TODO> taskFindStatusTodo = new LinkedList<>();
        List<DOING> taskFindStatusDoing = new LinkedList<>();
        List<DONE> taskFindStatusDone = new LinkedList<>();

        List<Task> taskList = taskRepository.findByProjectId(projectId).orElseThrow(() -> new IllegalArgumentException("Invalid ProjectId Index"));

        for (Task task : taskList) {
            if(task.getStatus().equals(TaskStatus.TODO)){
                taskFindStatusTodo.add(TODO.builder()
                        .taskId(task.getId())
                        .content(task.getContent())
                        .title(task.getTitle())
                        .start_date(task.getStart_date())
                        .end_date(task.getEnd_date())
                        .status(task.getStatus())
                        .build());
            }
            if(task.getStatus().equals(TaskStatus.DOING)){
                taskFindStatusDoing.add(DOING.builder()
                        .taskId(task.getId())
                        .content(task.getContent())
                        .title(task.getTitle())
                        .start_date(task.getStart_date())
                        .end_date(task.getEnd_date())
                        .status(task.getStatus())
                        .build());
            }
            if(task.getStatus().equals(TaskStatus.DONE)){
                taskFindStatusDone.add(DONE.builder()
                        .taskId(task.getId())
                        .content(task.getContent())
                        .title(task.getTitle())
                        .start_date(task.getStart_date())
                        .end_date(task.getEnd_date())
                        .status(task.getStatus())
                        .build());
            }

        }
        return TaskFindResponse.builder().TODO(taskFindStatusTodo).DOING(taskFindStatusDoing).DONE(taskFindStatusDone).build();
    }

    //업무 검색
    @Transactional
    public List<TaskFIndDetailResponse> searchTask(String searchTaskTitle, Long projectId) {
        List<TaskFIndDetailResponse> taskFindResponseList = new LinkedList<>();
        List<Task> taskList = taskRepository.findByTitleIsContainingAndProjectId(searchTaskTitle, projectId);

        for (Task task : taskList) {
            taskFindResponseList.add(TaskFIndDetailResponse.builder()
                    .taskId(task.getId())
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
