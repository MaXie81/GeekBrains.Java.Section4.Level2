package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletHelloWorld", urlPatterns = "/ServletHelloWorld")
public class ServletHelloWorld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String html =
                "<html>" +
                "<head>" +
                "<title>ServletHelloWorld</title>" +
                "</head>" +
                "<body>" +
                "<h3>Hello World!</h3>" +
                "</body>" +
                "</html>";

        resp.getWriter().println(html);
    }
}
