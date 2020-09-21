package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

//Command Controller
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ImageService imageService;

    //for adding comments
    @RequestMapping(value="/image/{id}/{title}/comments", method=RequestMethod.POST)
    public String addComments(@PathVariable("id") Integer id, @PathVariable("title") String title, @RequestParam("comment") String text, HttpSession session){
        User user=(User)session.getAttribute("loggeduser");
        Image image=imageService.getImageByTitleandID(title,id);
        Comment newComment=new Comment();
        newComment.setImage(image);
        newComment.setText(text);
        newComment.setUser(user);
        commentService.addcomment(newComment);
        return "redirect:/images/" + id+"/"+title;
    }
}
