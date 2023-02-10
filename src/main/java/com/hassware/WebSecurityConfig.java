package com.hassware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // Users and passwords definition ( in memory)
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("Admin")
                .password("{noop}123")
                .roles("ADMIN")
                .build();
        UserDetails user2 = User
                .withUsername("Andres")
                .password("{noop}456")
                .roles("SALES")
                .build();
        UserDetails user3 = User
                .withUsername("Juan")
                .password("{noop}789")
                .roles("STORAGE")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }


    // Access authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().defaultSuccessUrl("/home.html", true);
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home.html").permitAll()
                .antMatchers("/img/*").permitAll()
                .antMatchers("/orderform/*", "/deleteorder/*").hasRole("ADMIN")
                .antMatchers("/productform/*", "/deleteproduct/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("static/**");
    }

}
