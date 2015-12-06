/**
 *
 */
package it.cs.capgas.web.core;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Class SecurityConfig
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	//@formatter:off
	// TODO: change with DB table
	// auth.inMemoryAuthentication().withUser("user").password("user123").roles("USER");
	// auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("ADMIN", "USER");
	// auth.inMemoryAuthentication().withUser("cons").password("cons123").roles("CONSUMER", "USER");
	// auth.inMemoryAuthentication().withUser("prod").password("prod123").roles("PRODUCER", "USER");
	// auth.inMemoryAuthentication().withUser("paolo").password("napoli").roles("PRODUCER", "CONSUMER", "ADMIN", "USER");

	// DB JDBC standard template USERS/AUTHORITIES
	// select * from (select email as username,password,1 as enabled from usr) where username=?"
	// select * from
	// (select u.email username, ur.authority AUTHORITY
	// from usr u, usr_role ur
	// where u.usr_id = ur.usr_id) where username = ? "
	auth.jdbcAuthentication()
		.dataSource(this.dataSource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.rolePrefix("ROLE_")
		.usersByUsernameQuery("select * from ("
			+ "select username,password,enabled "
			+ "from gas_user) "
			+ "where username = ?")
		.authoritiesByUsernameQuery("select * from "
			+ "(select us.username, gr.gid_alias as authority"
			+ " from gas_user us, gas_group gr"
			+ " where us.id = gr.user_id) "
			+ "where username = ?");
	//@formatter:on
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
	// exclude ZK actions
	web.ignoring().antMatchers("/zkau/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	// @formatter:off
        http

        	// access-denied-page: this is the page users will be
        	// redirected to when they try to access protected areas.
        	.exceptionHandling()
        		.accessDeniedPage( "/denied.zul" )
        		.and()

        	// The intercept-url configuration is where we specify what roles are allowed access to what areas.
        	// We specifically force the connection to https for all the pages, although it could be sufficient
        	// just on the login page. The access parameter is where the expressions are used to control which
        	// roles can access specific areas. One of the most important things is the order of the intercept-urls,
        	// the most catch-all type patterns should at the bottom of the list as the matches are executed
        	// in the order they are configured below. So /** (anyRequest()) should always be at the bottom of the list.
        	.authorizeRequests()
        		.antMatchers("/secure/admin/**" ).hasRole( "ADMIN" )
        		.antMatchers("/secure/cons/**" ).hasRole( "CONSUMER" )
        		.antMatchers("/secure/prod/**" ).hasRole( "PRODUCER" )
        		.antMatchers("/secure/**" ).hasRole("USER")
        		.anyRequest().permitAll()
        		.and()

        	// HTTP --> HTTPS
        	.requiresChannel()
        		.anyRequest().requiresSecure()
        		.and()

        	// This is where we configure our login form.
        	// login-page: the page that contains the login screen
        	// login-processing-url: this is the URL to which the login form should be submitted
        	// default-target-url: the URL to which the user will be redirected if they login successfully
        	// authentication-failure-url: the URL to which the user will be redirected if they fail login
        	// username-parameter: the name of the request parameter which contains the username
        	// password-parameter: the name of the request parameter which contains the password
        	.formLogin()
        		.loginPage( "/login.zul" )
        		.loginProcessingUrl( "/login" )
        		.defaultSuccessUrl( "/secure/index.zul" )
        		.failureUrl( "/login.zul?login_error=1" )
        		.usernameParameter( "j_username" )
        		.passwordParameter( "j_password" )
        		.and()

        	// This is where the logout page and process is configured. The logout-url is the URL to send
        	// the user to in order to logout, the logout-success-url is where they are taken if the logout
        	// is successful, and the delete-cookies and invalidate-session make sure that we clean up after logout
        	.logout()
        		.logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) )
        		.logoutSuccessUrl( "/index.zul" )
        		.deleteCookies( "JSESSIONID" )
        		.invalidateHttpSession( true )

        	// The session management is used to ensure the user only has one session. This isn't
        	// compulsory but can add some extra security to your application.
        	//
        	// .sessionManagement()
        	// 	.invalidSessionUrl( "/login?time=1" )
        	// 	.maximumSessions( 1 )
    	;
       	// @formatter:on
    }
}
