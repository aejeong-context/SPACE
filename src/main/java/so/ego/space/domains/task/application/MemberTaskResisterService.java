package so.ego.space.domains.task.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.project.domain.ProjectRepository;
import so.ego.space.domains.task.application.dto.MemberTaskRequest;
import so.ego.space.domains.task.damain.MemberTaskRepository;
import so.ego.space.domains.task.damain.TaskRepository;

@Service
@RequiredArgsConstructor
public class MemberTaskResisterService {

    private final MemberTaskRepository memberTaskRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public void resisterMemberTask(MemberTaskRequest memberTaskRequest){

    }

}
