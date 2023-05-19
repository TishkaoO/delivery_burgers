package com.example.delivery_burgers.config;

import com.example.delivery_burgers.filter.JWTAuthenticationFilter;
import com.example.delivery_burgers.filter.JWTAuthorizationFilter;
import com.example.delivery_burgers.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static com.example.delivery_burgers.filter.JWTAuthenticationFilter.SIGN_UP_URL;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsServiceImpl userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /*
    Этот код отвечает за настройку безопасности приложения с использованием JWT-токенов.
     Большинство настроек здесь относится к настройке доступа к конечным точкам (endpoint) приложения
     и добавлению фильтров для аутентификации и авторизации запросов
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // отключается защита от CSRF-атак и включается поддержка CORS (Cross-Origin Resource Sharing).
        //-authorizeRequests конфигурирует правила доступа к конечным точкам приложения.
        //это атака, при которой злоумышленник пытается выполнить нежелательные действия
        // от имени авторизованного пользователя.
        // Например, злоумышленник может отправить запрос на перевод денег
        // с банковского счета пользователя на другой счет без его согласия
        //это механизм, который позволяет веб-приложениям запрашивать данные с других доменов,
        // разрешив доступ к ресурсам с помощью заголовков HTTP.
        // Включение поддержки CORS позволяет разрешить запросы на доступ к ресурсам с других доменов и
        // обеспечить безопасный обмен данными между веб-приложениями,
        // что может быть полезным во многих сценариях, например,
        // когда необходимо получать данные с различных API или веб-сервисов
        //отключаем csrf так как у нас jwt
        //который уже сам по себе является механизмом защиты от CSRF-атак.
        //Кроме того, CORS также
        // предотвращает отправку опасных запросов
        // с вашего сайта на другие сайты без вашего ведома или согласия.
        http.cors().and().csrf().disable().authorizeRequests()
                //разрешает доступ к конечной точке SIGN_UP_URL (регистрация пользователя)
                // только для запросов типа POST.
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                //требуется аутентификация для любого другого запроса.
                .anyRequest().authenticated()
                .and()
                //добавляет фильтр аутентификации JWT, который будет вызываться перед выполнением запроса
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                //добавляет фильтр авторизации JWT, который будет вызываться после успешной аутентификации.
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                //указывает, что в приложении не используются сессии. у нас рест
                //означает, что приложение не будет создавать
                // и использовать сессии для аутентифицированных пользователей
                //. Это означает, что после того, как пользователь авторизовался
                // и получил токен доступа, приложение не будет хранить никакую информацию
                // о пользователе между запросами
                //Такой подход имеет ряд преимуществ.
                // Во-первых, это повышает безопасность приложения,
                // поскольку нет риска утечки информации о пользователях из хранилища сессий
                //о-вторых, это повышает производительность приложения,
                // поскольку приложение не будет заниматься хранением и управлением сессиями
                //При каждом запросе клиента сервер проверяет переданный токен
                //Состояние аутентификации и авторизации не хранится на сервере,
                // а хранится в токене, передаваемом между клиентом и сервером.
                // при каждом запросе к защищенным эндпоинтам требуется предоставлять авторизационный
                // токен в заголовке запроса
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    //настройка менеджера аутентификации
    //Метод userDetailsService устанавливает сервис для загрузки
    // пользовательских данных, который будет использоваться для проверки подлинности пользователей.
    // Метод passwordEncoder устанавливает кодировщик паролей,
    // который будет использоваться для хеширования паролей пользователей перед сохранением в базу данных.
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    //В конкретном случае, метод corsConfigurationSource()
    // создает объект UrlBasedCorsConfigurationSource,
    // который регистрирует конфигурацию CORS для всех URL-адресов ("/**").
    // Эта конфигурация создается с помощью метода applyPermitDefaultValues(),
    // который добавляет разрешение для всех источников, методов HTTP и заголовков.
    //Таким образом, этот код позволяет настроить политику CORS,
    // которая разрешает запросы из любых источников к любым конечным точкам веб-приложения
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
