package com.web.board.config.memberSercurity;

import com.web.board.construct.eum.Role;
import com.web.board.config.memberSercurity.dto.MemberDTO;
import com.web.board.controller.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String homeView(Model model, Pageable pageable){
        itemService.getItemList(model, pageable);
        return "pages/home";
    }

    @GetMapping("/login")
    public String loginView() {
        return "pages/login";
    }

    @GetMapping("/signup")
    public String signupView() {
        return "pages/signup";
    }

    @PostMapping("/signup")
    public String signup(MemberDTO memberTO) {
        memberTO.setRole(Role.ROLE_USER);
        memberService.save(memberTO);
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/member/info")
    public String userInfoView() {
        return "pages/user_info";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminView() {
        return "pages/admin";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "pages/denied";
    }

}
