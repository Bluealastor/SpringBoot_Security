package com.example.SpringBoot_Security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.swing.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        /*******************************************************************************
        *   Da JAVA 8 E' POSSIBILE USARE I '::' PER SEMPLIFICARE LE LAMBDA             *
        *   (AbstractHttpConfigurer::disable)                                          *
        *   EQUIVALE ALLA LAMBDA                                                       *
        *   (customizer -> customizer.disable());                                      *
        ********************************************************************************/
        http
        /*****************************************************************************************************
        *   Disabilita la protezione CSRF (Cross-Site Request Forgery).                                      *
        *   In Spring Security, la protezione CSRF è abilitata per impostazione predefinita.                 *
        *   Qui viene disabilitata usando "AbstractHttpConfigurer::disable", spesso utile per le API REST,   *
        *   dove CSRF è meno rilevante in quanto non si utilizzano sessioni di navigazione tradizionali.     *
        ******************************************************************************************************/
                .csrf(AbstractHttpConfigurer::disable)

                /*******************************************************************
                *   Configura le regole di autorizzazione per le richieste HTTP.   *
                ********************************************************************/
                .authorizeHttpRequests(request ->
                        /**************************************************************************************************
                        * Indica che qualsiasi richiesta al server deve essere autenticata.                               *
                        * Questo include tutte le richieste non specificate diversamente nelle regole di autorizzazione.  *
                        ***************************************************************************************************/
                        request.requestMatchers("resgister", "login").authenticated()
                )

                /******************************************************************************************************************
                *   Abilita il login tramite form HTML di default.                                                                *
                *   Questa configurazione utilizza le impostazioni predefinite di Spring Security per il login,                   *
                *   che includono un form HTML di autenticazione accessibile all'URL "/login".                                    *
                *   Se un utente non autenticato tenta di accedere a una risorsa protetta, verrà reindirizzato al form di login.  *
                *******************************************************************************************************************/
                .formLogin(Customizer.withDefaults())
                /*********************************************************************************************************
                *   Abilita l'autenticazione HTTP Basic                                                                  *
                *   HTTP Basic è un meccanismo di autenticazione semplice, in cui le credenziali dell'utente             *
                *   (nome utente e password) vengono inviate con ogni richiesta HTTP nell'header Authorization.          *
                *   Con "Customizer.withDefaults()" si utilizzano le impostazioni predefinite di Spring Security.        *
                *********************************************************************************************************/
                .httpBasic(Customizer.withDefaults())

                /******************************************
                *   Configura la gestione delle sessioni. *
                ******************************************/
                .sessionManagement(session ->
                        /***********************************************************************************
                        *   Specifica la politica di creazione della sessione come "ALWAYS".              *
                        *   Questo significa che verrà creata una nuova sessione per ogni richiesta,      *
                        *   indipendentemente dalla presenza di una sessione esistente.                   *
                        **********************************************************************************/
                        session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        // Crea un'istanza di DaoAuthenticationProvider, che è un'implementazione di AuthenticationProvider.
        // DaoAuthenticationProvider utilizza un UserDetailsService per caricare i dettagli dell'utente
        // (username, password, ruoli) da una fonte dati e un PasswordEncoder per verificare la password.
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        // Configura il PasswordEncoder per il provider di autenticazione.
        // Qui viene utilizzato BCryptPasswordEncoder con una "strength" di 12,
        // che definisce la complessità dell'algoritmo BCrypt (più alto è il valore, più sicura ma lenta sarà la codifica).
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        // Imposta un servizio UserDetailsService personalizzato.
        // Questo servizio viene utilizzato da DaoAuthenticationProvider per caricare i dettagli dell'utente (come username, password, e ruoli)
        // dal database o da altre fonti dati.
        provider.setUserDetailsService(userDetailsService);

        // Ritorna l'oggetto DaoAuthenticationProvider configurato come bean di autenticazione
        // che Spring Security utilizzerà per autenticare gli utenti.
        return provider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    /***********************************************************************************************************
    *     Usa il metodo "getAuthenticationManager" dell'oggetto config (di tipo AuthenticationConfiguration)   *
    *     per ottenere un'istanza preconfigurata di AuthenticationManager.                                     *
    *     AuthenticationConfiguration è una classe di configurazione di Spring Security                        *
    *     che gestisce automaticamente la creazione di un AuthenticationManager standard                       *
    *     in base alla configurazione di sicurezza presente nell'applicazione.                                 *
    ************************************************************************************************************/
        return config.getAuthenticationManager();
    }







}
