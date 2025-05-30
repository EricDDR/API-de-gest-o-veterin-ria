package com.example.authapi.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component // Indica que essa classe é um componente gerenciado pelo Spring
public class JwtConfig {

    // Obtém o segredo do token do arquivo de configuração (application.properties)
    @Value("${jwt.secret}")
    private String jwtSecret;

    // Define o tempo de expiração do token
    @Value("${jwt.expiration}")
    private long jwtExpiration;

    // Gera um token JWT com base no nome de usuário
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration);

        // Cria a chave para assinar o token usando o segredo
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        // Constrói e retorna o token
        return Jwts.builder()
                .setSubject(username)         // Define o "dono" do token
                .setIssuedAt(now)            // Data de criação
                .setExpiration(expiryDate)   // Data de expiração
                .signWith(key)               // Assina com a chave
                .compact();                  // Finaliza e retorna o token
    }

    // Valida o token e retorna o nome de usuário (subject) contido nele
    public String validateToken(String token) {
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token) // Verifica assinatura e validade
                .getBody()             // Extrai o corpo (claims)
                .getSubject();         // Retorna o subject (username)
    }
}
