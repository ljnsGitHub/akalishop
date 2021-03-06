package com.akali.config.admin.oauth2.util;

import com.akali.common.dto.admin.PermissionDTO;
import com.akali.config.admin.oauth2.handler.AdminAccessDeniedHandler;
import com.akali.config.admin.oauth2.handler.AdminAuthenticationEntryPoint;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import java.util.List;

/**
 * @ClassName SerurityUtil
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/11/26 0026
 * @Version V1.0
 **/
public class SerurityUtil {
    public static void configHttpSecurity(HttpSecurity http, List<PermissionDTO> permissions) throws Exception {
        http.exceptionHandling()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//采取永不存储session的政策


        for (PermissionDTO permission : permissions) {
            http.authorizeRequests()
                    .antMatchers(permission.getUri()).hasAuthority(permission.getAuthoritySign()).and();
        }

        http.exceptionHandling()
                .accessDeniedHandler(new AdminAccessDeniedHandler())
                .authenticationEntryPoint(new AdminAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers("/**").hasAuthority("admin")
                .and()
                .csrf().disable()
                .rememberMe().rememberMeParameter("remember-me").tokenValiditySeconds(300);

    }
}
