package ua.kiev.prog.oauth2.loginviagoogle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private static String authorizationRequestBaseUri = "oauth2/authorization";

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @GetMapping("/oauth_login")
    public String getLoginPage(Model model) {
        ClientRegistration clientRegistrationGoogle = clientRegistrationRepository
                .findByRegistrationId("google");

        ClientRegistration clientRegistrationFacebook = clientRegistrationRepository
                .findByRegistrationId("facebook");


        model.addAttribute("name_google", clientRegistrationGoogle.getClientName());
        model.addAttribute("url_google", authorizationRequestBaseUri + "/" +
                clientRegistrationGoogle.getRegistrationId());

        model.addAttribute("name_facebook", clientRegistrationFacebook.getClientName());
        model.addAttribute("url_facebook", authorizationRequestBaseUri + "/" +
                clientRegistrationFacebook.getRegistrationId());


        return "oauth_login";
    }
}
