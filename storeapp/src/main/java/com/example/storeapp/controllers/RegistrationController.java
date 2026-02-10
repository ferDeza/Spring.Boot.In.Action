package com.example.storeapp.controllers;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.example.storeapp.models.RegistrationForm;
import com.example.storeapp.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping
    public String registrationForm(Model model) {
        model.addAttribute("user",new RegistrationForm());
        return "registration";
    }
    @PostMapping
    public String processRegistration(@Valid RegistrationForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        if(userRepository.findByUsername(form.getUsername()).isPresent()) {
            bindingResult.rejectValue("username","error.user", "username.exists");
        }
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
