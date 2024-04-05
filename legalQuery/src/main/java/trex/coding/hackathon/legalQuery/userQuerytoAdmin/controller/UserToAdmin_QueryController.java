package trex.coding.hackathon.legalQuery.userQuerytoAdmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import trex.coding.hackathon.legalQuery.userQuerytoAdmin.model.UserToAdmin_QueryModel;
import trex.coding.hackathon.legalQuery.userQuerytoAdmin.service.UserToAdmin_QueryService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value ="/api/v1/user")
public class UserToAdmin_QueryController {
    @Autowired
    private UserToAdmin_QueryService service;

    @Qualifier("asyncExecutor")
    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;


    @PostMapping("/userQuery")
    @Async
    public CompletableFuture<ResponseEntity<?>>Query(@RequestBody UserToAdmin_QueryModel member){
        return service.registerQuery(member).thenApply(m -> {
            if (m != null ) {
                return ResponseEntity.ok().body(m);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()));
    }

    @GetMapping("/userQuery")
    @Async
    public CompletableFuture<ResponseEntity<UserToAdmin_QueryModel>> getQuery(){

        CompletableFuture<UserToAdmin_QueryModel> future = CompletableFuture.supplyAsync(() -> {
            // Here you can perform any necessary processing to prepare your data
            UserToAdmin_QueryModel user = new UserToAdmin_QueryModel();
            return user;
        }, asyncTaskExecutor);

        return future.thenApply(result -> ResponseEntity.ok().body(result))
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }
}
