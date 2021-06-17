package so.ego.space.domains.task.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.task.damain.MemberTask;
import so.ego.space.domains.task.damain.MemberTaskRepository;

@Service
@RequiredArgsConstructor
public class MemberTaskDeleteService {


    private final MemberTaskRepository memberTaskRepository;

    //업무 담당자 제외
    @Transactional
    public void delMemberTask(Long memberTaskId){
        MemberTask memberTask = memberTaskRepository.findById(memberTaskId).orElseThrow(() -> new IllegalArgumentException("Invalid memberTaskId Index"));
        memberTaskRepository.delete(memberTask);
    }

}
