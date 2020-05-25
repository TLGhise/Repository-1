package exemple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<a href ='index.html'> Add a book</a>");
        out.println("<h2> Book List </h2>");

      List<Book> books = BookBD.getAllBooks();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Title</th><th>Author</th><th>Type</th><th>Edit</th><th>Delete</th></tr>");
        for (Book book : books) {
            out.print("<tr><td>" + book.getId() + "</td><td>" + book.getTitle() + "</td><td>" + book.getAuthor() + "</td><td>" + book.getType() + "</td><td><a href='EditServlet?id="+book.getId()+"'>edit</a></td> <td>  <a href='DeleteServlet?id="+book.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

    }
}