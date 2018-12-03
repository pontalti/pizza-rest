package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.security.JwtAuthEntryPoint;
import com.security.JwtAuthTokenFilter;
import com.service.JwtUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtAuthTokenFilter authenticationTokenFilter;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.route.auth.path}")
    private String authenticationPath;
	
	public WebConfig() {
		super();
	}

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(this.jwtUserDetailsService)
            .passwordEncoder(passwordEncoderBean());
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
           	.csrf().disable()
            .exceptionHandling().authenticationEntryPoint(this.unauthorizedHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()

            .antMatchers("/auth/**").permitAll()
            .anyRequest().authenticated();
       httpSecurity
            .addFilterBefore(this.authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        httpSecurity
            .headers()
            .frameOptions().sameOrigin()
            .cacheControl();
    }
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers(
                HttpMethod.POST,
                this.authenticationPath
            )
            .and()
            .ignoring()
            .antMatchers(
                HttpMethod.GET,
                "/",
                "/*.html",
                "/*.jsp",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.jsp",
                "/**/*.css",
                "/**/*.js"
            );
    }

}
