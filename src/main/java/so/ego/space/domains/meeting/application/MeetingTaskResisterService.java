package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.meeting.domain.MeetingTaskRepository;

@Service
@RequiredArgsConstructor
public class MeetingTaskResisterService {

    private final MeetingTaskRepository meetingTaskRepository;


}
