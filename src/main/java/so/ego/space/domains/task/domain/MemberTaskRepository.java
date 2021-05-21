package so.ego.space.domains.task.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberTaskRepository {

    private final EntityManager em;
}
