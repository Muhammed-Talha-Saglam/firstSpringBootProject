package dev.bytecode.springboot.firstProject.firstProject.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource


@Configuration
class SecurityConfig {

    @Bean
    fun userDetailsManager(dataSource: DataSource): UserDetailsManager {
        val jdbcUserDetailsManager = JdbcUserDetailsManager(dataSource)

        jdbcUserDetailsManager
            .usersByUsernameQuery = "select user_id, pw, active from members where user_id=?"

        jdbcUserDetailsManager
            .setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?")

        return jdbcUserDetailsManager
    }

//    @Bean
//    fun userDetailsManager(): InMemoryUserDetailsManager {
//
//        val john = User.builder()
//            .username("john")
//            .password("{noop}test1234")
//            .roles("EMPLOYEE")
//            .build()
//
//        val mary = User.builder()
//            .username("mary")
//            .password("{noop}test1234")
//            .roles("EMPLOYEE", "MANAGER")
//            .build()
//
//        val susan = User.builder()
//            .username("susan")
//            .password("{noop}test1234")
//            .roles("EMPLOYEE", "MANAGER", "ADMIN")
//            .build()
//
//        return InMemoryUserDetailsManager(john, mary, susan)
//    }

    @Bean
    fun filterChain(http: HttpSecurity) : SecurityFilterChain {
        http.authorizeHttpRequests { configurer ->
            configurer
                .requestMatchers(HttpMethod.GET,"magic-api/employees").hasAnyRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET,"magic-api/employees/**").hasAnyRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST,"magic-api/employees").hasAnyRole("MANAGER")
                .requestMatchers(HttpMethod.PUT,"magic-api/employees").hasAnyRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE,"magic-api/employees/**").hasAnyRole("ADMIN")
        }

        http.httpBasic()
        http.csrf().disable()

        return http.build()
    }
}