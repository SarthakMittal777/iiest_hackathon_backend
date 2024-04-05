package trex.coding.hackathon.legalQuery.SpecialistTouserReplyQuery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trex.coding.hackathon.legalQuery.SpecialistTouserReplyQuery.model.SpecialistReplyToUserModel;

@Repository
public interface SpecialistReplyToUserRepository extends JpaRepository<SpecialistReplyToUserModel, Long> {
}
