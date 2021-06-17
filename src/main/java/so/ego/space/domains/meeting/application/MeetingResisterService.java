package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.application.dto.MeetingResisterRequest;
import so.ego.space.domains.meeting.domain.MeetingRepository;
import so.ego.space.domains.meeting.domain.Meeting;
import so.ego.space.domains.meeting.domain.MeetingCheckType;
import so.ego.space.domains.project.domain.Project;
import so.ego.space.domains.project.domain.ProjectRepository;

@Service
@RequiredArgsConstructor
public class MeetingResisterService {

    private final MeetingRepository meetingRepository;


    private final ProjectRepository projectRepository;

    //회의 생성
    @Transactional
    public void resisterMeeting(MeetingResisterRequest meetingResisterRequest){

         Project project = projectRepository.findById(meetingResisterRequest.getProjectId()).orElseThrow(() -> new IllegalArgumentException("Invalid projectId Index"));

         meetingRepository.save(Meeting.builder()
                 .project(project)
                 .check(MeetingCheckType.SCHEDULE)
                 .name(meetingResisterRequest.getName())
                 .goal(meetingResisterRequest.getGoal())
                 .start_time(meetingResisterRequest.getStart_time())
                 .end_time(meetingResisterRequest.getEnd_time())
                 .build());
    }
}
