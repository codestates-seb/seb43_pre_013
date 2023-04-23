package com.codestates.stackoverflow.config;

import com.codestates.stackoverflow.config.oauth.MyLoginSuccessHandler;
import com.codestates.stackoverflow.config.oauth.OAuth2UserInfoService;
import com.codestates.stackoverflow.user.model.Role;
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
    private final MyLoginSuccessHandler myLoginSuccessHandler;
    //private final AuthenticationEntryPoint authenticationEntryPoint;


    /*@Bean
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
                                *//* swagger v3 *//*
                                "/v3/api-docs/**",
                                "/swagger-ui/**").permitAll()
                        *//*.antMatchers(HttpMethod.POST, "/api/v1/**").authenticated()
                        .antMatchers(HttpMethod.PUT, "/api/v1/**").authenticated()
                        .antMatchers(HttpMethod.DELETE, "/api/v1/**").authenticated()*//*
                )
                *//*.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()*//*
                .logout(logout -> logout
                        .logoutSuccessUrl("/"))
                .oauth2Login(oauth2Login -> oauth2Login
                        .userInfoEndpoint()
                        .userService(oAuth2UserInfoService)
                        .and()
                        .successHandler(myLoginSuccessHandler)
                );
        return http.build();
    }*/


    @Bean
    protected DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()//csrf 공격을 막아주는 옵션을 disalbe, rest api같은 경우에는 브라우저를 통해 request 받지 않기 때문에 해당 옵션을 꺼도 됩니다.
                .cors()
                .and()
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/","/css/**","/js/**","h2-console/**","/profile").permitAll()
                        .antMatchers("/api/v1/**").hasRole(Role.GUEST.name()) // 엔드포인트는 유저 역할을 가진 사람만 허용가능
                )
                //.formLogin()
                //.loginPage("/login")
                //.defaultSuccessUrl("/")  //로그인 성공후 리다이렉트 주소dd
                //.logout(logout -> logout
                //        .logoutSuccessUrl("/logout")) //logout 요청시 홈으로 이동 - 기본 logout url = "/logout"
                .oauth2Login() //OAuth2 로그인 설정 시작점
                .userInfoEndpoint() //OAuth2 로그인 성공 이후 사용자 정보를 가져올 때 설정 담당
                .userService(oAuth2UserInfoService)
                .and()
                .successHandler(myLoginSuccessHandler); //OAuth2 로그인 성공 시, 작업을 진행할 MemberService

        return http.build();
    }

}
