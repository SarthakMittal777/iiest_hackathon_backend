package trex.coding.hackathon.legalQuery.adminQuerytoSpecialist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import trex.coding.hackathon.legalQuery.userQuerytoAdmin.model.UserToAdmin_QueryModel;
import trex.coding.hackathon.legalQuery.userQuerytoAdmin.repository.UserToAdmin_QueryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AdminToSpecialistQuaryService {
    @Autowired
    private UserToAdmin_QueryRepository userToAdmin_queryRepository;

    @Async
    public CompletableFuture<UserToAdmin_QueryModel> getQuery(String queryId) {
        return CompletableFuture.completedFuture(userToAdmin_queryRepository.findByQueryId(queryId).get());
    }

    @Async
    public CompletableFuture<List<UserToAdmin_QueryModel>> getQuery() {
        return CompletableFuture.completedFuture(userToAdmin_queryRepository.findAll());
    }

    @Async
    public CompletableFuture<List<UserToAdmin_QueryModel>> getQuery(Long id) {
       List<UserToAdmin_QueryModel>user= userToAdmin_queryRepository.findAll();
       List<UserToAdmin_QueryModel>usern=new ArrayList<>();
       for(UserToAdmin_QueryModel u:user){
           if(u.getSpecialistId()==id){
               usern.add(u);
           }
       }
       return CompletableFuture.completedFuture(usern);

    }

}
