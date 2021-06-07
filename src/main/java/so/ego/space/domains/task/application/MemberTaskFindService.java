package so.ego.space.domains.task.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.meeting.application.dto.MeetingTaskFindResponse;
import so.ego.space.domains.project.domain.Member;
import so.ego.space.domains.project.domain.MemberRepository;
import so.ego.space.domains.task.application.dto.MemberTaskFindResponse;
import so.ego.space.domains.task.damain.MemberTask;
import so.ego.space.domains.task.damain.MemberTaskRepository;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberTaskFindService {

    private final MemberTaskRepository memberTaskRepository;
    private final MemberRepository memberRepository;

    public List<MemberTaskFindResponse> findAllMemberTask(Long taskId){
        List<MemberTaskFindResponse> memberTaskFindResponses = new LinkedList<>();
        List<MemberTask> memberTaskList = memberTaskRepository.findByTaskId(taskId);

        for(MemberTask memberTask : memberTaskList){
            memberTaskFindResponses.add(MemberTaskFindResponse.builder()
                    .memberTaskId(memberTask.getId())
                    .taskId(memberTask.getTask().getId())
                    .memberId(memberTask.getMember().getId())
                    .level(memberTask.getMember().getLevel())
                    .nickname(memberTask.getMember().getUser().getNickname())
                    .profilePath(memberTask.getMember().getUser().getProfile().getPath())
                    .build());
        }


        return memberTaskFindResponses;
    }

}
