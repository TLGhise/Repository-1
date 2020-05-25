package exemple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect(request.getContextPath() + "ViewServlet");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String type = request.getParameter("type");

        Book book = Book.builder()
                .title(title)
                .author(author)
                .type(type)
                .build();

        int status = BookBD.insert(book);
        if (status > 0) {
            out.println(book);
            out.print("<p>successfully saved</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            out.print("<p>unable to save</p>");
        }
//        System.out.println(book);
    }
}
