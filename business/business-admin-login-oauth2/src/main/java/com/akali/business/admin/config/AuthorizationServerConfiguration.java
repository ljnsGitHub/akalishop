package com.akali.business.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * @ClassName AuthorizationServerConfiguration
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/11/26 0026
 * @Version V1.0
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore tokenStore() {
        // 基于 JDBC 实现，令牌保存到数据
        return new RedisTokenStore(redisConnectionFactory);
    }
//    @Bean
//    public ClientDetailsService jdbcClientDetails() {
//        // 基于 JDBC 实现，需要事先在数据库配置客户端信息
//        return new JdbcClientDetailsService(dataSource);
//    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 设置令牌
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager);
    }
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        // 读取客户端配置
//        clients.withClientDetails(jdbcClientDetails());
//    }

//内存配置方式
   @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置授权的客户端
        clients.inMemory()
                // client_id
                .withClient("client")
                // client_secret
                .secret(passwordEncoder.encode("123456"))
                // 授权类型
                .authorizedGrantTypes("authorization_code","password")
                // 授权范围
                .scopes("app")
                // 注册回调地址
//                .autoApprove(true)
                .redirectUris("https://www.baidu.com");
    }
}
