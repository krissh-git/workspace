package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final String CLIENT_ID = "boot-client";
	private static final String CLIENT_SECRET = "boot-secret";
	private static final String GRANT_TYPE = "password";
	private static final String SCOPE_READ = "read";
	private static final String SCOPE_WRITE = "write";
	private static final int ACCESS_TOKEN_VALIDITY = 60 * 60 * 1;
	private static final int REFRESH_TOKEN_VALIDITY = 60 * 60 * 6;

	@Autowired
	private TokenStore tokenStore;
	@Autowired
	private UserApprovalHandler userApprovalHandler;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
				.authenticationManager(authenticationManager);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer.inMemory().withClient(CLIENT_ID).secret(CLIENT_SECRET).authorizedGrantTypes(GRANT_TYPE)
				.scopes(SCOPE_READ, SCOPE_WRITE).accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY)
				.refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY);
	}

}
