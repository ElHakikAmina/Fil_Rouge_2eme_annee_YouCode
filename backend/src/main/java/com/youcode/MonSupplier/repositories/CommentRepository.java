package com.youcode.MonSupplier.repositories;

import com.youcode.MonSupplier.models.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByProduct_Id(Long idProduct);
}
