package com.SalesManager.Config;

import com.SalesManager.repository.NhanVienDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private NhanVienDetailsServiceImpl userDetailsService;

    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/api/**","/dangnhap").permitAll();
        http.authorizeRequests().antMatchers("/**").hasAuthority("nhanvien");
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/dangnhap");
        http.authorizeRequests().antMatchers("/resources/**").permitAll()
        .anyRequest().authenticated().and().formLogin()
			.loginProcessingUrl("/j_spring_security_login")
			.loginPage("/dangnhap")
			.defaultSuccessUrl("/dashboard?message=LoginSuccess")
			.failureUrl("/dangnhap?message=error")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/dangnhap?message=logout");
    }

}
