package com.codestates.stackoverflow.config;

import com.codestates.stackoverflow.config.oauth.MyLoginSuccessHandler;
import com.codestates.stackoverflow.config.oauth.OAuth2UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultSecurityFilterChain;


@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private final OAuth2UserInfoService oAuth2UserInfoService;

    private final AuthenticationEntryPoint authenticationEntryPoint;

    private final MyLoginSuccessHandler myLoginSuccessHandler;


    @Bean
    protected DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
                .cors().and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/","/css/**","/js/**","h2-console/**","/profile").permitAll()
                        .antMatchers(
                                "/v2/api-docs",  "/configuration/ui",
                                "/swagger-resources", "/swagger-resources/**", "/configuration/security",
                                "/swagger-ui.html", "/webjars/**","/swagger/**",
                                /* swagger v3 */
                                "/v3/api-docs/**",
                                "/swagger-ui/**").permitAll()
                        .antMatchers(HttpMethod.POST, "/api/v1/**").authenticated()
                        .antMatchers(HttpMethod.PUT, "/api/v1/**").authenticated()
                        .antMatchers(HttpMethod.DELETE, "/api/v1/**").authenticated()
                )
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .logout(logout -> logout
                        .logoutSuccessUrl("/"))
                .oauth2Login(oauth2Login -> oauth2Login
                        .userInfoEndpoint()
                        .userService(oAuth2UserInfoService)
                        .and()
                        .successHandler(myLoginSuccessHandler)
                );
        return http.build();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }
}
