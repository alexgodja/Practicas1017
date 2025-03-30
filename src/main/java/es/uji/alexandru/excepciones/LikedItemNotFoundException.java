package es.uji.alexandru.excepciones;

public class LikedItemNotFoundException extends RuntimeException{
    private String item;
    public LikedItemNotFoundException(String item){
        this.item=item;
    }
    public String getItem(){
        return item;
    }
}
