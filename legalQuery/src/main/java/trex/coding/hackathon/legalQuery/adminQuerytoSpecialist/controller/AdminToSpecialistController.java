package trex.coding.hackathon.legalQuery.adminQuerytoSpecialist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trex.coding.hackathon.legalQuery.adminQuerytoSpecialist.service.AdminToSpecialistQuaryService;
import trex.coding.hackathon.legalQuery.userQuerytoAdmin.model.UserToAdmin_QueryModel;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value ="/api/v1/admin")
public class AdminToSpecialistController {

    @Autowired
    private AdminToSpecialistQuaryService adminToSpecialistService;

    @GetMapping("/adminquerie/{queryId}")
    @Async
    public CompletableFuture<ResponseEntity<?>> getQuery(@PathVariable String queryId){
        return adminToSpecialistService.getQuery(queryId)
         .thenApply(m -> {
            if (m != null ) {
                return ResponseEntity.ok().body(m);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()));
    }

    @GetMapping("/adminquerie/all")
    @Async
    public CompletableFuture<ResponseEntity<List<UserToAdmin_QueryModel>>> getQuery(){
        return adminToSpecialistService.getQuery().thenApply(result -> ResponseEntity.ok().body(result))
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

    @GetMapping("/adminquerie/specialist/{SpecialistId}")
    @Async
    public CompletableFuture<ResponseEntity<List<UserToAdmin_QueryModel>>> getQuery(@PathVariable Long SpecialistId){
        return adminToSpecialistService.getQuery(SpecialistId).thenApply(result -> ResponseEntity.ok().body(result))
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }
}
