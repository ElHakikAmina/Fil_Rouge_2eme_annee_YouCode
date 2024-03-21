package com.youcode.MonSupplier.controllers;

import com.youcode.MonSupplier.models.Dtos.CommentDto.CommentDto;
import com.youcode.MonSupplier.services.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getAllComments/{idProduct}")
    public Object getAllComments(@PathVariable Long idProduct){
        return commentService.getComments(idProduct);
    }
    @GetMapping("/getComment/{id}")
    public Object getComment(@PathVariable Long id){
         return commentService.ReadCommentById(id);
    }
    @PostMapping("/createComment")
    public Object createComment(@RequestBody CommentDto comment){
        return commentService.CreateComment(comment);
    }
    @PutMapping("/updateComment")
    public Object updateComment(@RequestBody CommentDto comment){
        return commentService.UpdateComment(comment);
    }
    @DeleteMapping("/deleteComment/{id}")
    public boolean deleteComment(@PathVariable Long id){
        return commentService.DeleteComment(id);
    }
}
