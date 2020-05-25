package exemple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
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

        int status = BookBD.update(book);
        if (status > 0) {
            out.println(book);
            out.print("<p>successfully update</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            out.print("<p>unable to update</p>");
        }


    }
}
