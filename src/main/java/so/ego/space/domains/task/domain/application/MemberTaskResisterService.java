package so.ego.space.domains.task.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.project.domain.domain.Member;
import so.ego.space.domains.project.domain.domain.ProjectRepository;
import so.ego.space.domains.task.domain.application.dto.MemberTaskRequest;
import so.ego.space.domains.task.domain.damain.MemberTask;
import so.ego.space.domains.task.domain.damain.MemberTaskRepository;
import so.ego.space.domains.task.domain.damain.Task;
import so.ego.space.domains.task.domain.damain.TaskRepository;

@Service
@RequiredArgsConstructor
public class MemberTaskResisterService {

    private final MemberTaskRepository memberTaskRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public void resisterMemberTask(MemberTaskRequest memberTaskRequest){

    }

}
