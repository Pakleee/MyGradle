import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet ("/test")

public class TestServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String yesOrNot = req.getParameter("param");
        if ( "yes".equalsIgnoreCase(yesOrNot)){
            res.getWriter().write ("<html><body>You said yes!</body></html>\n"+ "<p><a href=\"./\">Return back</a></p></MyGradle><html>");
        }
        else if ( "no".equalsIgnoreCase(yesOrNot)){
            res.getWriter().write ("<html><body>You said no!</body></html>"+ "<p><a href=\"./\">Return back</a></p></MyGradle><html>");
        } else {
            res.getWriter().write ("<html><body>Check without parameters!</body></html>"+ "<p><a href=\"./\">Return back</a></p></MyGradle><html>");
        }
    }
}
