package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.dto.NewUpdateCommentDto;
import hack.fulldream.hackathonback.models.Update;
import hack.fulldream.hackathonback.models.UpdateComment;
import hack.fulldream.hackathonback.models.User;
import hack.fulldream.hackathonback.repository.UpdateCommentRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UpdateCommentService {
  public final UpdateCommentRepository updateCommentRepository;
  private final UpdateService updateService;
  private final UserService userService;


  public UpdateCommentService(UpdateCommentRepository updateCommentRepository, UpdateService updateService, UserService userService) {
    this.updateCommentRepository = updateCommentRepository;
      this.updateService = updateService;
      this.userService = userService;
  }

  public UpdateComment save(UpdateComment toSave) {
    return updateCommentRepository.save(toSave);
  }

  public List<UpdateComment> findAllUpdate() {
    return updateCommentRepository.findAll();
  }

  public List<UpdateComment> findByUpdateId(UUID update_id) {
    return updateCommentRepository.findByUpdateId(update_id);
  }

  public UpdateComment toUpdateComment(NewUpdateCommentDto updateCommentDto) {
    Optional<Update> update = updateService.findById(updateCommentDto.getUpdateId());
    Optional<User> user = userService.findUserById(updateCommentDto.getUserId());

    if (update.isPresent() && user.isPresent()) {
      UpdateComment updateComment = new UpdateComment();
      updateComment.setTime(updateCommentDto.getTime());
      updateComment.setValue(updateCommentDto.getValue());
      updateComment.setUpdate(update.get());
      updateComment.setUser(user.get());
      return updateComment;
    }
    return null;
  }
}
