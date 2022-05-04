import product.Product;
import product.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/cat")
public class ServletCatName extends HttpServlet {


    private Map<String, Product> product = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        product = ProductService.getAll();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        String productName = request.getParameter("name");

        Product foundProduct = product.get(productName);

        if (foundProduct !=null){
            response.getWriter().append("<html><head>\n" + " </head><body><p>" +"Name: "+ foundProduct.getName()+"<p> Price: "+foundProduct.getPrice()+"p</p>"+"<p> Category: "+foundProduct.getCategory()+"</p>"+" Discount: "+foundProduct.getDiscount()+"%" +"</p><p><a href=\"./\">Return back</a></p></MyGradle><html>");
        } else if ("persi".equalsIgnoreCase(productName)) {
            response.getWriter().append("<html><head>\n" + " </head><body><p> <h3>His name is Persi!</h3> </p><p><a href=\"./\">Return back</a></p></MyGradle><html>");
        } else {
            response.getWriter().append("<html><head>\n" + " </head><body><p>No way </p><p><a href=\"./\">Return back</a></p></MyGradle><html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException {


        String pName = req.getParameter("name");
        String pPrice = req.getParameter("price");
        String pCategory = req.getParameter("category");
        String pState = req.getParameter("state");
        String pDiscount = req.getParameter("discount");

        Product product = new Product(pName,Double.valueOf(pPrice),pCategory,pState,Double.valueOf(pDiscount));

        Product productAdd = ProductService.add(product);
        if (productAdd!=null){
            resp.getWriter().append("<html><head>\n" + " </head><body><p> product add </p><p><a href=\"./\">Return back</a></p></MyGradle/addProduct><html>");}
        else {
            resp.getWriter().append("<html><head>\n" + " </head><body><p>Missing product information </p><p><a href=\"./\">Return back</a></p></MyGradle><html>");
        }

    }
}
