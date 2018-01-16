package com.example.demo.config;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.function.Function;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.model.Constants;
import com.example.demo.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	public String getUserNameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public boolean isTokenExpired(String token) {
		Date expirationDate = getExpirationDateFromToken(token);
		return expirationDate.before(new Date());
	}

	private Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public boolean validateToken(String token, UserDetails details) {
		String userNameFromToken = getUserNameFromToken(token);
		return Objects.equals(userNameFromToken, details.getUsername()) && !isTokenExpired(token);
	}

	public String generateToken(User user) {
		return generateToken(user.getUsername());
	}

	private String generateToken(String subject) {
		Claims claims = Jwts.claims().setSubject(subject);
		claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority(Constants.ROLE_ADMIN)));

		return Jwts.builder().setClaims(claims).setIssuer(Constants.ISSUER)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (Constants.ACCESS_TOKEN_VALIDITY * 1000)))
				.signWith(SignatureAlgorithm.HS256, Constants.SIGNING_KEY).compact();
	}

	private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claim = getAllClaimsFromToken(token);
		return claimsResolver.apply(claim);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(Constants.SIGNING_KEY).parseClaimsJws(token).getBody();
	}

}
