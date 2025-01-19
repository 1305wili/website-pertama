package model;

public class Film {
    private String judul;
    private String genre;
    private double hargaTiket;

    public Film(String judul, String genre, double hargaTiket) {
        this.judul = judul;
        this.genre = genre;
        this.hargaTiket = hargaTiket;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(double hargaTiket) {
        this.hargaTiket = hargaTiket;
    }

    @Override
    public String toString() {
        return judul + " (" + genre + ") - Rp " + hargaTiket;
    }
}
