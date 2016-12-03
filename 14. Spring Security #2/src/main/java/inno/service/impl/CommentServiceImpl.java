package inno.service.impl;

import inno.model.Comment;
import inno.model.Post;
import inno.model.User;
import inno.repository.CommentRepository;
import inno.repository.PostRepository;
import inno.security.SecurityUtils;
import inno.service.CommentService;
import inno.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository repository;

    @Transactional
    @Override
    public void saveComment(Comment comment) {
        User user = SecurityUtils.getCurrentUser();
        comment.setUser(user);
        repository.save(comment);
    }
}
