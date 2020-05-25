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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String author = request.getParameter("password");
        String type = request.getParameter("type");

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setType(type);

        int status = BookBD.save(book);
        if (status > 0) {
            out.print("<p>successfully saved</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            out.print("<p>unable to save</p>");
        }
    }
}
