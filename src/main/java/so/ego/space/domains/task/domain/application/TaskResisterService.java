package so.ego.space.domains.task.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.project.domain.domain.Project;
import so.ego.space.domains.project.domain.domain.ProjectRepository;
import so.ego.space.domains.task.domain.application.dto.TaskResisterRequest;
import so.ego.space.domains.task.domain.damain.Task;
import so.ego.space.domains.task.domain.damain.TaskRepository;
import so.ego.space.domains.task.domain.damain.TaskStatus;

import java.time.LocalDate;

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
                .content(taskResisterRequest.getContent())
                .status(TaskStatus.TODO)
                .start_date(taskResisterRequest.getStart_date())
                .end_date(taskResisterRequest.getEnd_date())
                .build());

    }

}
