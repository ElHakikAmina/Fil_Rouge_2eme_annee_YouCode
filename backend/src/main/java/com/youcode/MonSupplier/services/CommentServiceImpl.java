package com.youcode.MonSupplier.services;

import com.youcode.MonSupplier.models.Dtos.CommentDto.CommentDto;
import com.youcode.MonSupplier.models.Entities.Comment;
import com.youcode.MonSupplier.repositories.CommentRepository;
import com.youcode.MonSupplier.services.interfaces.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<Comment> getCategories() {
        return commentRepository.findAll();
    }

    @Override
    public Comment CreateComment(CommentDto CategorieDto) {
        Comment comment = modelMapper.map(CategorieDto,Comment.class);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Optional<Comment> ReadCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment UpdateComment(CommentDto commentDto) {
        return commentDto.getId() != null ? CreateComment(commentDto) : null;
    }

    @Override
    public Boolean DeleteComment(Long id) {
        if (commentRepository.existsById(id)){
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
