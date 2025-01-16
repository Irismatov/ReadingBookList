package uz.jakongir.readinglist.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import uz.jakongir.readinglist.repository.ReaderRepository;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    private final ReaderRepository readerRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/").hasRole("READER")
                        .requestMatchers("/**").permitAll())
                .formLogin((formLogin) -> formLogin
                .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .permitAll())
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> (UserDetails) readerRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
