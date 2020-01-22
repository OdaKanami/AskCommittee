package com.ask.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ask.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	//フォームの値と比較するDBから取得したパスワードは暗号化されているのでフォームの値も暗号化
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                            "/images/**",
                            "/css/**",
                            "/javascript/**"
                            );
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .authorizeRequests()
	    		.antMatchers("/register").permitAll()
	    		.antMatchers("/withdraw").permitAll()			    
		        .anyRequest().authenticated()
		        .and()
		    .formLogin()
		        .loginPage("/login") //ログインページはコントローラを経由しないのでViewNameとの紐付けが必要
		        .loginProcessingUrl("/top") //フォームのSubmitURL、このURLへリクエストが送られると認証処理が実行される
		        .usernameParameter("username") //リクエストパラメータのname属性を明示
		        .passwordParameter("password")
		        .successForwardUrl("/top")
		        .failureUrl("/login?error")
		        .permitAll()
		        .and()
		    .logout()
		        .logoutUrl("/logout")
		        .logoutSuccessUrl("/login?logout")
		        .permitAll();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
//		auth
//		    .inMemoryAuthentication()
//		        .withUser("user").password("{noop}password").roles("USER");	
	}

}
