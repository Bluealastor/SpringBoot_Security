# Spring Boot Security & JWT Learning Project

Un progetto di apprendimento per implementare l'autenticazione e l'autorizzazione con **Spring Boot**, **Spring Security** e **JWT (JSON Web Tokens)**.

## Descrizione del Progetto

Questo progetto è un'applicazione di esempio che esplora i concetti fondamentali di autenticazione e autorizzazione utilizzando **Spring Security** e **JWT**. L'obiettivo è comprendere come proteggere le API in un'applicazione Spring Boot, implementando token JWT per gestire le sessioni senza stato e garantire la sicurezza degli endpoint.

## Tecnologie Utilizzate

- **Java** - Linguaggio di programmazione principale
- **Spring Boot** - Framework per il rapido sviluppo di applicazioni basate su Java
- **Spring Security** - Modulo di sicurezza per proteggere le applicazioni Spring
- **JWT (JSON Web Tokens)** - Standard aperto per la gestione di autenticazione senza stato tra client e server

## Funzionalità Implementate

1. **Registrazione Utente** - Endpoint per creare nuovi utenti con credenziali sicure.
2. **Login e Generazione JWT** - Autenticazione degli utenti e generazione di token JWT per sessioni senza stato.
3. **Protezione delle API** - Configurazione di endpoint protetti per autorizzare solo gli utenti autenticati.
4. **Gestione delle Autorità** - Ruoli e permessi per controllare l'accesso agli endpoint in base ai privilegi.

## Struttura del Progetto

```
src/
├── main/
│   ├── java/
│   │   └── com.example.securityjwt/
│   │       ├── controller/      # Contiene i controller per le API
│   │       ├── model/           # Contiene le classi modello (es. Utente)
│   │       ├── repository/      # Contiene le interfacce del repository
│   │       ├── security/        # Configurazione di sicurezza e filtro JWT
│   │       └── service/         # Logica di servizio, come autenticazione e gestione utenti
│   └── resources/
│       └── application.properties # Configurazione dell'applicazione
```

## Configurazione e Installazione

### Prerequisiti

- **Java 11** o superiore
- **Maven** o **Gradle** per gestire le dipendenze
- **PostgreSQL** (o un altro database a tua scelta) per la persistenza

### Setup

1. **Clona il repository:**

   ```bash
   git clone https://github.com/tuo-username/springboot-security-jwt.git
   cd springboot-security-jwt
   ```

2. **Configura il database:**

   Modifica `application.properties` per aggiungere i dettagli del tuo database:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome-database
   spring.datasource.username=nome-utente
   spring.datasource.password=tuo-password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Avvia l'applicazione:**

   ```bash
   mvn spring-boot:run
   ```

4. **API disponibili:**
    - `POST /api/auth/register` - Endpoint per la registrazione di nuovi utenti.
    - `POST /api/auth/login` - Endpoint per l'autenticazione degli utenti e la generazione del token JWT.
    - **Endpoint protetti:** Gli endpoint riservati agli utenti autenticati richiederanno un token JWT per l'accesso.

## Utilizzo del Token JWT

Dopo aver effettuato il login con successo, il server risponde con un token JWT. Questo token deve essere incluso nell'`Authorization header` di ogni richiesta alle API protette, nel formato:

```
Authorization: Bearer <token>
```

## Spunti di Apprendimento

- **Concetti di Sicurezza:** Differenza tra autenticazione e autorizzazione, gestione delle sessioni senza stato.
- **Gestione dei JWT:** Generazione, firma e validazione dei token JWT.
- **Spring Security:** Configurazione di filtri e middleware per proteggere le API.

## Risorse

- [Documentazione Spring Boot](https://spring.io/projects/spring-boot)
- [Guida di Spring Security](https://spring.io/guides/topicals/spring-security-architecture)
- [Introduzione ai JSON Web Tokens](https://jwt.io/introduction/)
- [YouTube Project](https://www.youtube.com/watch?v=Zxwq3aW9ctU&list=PLsyeobzWxl7qbKoSgR5ub6jolI8-ocxCF&pp=iAQB)

ttagli specifici del tuo progetto man mano che lo sviluppi. Buon lavoro con Spring Boot Security e JWT!