//package com.codestates.stackoverflow.config.oauth;
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@RequiredArgsConstructor
//@Component
//public class MyLoginSuccessHandler implements AuthenticationSuccessHandler{
//    @Value("${google.redirect-uri}")
//    private String redirectUrl;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        response.sendRedirect(redirectUrl);
//    }
//}
