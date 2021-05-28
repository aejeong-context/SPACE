package so.ego.space.domains.meeting.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.meeting.domain.MeetingTaskType;

@Getter
@Builder
@AllArgsConstructor
public class MeetingTaskFindResponse {
    private MeetingTaskType type;
}
