package ua.artcode.filter;

import org.apache.log4j.Logger;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * FormEncodingSetterFilter
 *
 * @author Eugene Matyushkin
 */
public class FormEncodingSetterFilter implements Filter{
    private static final String FILTERABLE_CONTENT_TYPE="application/x-www-form-urlencoded";
    private static final String ENCODING_DEFAULT = "utf-8";
    private static final String ENCODING_INIT_PARAM_NAME = "encoding";
    private static final Logger logger = Logger.getLogger("ua.artcode.filter.FormEncodingSetterFilter");
    private String encoding;

    public void destroy(){
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest r = (HttpServletRequest) req;
        String contentType = req.getContentType();

        if (contentType != null && contentType.startsWith(FILTERABLE_CONTENT_TYPE))
            req.setCharacterEncoding(encoding);
        logger.info(r.getServletPath() + ">>>" + contentType);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException{
        encoding = config.getInitParameter(ENCODING_INIT_PARAM_NAME);
        if (encoding == null)
            encoding = ENCODING_DEFAULT;
    }
}