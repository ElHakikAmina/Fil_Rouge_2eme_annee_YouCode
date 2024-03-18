package com.youcode.MonSupplier.services.interfaces;

import com.youcode.MonSupplier.models.Dtos.CommentDto.CommentDto;
import com.youcode.MonSupplier.models.Entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getComments();

    Comment CreateComment(CommentDto commentDto);
    Optional<Comment> ReadCommentById(Long id);

    Comment UpdateComment(CommentDto commentDto);

    Boolean DeleteComment(Long id);
}
