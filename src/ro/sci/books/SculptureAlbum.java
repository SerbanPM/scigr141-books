package ro.sci.books;

public class SculptureAlbum extends ArtAlbum {
    private String gen;

    public SculptureAlbum(String gen){
        this.gen = gen;
    }

    public SculptureAlbum( ){
    }

    public String getGen( ){
        return gen;
    }

    public void setGen(String gen){
        this.gen = gen;
    }

    @Override
    public String toString( ){
        return "SculptureAlbum: " + "nrPagini = " + getNrPagini() + " / nume = '" + getNume() + '\'' + " / calitateHartie = '" + getCalitateHartie() + '\'' + " / gen = '" + gen + '\'';
    }
}

