package trex.coding.hackathon.legalQuery.SpecialistTouserReplyQuery.Service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trex.coding.hackathon.legalQuery.SpecialistTouserReplyQuery.Repository.SpecialistReplyToUserRepository;
import trex.coding.hackathon.legalQuery.SpecialistTouserReplyQuery.model.SpecialistReplyToUserModel;
import trex.coding.hackathon.legalQuery.adminQuerytoSpecialist.service.AdminToSpecialistQuaryService;
import trex.coding.hackathon.legalQuery.userQuerytoAdmin.model.UserToAdmin_QueryModel;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class SpecialistReplyToUserService {

    @Autowired
    private SpecialistReplyToUserRepository specialistReplyToUserService;
    @Autowired
    private AdminToSpecialistQuaryService adminToSpecialistQuaryService;

    public CompletableFuture<SpecialistReplyToUserModel> savereply(String queryId,String specialistReply) throws ExecutionException, InterruptedException {
SpecialistReplyToUserModel specialistReplyToUserModel = new SpecialistReplyToUserModel();
      CompletableFuture<UserToAdmin_QueryModel> user  =adminToSpecialistQuaryService.getQuery(queryId);
        specialistReplyToUserModel.setUserToAdmin_queryModel(user.get());
        specialistReplyToUserModel.setSpecialistReply(specialistReply);
        return CompletableFuture.completedFuture(specialistReplyToUserService.save(specialistReplyToUserModel));
    }

    public CompletableFuture<SpecialistReplyToUserModel> getreply(Long id) {
        return CompletableFuture.completedFuture(specialistReplyToUserService.findById(id).get());
    }

    public CompletableFuture<List<SpecialistReplyToUserModel>> getallreply() {
        return CompletableFuture.completedFuture(specialistReplyToUserService.findAll());
    }
}
