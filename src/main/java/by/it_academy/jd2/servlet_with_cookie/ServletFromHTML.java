package by.it_academy.jd2.servlet_with_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletFromHTML", urlPatterns = "/from_html")
public class ServletFromHTML extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write(req.getQueryString());

        /*Enumeration<String> paramsName = req.getParameterNames();

        while (paramsName.hasMoreElements()) {
            String paramName = paramsName.nextElement();
            if (paramName.toLowerCase().contains("name")) {
                writer.write("<p><span style='color:blue;'>Hello, " + req.getParameter(paramName) +1+ "</span></p>");
            }
        }*/
    }

    @WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
    public static class HelloWorldServlet extends HttpServlet {

        @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException{
                PrintWriter writer = resp.getWriter();
                writer.write("Hello, My Friend");
            }
    }
}
