package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.UpdateComment;
import hack.fulldream.hackathonback.repository.UpdateCommentRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UpdateCommentService {
  public final UpdateCommentRepository updateCommentRepository;

  public UpdateCommentService(UpdateCommentRepository updateCommentRepository) {
    this.updateCommentRepository = updateCommentRepository;
  }

  public UpdateComment save(UpdateComment toSave) {
    return updateCommentRepository.save(toSave);
  }

  public List<UpdateComment> findAllUpdate() {
    return updateCommentRepository.findAll();
  }

  public UpdateComment updateUpdate(UUID id) {
    return updateCommentRepository.updateById(id);
  }
}
