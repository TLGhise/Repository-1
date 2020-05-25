package exemple;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookBD {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/books", "postgres", "1234");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }


    public static int save(Book book) {
        int status = 0;
        try {
            Connection connection = BookBD.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "insert into books(title,author,type ) values (?, ?, ?)");
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getType());

            status = ps.executeUpdate();

            connection.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    //
    public static int update(Book book) {
        int status = 0;
        try {
            Connection connection = BookBD.getConnection();
            PreparedStatement update = connection.prepareStatement(
                    "update books set title = ? , author = ?, type = ? where id = ? ");
            update.setString(1, book.getTitle());
            update.setString(2, book.getAuthor());
            update.setString(3, book.getType());

            status = update.executeUpdate();

            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection connection = BookBD.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from books where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Book getBookById(int id) {
        Book book = new Book();

        try {
            Connection connection = BookBD.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from books where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book.setId(rs.getInt(1));
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setType(rs.getString(4));

            }
            connection.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return book;
    }

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        try {
            Connection connection = BookBD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from books");
            while (rs.next()) {
                Book e = new Book();
                e.setId(rs.getInt(1));
                e.setTitle(rs.getString(2));
                e.setAuthor(rs.getString(3));
                e.setType(rs.getString(4));
                books.add(e);
            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
}

