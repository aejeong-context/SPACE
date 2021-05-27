package so.ego.space.domains.task.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.task.domain.application.dto.TaskUpdateContentRequest;
import so.ego.space.domains.task.domain.application.dto.TaskUpdateDateRequest;
import so.ego.space.domains.task.domain.application.dto.TaskUpdateStatusRequest;
import so.ego.space.domains.task.domain.damain.Task;
import so.ego.space.domains.task.domain.damain.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskUpdateService {

    private final TaskRepository taskRepository;

    //제목, 내용 변경
    @Transactional
    public void updateContent(TaskUpdateContentRequest taskUpdateContentRequest){
        Task task =  taskRepository.findById(taskUpdateContentRequest.getTaskId()).orElseThrow(() -> new IllegalArgumentException("Invalid Task Index"));
        task.updateTaskTitleContent(taskUpdateContentRequest.getTitle(),taskUpdateContentRequest.getContent());
    }

    //상태 변경
    @Transactional
    public void updateStatus(TaskUpdateStatusRequest taskUpdateStatusRequest){
        Task task =  taskRepository.findById(taskUpdateStatusRequest.getTaskId()).orElseThrow(() -> new IllegalArgumentException("Invalid Task Index"));
        task.updateTaskStatus(taskUpdateStatusRequest.getStatus());
    }

    //기간 변경
    @Transactional
    public void updateDate(TaskUpdateDateRequest taskUpdateDateRequest){
        Task task =  taskRepository.findById(taskUpdateDateRequest.getTaskId()).orElseThrow(() -> new IllegalArgumentException("Invalid Task Index"));
        task.updateTaskDate(taskUpdateDateRequest.getStart_date(), taskUpdateDateRequest.getEnd_date());
    }

}
