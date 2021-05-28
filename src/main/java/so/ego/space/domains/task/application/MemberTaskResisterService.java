package so.ego.space.domains.task.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.domain.Meeting;
import so.ego.space.domains.project.domain.Member;
import so.ego.space.domains.project.domain.MemberRepository;
import so.ego.space.domains.project.domain.ProjectRepository;
import so.ego.space.domains.task.application.dto.MemberTaskResisterRequest;
import so.ego.space.domains.task.damain.MemberTask;
import so.ego.space.domains.task.damain.MemberTaskRepository;
import so.ego.space.domains.task.damain.Task;
import so.ego.space.domains.task.damain.TaskRepository;

@Service
@RequiredArgsConstructor
public class MemberTaskResisterService {

    private final MemberTaskRepository memberTaskRepository;
    private final MemberRepository memberRepository;
    private final TaskRepository taskRepository;

    //업무 담당자 등록
    @Transactional
    public void resisterMemberTask(MemberTaskResisterRequest memberTaskResisterRequest){

        Member member = memberRepository.findById(memberTaskResisterRequest.getMemberId()).orElseThrow(() -> new IllegalArgumentException("Invalid memberId Index"));
        Task task = taskRepository.findById(memberTaskResisterRequest.getTaskId()).orElseThrow(() -> new IllegalArgumentException("Invalid taskId Index"));
        memberTaskRepository.save(MemberTask.builder()
                .member(member)
                .task(task)
                .build());
    }

}
