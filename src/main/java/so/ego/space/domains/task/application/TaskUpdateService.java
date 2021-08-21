package so.ego.space.domains.task.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.project.domain.Member;
import so.ego.space.domains.project.domain.MemberRepository;
import so.ego.space.domains.task.application.dto.TaskUpdateRequest;
import so.ego.space.domains.task.application.dto.TaskUpdateStatusRequest;
import so.ego.space.domains.task.application.dto.TaskUpdateContentRequest;
import so.ego.space.domains.task.application.dto.TaskUpdateDateRequest;
import so.ego.space.domains.task.damain.MemberTask;
import so.ego.space.domains.task.damain.MemberTaskRepository;
import so.ego.space.domains.task.damain.Task;
import so.ego.space.domains.task.damain.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskUpdateService {

    private final TaskRepository taskRepository;
    private final MemberTaskRepository memberTaskRepository;
    private final MemberRepository memberRepository;

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

    @Transactional
    public void updateTask(TaskUpdateRequest taskUpdateRequest) {
        Task task =  taskRepository.findById(taskUpdateRequest.getTaskId()).orElseThrow(() -> new IllegalArgumentException("Invalid Task Index"));
        task.updateTaskTitleContent(taskUpdateRequest.getTitle(),taskUpdateRequest.getContent());
        task.updateTaskDate(taskUpdateRequest.getStart_date(), taskUpdateRequest.getEnd_date());
        task.updateTaskStatus(taskUpdateRequest.getStatus());
        //담당자 모두 삭제
//        memberTaskRepository.deleteAll(memberTaskRepository.findByTaskId(taskUpdateRequest.getTaskId()));
        //담당자 입력
        if(taskUpdateRequest.getMemberIdList() != null) {
            for (Long id : taskUpdateRequest.getMemberIdList()) {
                Member m = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid MemberId Index"));
                memberTaskRepository.save(MemberTask.builder().member(m).task(task).build());
            }
        }

    }
}
