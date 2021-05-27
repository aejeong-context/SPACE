package so.ego.space.domains.task.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.project.domain.Project;
import so.ego.space.domains.project.domain.ProjectRepository;
import so.ego.space.domains.task.application.dto.TaskResisterRequest;
import so.ego.space.domains.task.damain.Task;
import so.ego.space.domains.task.damain.TaskRepository;
import so.ego.space.domains.task.damain.TaskStatus;

@Service
@RequiredArgsConstructor
public class TaskResisterService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public void resisterTask(TaskResisterRequest taskResisterRequest){
        Project project = Project.builder().name("TEST").build();
        projectRepository.save(project);

        taskRepository.save(Task.builder()
                .project(project)
                .title(taskResisterRequest.getTitle())
                .content(taskResisterRequest.getContent())
                .status(TaskStatus.TODO)
                .start_date(taskResisterRequest.getStart_date())
                .end_date(taskResisterRequest.getEnd_date())
                .build());

    }

}
