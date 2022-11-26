package com.nikitoe.board.config;

import com.nikitoe.board.config.auth.PrincipalDetailService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration // Bean 등록
@EnableWebSecurity // Security filter 추가
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationFailureHandler customFailureHandler;
    private final PrincipalDetailService principalDetailService;

    private static final String[] PERMIT_URL_ARRAY = {
        "/", "/auth/**", "/js/**", "/css/**", "/image/**", "/dummy/**",
        "/h2-console/**"
    };

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 시큐리티가 대신 로그인해 주는데 비밀번호 해쉬 비교를 위한 로직
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin();
        http.csrf()
            .disable()// csrf token disable -> form tag를 이용해서 요청이 아닌 ajax call에 토큰이 없어서 block당함
            .authorizeRequests()// 특정 경로에 권한을 가진 사용자만 접근 가능
            .antMatchers(PERMIT_URL_ARRAY)
            .permitAll()
            .anyRequest()// 이외 모든 요청
            .authenticated()// 인증 필요

            .and()
            .formLogin()
            .loginPage("/auth/loginForm")
            .loginProcessingUrl("/auth/loginProc")
            .defaultSuccessUrl("/")
            .failureHandler(customFailureHandler) // 로그인 실패 핸들러

            .and()
            .logout()

            .and()
            .userDetailsService(principalDetailService);
    }
}
