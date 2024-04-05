package trex.coding.hackathon.legalQuery.userQuerytoAdmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import trex.coding.hackathon.legalQuery.userQuerytoAdmin.model.UserToAdmin_QueryModel;
import trex.coding.hackathon.legalQuery.userQuerytoAdmin.repository.UserToAdmin_QueryRepository;

import java.util.concurrent.CompletableFuture;

@Service
public class UserToAdmin_QueryService {

    @Autowired
    private UserToAdmin_QueryRepository Repository;
    @Async
    public CompletableFuture<UserToAdmin_QueryModel> registerQuery(UserToAdmin_QueryModel member) {
        CompletableFuture<UserToAdmin_QueryModel> mrd = CompletableFuture.completedFuture(Repository.save(member));
        member.setQueryId("legal" + member.getId() + "query" + member.getId() + "0242024");
        Repository.save(member);
        return mrd;

    }
}
