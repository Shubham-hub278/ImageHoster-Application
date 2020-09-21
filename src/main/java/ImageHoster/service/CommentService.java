package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Tag;
import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void addcomment(Comment newComment) {
        newComment.setCreateddate(new Date());
        commentRepository.createComment(newComment);
    }
}

