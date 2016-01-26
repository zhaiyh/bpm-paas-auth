package com.puiui.auth.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puiui.auth.domain.filter.LoginFilterConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author zhaiyh
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        String configFile = config.getInitParameter("loginFilterConfig");
        String jsonConfig = read(configFile);
        LoginFilterConfig filterConfig = parseJson(jsonConfig);
        ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute("loginFilterConfig", filterConfig);
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        chain.doFilter(req, resp);
    }

    public void destroy() {

    }

    private String read(String loginFilterConfig) {
        Reader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new InputStreamReader(
                    this.getClass().getClassLoader().
                            getResourceAsStream(loginFilterConfig));
            char[] buff = new char[1024];
            int len = 0;
            while ((len = reader.read(buff)) != -1) {
                builder.append(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    reader = null;
                }
            }
        }
        return builder.toString();
    }


    private LoginFilterConfig parseJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        LoginFilterConfig config = null;
        try {
            config = mapper.readValue(json, LoginFilterConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
}
