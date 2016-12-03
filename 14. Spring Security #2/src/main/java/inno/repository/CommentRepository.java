package inno.repository;

import inno.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAll();

    Comment findOne(Long id);

    boolean add(Comment comment);

    boolean remove(Long id);

    List<Comment> findByPostId(Long postId);
    
}
