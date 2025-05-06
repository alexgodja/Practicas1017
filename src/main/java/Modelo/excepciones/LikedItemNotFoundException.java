package Modelo.excepciones;

public class LikedItemNotFoundException extends RuntimeException{
    private final String item;
    public LikedItemNotFoundException(String item){
        this.item=item;
    }
    public String getItem(){
        return item;
    }
}
