package com.tacademy.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private LoginUserDetailsService userDetailsService;


  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/resources/**","/public/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers("/admin/login", "/join/**", "/admin/logout").permitAll()
        .antMatchers("/admin/**").hasAnyAuthority(Authorities.ADMIN)
        .antMatchers("/cart/**", "/order/**").hasAnyAuthority(Authorities.USER)
        .and()
      .formLogin()
        .loginPage("/admin/login")
        .usernameParameter("j_username")
        .passwordParameter("j_password")
        .loginProcessingUrl("/j_security_check")
        .defaultSuccessUrl("/admin/product/list")
        .failureUrl("/admin/login?error=true")
        .and()
      .csrf().disable();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
