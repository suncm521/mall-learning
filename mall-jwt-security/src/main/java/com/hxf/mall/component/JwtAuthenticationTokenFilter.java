package com.hxf.mall.component;

import com.hxf.mall.common.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Suncm
 * @ClassName JwtAuthenticationTokenFilter
 * @Description 在用户名和密码校验前添加的过滤器，
 * 如果请求中有jwt的token且有效，会取出token中的用户名，
 * 然后调用SpringSecurity的API进行登录操作
 * @Date 2019/12/25 13:54
 * @Version 1.0
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        if (authHeader!=null&&authHeader.startsWith(this.tokenHead)){
            String authToken = authHeader.substring(this.tokenHead.length());
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            LOGGER.info("check username:{}",username);
            if (username!=null&& SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if(jwtTokenUtil.validateToken(authToken,userDetails)){
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    LOGGER.info("authenticated user:{}",username);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
