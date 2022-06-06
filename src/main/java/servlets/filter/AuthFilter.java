package servlets.filter;

import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {


    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)
            throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");
        final HttpSession session = req.getSession();

        if (nonNull(session)&&
        nonNull(session.getAttribute("login"))&&
        nonNull(session.getAttribute("password"))){
            final User.ROLE role = (User.ROLE)session.getAttribute("role");
            doFilter(req,res,filterChain);
        } else if (dao.get().userISExist(login,password)){
            final User.ROLE role = dao.get().getRoleyByLoginPassword(login,password);
            req.getSession().setAttribute("password",password);
            req.getSession().setAttribute("login",login);
            req.getSession().setAttribute("role",role);

            moveToMen(req,res,role);
        } else {
            moveToMen(req,res,User.ROLE.UNKNOWN);
        }
    }

    private void moveToMen (final HttpServletRequest req,
                            final HttpServletResponse res,
                            final User.ROLE role)
        throws ServletException, IOException{
        if (role.equals(User.ROLE.ADMIN)) {
            req.getRequestDispatcher("/addProduct.html").forward(req,res);
        } else if (role.equals(User.ROLE.USER)){
            req.getRequestDispatcher("/login.jsp").forward(req,res);
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req,res);
        }
    }


    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
