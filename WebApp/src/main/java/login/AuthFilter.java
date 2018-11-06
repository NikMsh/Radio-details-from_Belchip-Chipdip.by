package login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@WebFilter("/*")
public class AuthFilter implements Filter {
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/login", "/check")));


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");

        if(path.matches(".*(css|jpg|png|gif|js|ico|woff)")){
            filterChain.doFilter(request,response);
            return;
        }

        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean allowedPath = ALLOWED_PATHS.contains(path);

        if (loggedIn  || allowedPath) {
            filterChain.doFilter(request,response);
        } else response.sendRedirect("/login");
    }
}
