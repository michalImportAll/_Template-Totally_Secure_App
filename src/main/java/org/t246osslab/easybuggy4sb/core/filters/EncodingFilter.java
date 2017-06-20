package org.t246osslab.easybuggy4sb.core.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Servlet Filter for encoding
 */
@Component
public class EncodingFilter implements Filter {

    /**
     * Default constructor.
     */
    public EncodingFilter() {
        // Do nothing
    }

    /**
     * Call {@link #doFilter(HttpServletRequest, HttpServletResponse, FilterChain)}.
     * 
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		if (!"/mojibake".equals(request.getRequestURI())) {
            /* Set the default character encoding and content type to UTF-8 (except under /mojibake) */
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
		} else {
			req.setCharacterEncoding("euc-kr");
			res.setContentType("text/html; charset=euc-kr");
		}
		chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        // Do nothing
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // Do nothing
    }
}
