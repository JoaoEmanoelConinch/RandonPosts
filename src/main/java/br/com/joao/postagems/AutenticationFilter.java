package br.com.joao.postagems;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@Component
@Order(1)
public class AutenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,//
                         ServletResponse response,//
                         FilterChain chain) //
            throws IOException, ServletException {

        final HttpServletRequest servletRequest = (HttpServletRequest) request;
//        final Enumeration<String> headerNames = servletRequest.getHeaderNames();
        final String autorization = servletRequest.getHeader("autorization");

        if (autorization.equals("123")){
            chain.doFilter(request,response);
        } else {
           final HttpServletResponse servletResponse = (HttpServletResponse) response;
           servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
        }

//        while (headerNames.hasMoreElements()){
//            final  String header = headerNames.nextElement();
//            System.out.println(header);
//        }

    }

}
