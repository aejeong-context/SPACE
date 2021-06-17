package so.ego.space.domains.task.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.domain.MeetingTask;
import so.ego.space.domains.meeting.domain.MeetingTaskRepository;
import so.ego.space.domains.task.damain.MemberTask;
import so.ego.space.domains.task.damain.MemberTaskRepository;
import so.ego.space.domains.task.damain.Task;
import so.ego.space.domains.task.damain.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskDeleteService {

    private final TaskRepository taskRepository;
    private final MeetingTaskRepository meetingTaskRepository;
    private final MemberTaskRepository memberTaskRepository;

    //업무삭제
    @Transactional
    public void deleteTask(Long taskId){
        List<MeetingTask> meetingTasks = meetingTaskRepository.findByTaskId(taskId);
        meetingTaskRepository.deleteAll(meetingTasks);
        List<MemberTask> memberTasks = memberTaskRepository.findByTaskId(taskId);
        memberTaskRepository.deleteAll(memberTasks);
        Task task =  taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Invalid Task Index"));
        taskRepository.delete(task);
    }

}
