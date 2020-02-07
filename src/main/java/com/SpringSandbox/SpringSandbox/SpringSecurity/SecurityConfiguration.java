package com.SpringSandbox.SpringSandbox.SpringSecurity;
//https://www.youtube.com/watch?v=iyXne7dIn7U&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE&index=4

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//Hard Coded Authentication for the 4th Video
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("me")
//                .password("me")
//                .roles("USER", "ADMIN");
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/").permitAll() //Anyone has access
//                .antMatchers("/**").hasRole("ADMIN")       //Any request to any url can be accessed by someone with any role
//                .and().formLogin();
//    }
//========================The code below is for the 7th video==============================================

    @Autowired
    DataSource dataSource;

    @Autowired
    UserDetailsService userDetailsService;

    //H2 JDBC
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService); //Used to get user information, built in with spring. One has to create an instance of the userDetailsService
        /*
        * Application.properties is the way in which you set up some external Data  you can use
        * spring.datasource.url=
        * spring.datasource.username=
        * spring.datasource.password=
        *
        * */
        auth.jdbcAuthentication()
                //Check schema.sql in the resources folder to see how the Users table is spun and data.sql for
                // populating the DB
                .dataSource(dataSource);//Tells Spring Security to find your data source/jdbc db
//                .withDefaultSchema() //Spring will create your user table in your H2 DB
//                .withUser(          //Creates a schema within the default H2 Data Source
//                        User.withUsername("user")
//                        .password("password")
//                        .roles("USER")
//                )
//                .withUser(
//                        User.withUsername("admin")
//                                .password("password")
//                                .roles("ADMIN")
//                );

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        //This not something I should be doing
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN") //Anyone has access
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")       //Any request to any url can be accessed by someone with any role
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

}


