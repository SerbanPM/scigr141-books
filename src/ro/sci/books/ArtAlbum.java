package ro.sci.books;

public class ArtAlbum extends Book {

    private String calitateHartie;

    public String getCalitateHartie( ){
        return calitateHartie;
    }

    public void setCalitateHartie(String calitateHartie){
        this.calitateHartie = calitateHartie;
    }

    @Override
    public String toString( ){
        return "ArtAlbum: " + "nrPagini = " + getNrPagini() + " / nume = '" + getNume() + '\'' + " / calitateHartie = '" + calitateHartie + "\'";
    }
}
