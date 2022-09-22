package by.it_academy.jd2.servlet_with_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;


@WebServlet(name = "HelloServletWithNameCookie", urlPatterns = "/hello_with_cookie")
public class HelloServletWithNameCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");


        Cookie[] cookieNull = req.getCookies();
        Cookie[] cookies = req.getCookies();
        if (firstName != null & lastName != null) {
            Cookie myCookie1 = new Cookie("firstName", firstName);
            Cookie myCookie2 = new Cookie("lastName", lastName);
            myCookie1.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(-1)));
            myCookie2.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(-1)));
            resp.addCookie(myCookie1);
            resp.addCookie(myCookie2);

        } else if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("firstName")) {
                    firstName = cookies[i].getValue();
                }
                if (cookies[i].getName().equals("lastName")) {
                    lastName = cookies[i].getValue();
                }
            }
        } else throw new RuntimeException();
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color:blue;'>Hello, " + firstName + " " + lastName + "</span></p>");
        writer.write("<p><span style='color:blue;'>Hello, " + cookieNull.length + "</span></p>");


    }
}
