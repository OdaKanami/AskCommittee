/*
package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import config.UserDetailsServiceImpl;


@Configuration //設定ファイルだよ！宣言
@EnableWebMvc  //Spring-Securityを使えるようにするためのもの
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl UserDetailsService;
	
	//DBから取得したパスワードは暗号化されているため、フォームの値も暗号化
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login") //ログインページはコントローラを経由しないのでViewNameとの紐付けが必要
			.loginProcessingUrl("/signin") //フォームのSubmitURL、このURLへリクエストが送られると認証処理が実行される
			.usernameParameter("id") //リクエストパラメータのname属性を明示
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
		auth
			.inMemoryAuthentication()
			.withUser("id").password("{noop}password").roles("ID");
	}
	
}
*/