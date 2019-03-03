package ro.sci.books;

public class Novel extends Book {
    private String type;

    public Novel( ){
    }

    public Novel(String type){
        this.type = type;
    }

    public String getType( ){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    @Override
    public String toString( ){
        return "Novel: " + "nrPagini = " + getNrPagini() + " / nume = '" + getNume() + '\'' + " / gen literar = '" + type + '\'';
    }
}
