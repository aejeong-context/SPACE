package so.ego.space.domains.meeting.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.meeting.domain.application.dto.MeetingTaskResisterRequest;
import so.ego.space.domains.meeting.domain.domain.MeetingTask;
import so.ego.space.domains.meeting.domain.domain.MeetingTaskRepository;
import so.ego.space.domains.meeting.domain.domain.MeetingTaskType;

@Service
@RequiredArgsConstructor
public class MeetingTaskResisterService {

    private final MeetingTaskRepository meetingTaskRepository;

    public void resisterMeetingTask( meetingTaskResisterRequest){

        meetingTaskRepository.save(MeetingTask.builder()
                .meeting(meetingTaskResisterRequest.getMeetingId())
                .task(meetingTaskResisterRequest.getTaskId())
                .type(MeetingTaskType.AGENDA)
                .build());
    }

}
