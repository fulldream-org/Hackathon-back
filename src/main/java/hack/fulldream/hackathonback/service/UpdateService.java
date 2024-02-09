package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Update;
import hack.fulldream.hackathonback.repository.UpdateRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
  public final UpdateRepository updateRepository;

  public UpdateService(UpdateRepository updateRepository) {
    this.updateRepository = updateRepository;
  }

  public Update save(Update toSave) {
    return updateRepository.save(toSave);
  }

  public List<Update> findAllUpdate() {
    return updateRepository.findAll();
  }

  public Optional<Update> deleteUpdate(UUID id) {
    Optional<Update> toDelete = updateRepository.findById(id);
    if (toDelete.isPresent()) {
      updateRepository.deleteById(id);
    }
    return toDelete;
  }
}
