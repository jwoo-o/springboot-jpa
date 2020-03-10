package com.jpa.admin.web;

import com.jpa.admin.config.auth.LoginUser;
import com.jpa.admin.config.auth.dto.SessionUser;
import com.jpa.admin.service.PostsService;
import com.jpa.admin.web.dto.PostsResposeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){

        model.addAttribute("posts",postsService.findAllDesc());

        if(user !=null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,Model model){

        PostsResposeDto dto = postsService.findById(id);
        model.addAttribute("posts",dto);
        return "posts-update";

    }
}
