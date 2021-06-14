package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.application.dto.MeetingTaskFindByMeetingIdResponse;
import so.ego.space.domains.meeting.application.dto.MeetingTaskFindByTaskIdResponse;
import so.ego.space.domains.meeting.domain.MeetingRepository;
import so.ego.space.domains.meeting.domain.MeetingTask;
import so.ego.space.domains.meeting.domain.MeetingTaskRepository;
import so.ego.space.domains.task.damain.TaskRepository;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingTaskFindService {

    private final MeetingTaskRepository meetingTaskRepository;
    private final MeetingRepository meetingRepository;
    private final TaskRepository taskRepository;

    //업무참조 상세보기(회의아이디)
    @Transactional
    public List<MeetingTaskFindByMeetingIdResponse> findOneMeetingId(Long meetingId){
        List<MeetingTaskFindByMeetingIdResponse> meetingTaskFindByMeetingIdResponseList = new LinkedList<>();
        List<MeetingTask> meetingTaskList = meetingTaskRepository.findByMeetingId(meetingId);
        for(MeetingTask meetingTask : meetingTaskList){
            meetingTaskFindByMeetingIdResponseList.add(MeetingTaskFindByMeetingIdResponse.builder()
                    .meetingId(meetingTask.getMeeting().getId())
                    .type(meetingTask.getType())
                    .taskId(meetingTask.getTask().getId())
                    .taskTitle(meetingTask.getTask().getTitle())
                    .taskContent(meetingTask.getTask().getContent())
                    .taskType(meetingTask.getTask().getStatus())
                    .taskStart_date(meetingTask.getTask().getStart_date())
                    .taskEnd_date(meetingTask.getTask().getEnd_date())
                    .meetingTaskId(meetingTask.getId())
                    .build());
        }
        return meetingTaskFindByMeetingIdResponseList;
    }

    //업무참조 상세보기(업무아이디)
    @Transactional
    public List<MeetingTaskFindByTaskIdResponse> findOneTaskId(Long taskId){
        List<MeetingTaskFindByTaskIdResponse> meetingTaskFindByTaskIdResponseList = new LinkedList<>();
        List<MeetingTask> meetingTaskList = meetingTaskRepository.findByTaskId(taskId);
        for(MeetingTask meetingTask : meetingTaskList){
            meetingTaskFindByTaskIdResponseList.add(MeetingTaskFindByTaskIdResponse.builder()
                    .taskId(meetingTask.getTask().getId())
                    .type(meetingTask.getType())
                    .meetingId(meetingTask.getMeeting().getId())
                    .meetingName(meetingTask.getMeeting().getName())
                    .meetingGoal(meetingTask.getMeeting().getGoal())
                    .meetingCheckType(meetingTask.getMeeting().getCheck())
                    .meetingStart_date(meetingTask.getMeeting().getStart_time())
                    .meetingEnd_date(meetingTask.getMeeting().getEnd_time())
                    .meetingTaskId(meetingTask.getId())
                    .build());
        }
        return meetingTaskFindByTaskIdResponseList;
    }




}
