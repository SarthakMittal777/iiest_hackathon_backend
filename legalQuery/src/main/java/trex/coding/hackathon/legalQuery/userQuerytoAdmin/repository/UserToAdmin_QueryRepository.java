package trex.coding.hackathon.legalQuery.userQuerytoAdmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trex.coding.hackathon.legalQuery.userQuerytoAdmin.model.UserToAdmin_QueryModel;

import java.util.Optional;

@Repository
public interface UserToAdmin_QueryRepository extends JpaRepository<UserToAdmin_QueryModel, Long> {


    Optional<UserToAdmin_QueryModel> findByQueryId(String queryId);
}
