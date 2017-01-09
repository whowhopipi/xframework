package com.xframework.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.xframework.boot.security.properties.XframeworkSecurityProperties;

@Configuration
@ComponentScan
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(XframeworkSecurityProperties.class)
public class XframeworkSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private XframeworkSecurityProperties properties;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/", true).and()
				.logout().logoutUrl("/logout");

		http.authorizeRequests().antMatchers("/**").permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/res/**", "/**/favicon.ico");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("admin").password("123456").roles("admin",
		// "user");
		super.configure(auth);
	}
}
