// package com.App_Service_Back.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeHttpRequests((authorize)  ->
//                         authorize
//                                 .requestMatchers("/").permitAll()
// //                                .requestMatchers("/user/cadastro").hasAuthority(ADMIN)
//                                 .anyRequest().authenticated()
//                 )
//                 .formLogin(formLogin ->
//                         formLogin
//                                 .loginPage("/login")
//                                 .defaultSuccessUrl("/",true)
//                                 .failureUrl("/login-error")
//                                 .permitAll()
//                 )
//                 .logout(logout ->
//                         logout
//                                 .logoutSuccessUrl("/login")
//                                 .deleteCookies("JSESSIONID")
//                 )
//                 .exceptionHandling( (ex) -> ex
//                         .accessDeniedPage("/negado")
//                 )

//                 .sessionManagement(sessionManagement ->
//                         sessionManagement
//                                 .sessionFixation().migrateSession()
//                                 .maximumSessions(1)
//                                 .expiredUrl("/login?expired")
//                 );
//         return http.build();
//     }

//     @Bean
//     public UserDetailsService userDetailsService() {
//         UserDetails user = User.builder()
//                 .username("user")
//                 .password(passwordEncoder().encode("password"))
//                 .roles("USER")
//                 .build();
//         return new InMemoryUserDetailsManager(user);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }