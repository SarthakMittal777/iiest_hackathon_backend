package trex.coding.hackathon.legalQuery.SpecialistTouserReplyQuery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import trex.coding.hackathon.legalQuery.SpecialistTouserReplyQuery.Service.SpecialistReplyToUserService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/specialist/reply")
public class SpecialistReplyToUserController {

    @Autowired
    private SpecialistReplyToUserService specialistReplyToUserService;

    @PostMapping("/save/{queryId}")
    @Async
    public CompletableFuture<ResponseEntity<?>> saveReply(@RequestParam(value = "queryId") String queryId, @RequestBody String specialistReply) throws ExecutionException, InterruptedException {
             return specialistReplyToUserService.savereply(queryId,specialistReply).thenApply(r -> {
            if (r != null ) {
                return ResponseEntity.ok().body(r);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()));
    }

    @GetMapping("/get/{id}")
    @Async
    public CompletableFuture<ResponseEntity<?>> getReply(@PathVariable(value = "id") Long id) {
        return specialistReplyToUserService.getreply(id).thenApply(r -> {
            if (r != null) {
                return ResponseEntity.ok().body(r);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

    @GetMapping("/get/all")
    @Async
    public CompletableFuture<ResponseEntity<?>> getAllReply() {
        return specialistReplyToUserService.getallreply().thenApply(r -> {
            if (r != null) {
                return ResponseEntity.ok().body(r);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }
}
