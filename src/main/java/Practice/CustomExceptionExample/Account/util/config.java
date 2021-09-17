package Practice.CustomExceptionExample.Account.util;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class config extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception{
        security.cors().and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .antMatchers("/api/v1/user/agree").permitAll()
                .antMatchers("/api/v1/user/deny").authenticated()
                .antMatchers("/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().disable();
    }
}
