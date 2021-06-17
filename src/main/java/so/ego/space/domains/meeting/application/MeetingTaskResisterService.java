package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.application.dto.MeetingTaskResisterRequest;
import so.ego.space.domains.meeting.domain.Meeting;
import so.ego.space.domains.meeting.domain.MeetingRepository;
import so.ego.space.domains.meeting.domain.MeetingTask;
import so.ego.space.domains.meeting.domain.MeetingTaskRepository;
import so.ego.space.domains.task.damain.Task;
import so.ego.space.domains.task.damain.TaskRepository;

@Service
@RequiredArgsConstructor
public class MeetingTaskResisterService {

    private final MeetingTaskRepository meetingTaskRepository;
    private final MeetingRepository meetingRepository;
    private final TaskRepository taskRepository;

    //업무참조 생성
    @Transactional
    public void resisterMeetingTask(MeetingTaskResisterRequest meetingTaskResisterRequest){

        Meeting meeting = meetingRepository.findById(meetingTaskResisterRequest.getMeetingId()).orElseThrow(() -> new IllegalArgumentException("Invalid meetingId Index"));
        Task task = taskRepository.findById(meetingTaskResisterRequest.getTaskId()).orElseThrow(() -> new IllegalArgumentException("Invalid taskId Index"));
        meetingTaskRepository.save(MeetingTask.builder()
                .meeting(meeting)
                .task(task)
                .type(meetingTaskResisterRequest.getType())
                .build());
    }


}
