package ru.brazhnikov.launcher;

import javax.sql.DataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * SecurityConfig -
 *
 * @version 1.0.1
 * @package ru.brazhnikov.launcher
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( securedEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *  @access private
     *  @var DataSource myDataSource -
     */
    private DataSource myDataSource;

    /**
     * setMyDataSource -
     * @param myDataSource -
     * @return void
     */
    @Autowired
    public void setMyDataSource( DataSource myDataSource ) {
        this.myDataSource = myDataSource;
    }

    /**
     * configure -
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth.jdbcAuthentication().dataSource( this.myDataSource );
    }

    /**
     * configure -
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure( HttpSecurity http ) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").anonymous()
                .antMatchers("/").hasAnyRole("ADMIN", "USER", "MANAGER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/")
                // .failureUrl("/ohSh")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
