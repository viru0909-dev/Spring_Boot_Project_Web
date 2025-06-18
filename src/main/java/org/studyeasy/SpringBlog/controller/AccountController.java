package org.studyeasy.SpringBlog.controller;

import java.security.Principal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.studyeasy.SpringBlog.models.Account;
import org.studyeasy.SpringBlog.services.AccountService;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String register(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "account_views/register";
    }

    @PostMapping("/register")
    public String register_user(@Valid @ModelAttribute Account account,BindingResult result){
        if(result.hasErrors()){
            return "account_views/register";
        }
        accountService.save(account);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "account_views/login";
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profile(Model model,Principal principal){
        String authUser = "email";
        if(principal != null){
           authUser = principal.getName(); 
        }
        Optional<Account> optionalAccount = accountService.findOneByEmail(authUser);
        if(optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            model.addAttribute("account",account);
            model.addAttribute("photo",account.getPhoto());
            return "account_views/profile";
        }else{
          return "redirect:/?error";
        }

    }

    @PostMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String post_profile(@Valid @ModelAttribute Account account, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            return "account_views/profile";
        }
        String authUser = "email";
        if(principal != null){
           authUser = principal.getName(); 
        }
        Optional<Account> optionalAccount = accountService.findOneByEmail(authUser);
        if(optionalAccount.isPresent()){
            Account account_by_id = accountService.findById(account.getId()).get();
            account_by_id.setAge(account.getAge());
            account_by_id.setDate_of_birth(account.getDate_of_birth());
            account_by_id.setFirstname(account.getFirstname());
            account_by_id.setGender(account.getGender());
            account_by_id.setLastname(account.getLastname());
            account_by_id.setPassword(account.getPassword());


            accountService.save(account_by_id);
            SecurityContextHolder.clearContext();
            return "redirect:/"; 
        }else{
            return "redirect:/?error";
        }
    }

    
}
