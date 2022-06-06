
import dao.UserDAO;
import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

import static model.User.ROLE.ADMIN;
import static model.User.ROLE.USER;


@WebListener
public class ContextListener implements ServletContextListener {
    private AtomicReference<UserDAO>dao;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1,"Pavel","1",ADMIN));
        dao.get().add(new User(1,"User","1",USER));

        final ServletContext servletContext = sce.getServletContext();

        servletContext.setAttribute("dao",dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;

    }
}
