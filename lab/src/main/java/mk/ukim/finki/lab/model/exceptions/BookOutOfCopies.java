package mk.ukim.finki.lab.model.exceptions;

public class BookOutOfCopies extends RuntimeException{

    public BookOutOfCopies(Long id){
        super(String.format("Book with id: %d is out of copies", id));
    }

}
