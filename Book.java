package exemple;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
@AllArgsConstructor
public class Book {
    private int id;
    private String title, author, type;


    public Book() {

    }
}
