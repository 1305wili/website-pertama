package model;

public class Tiket {
    private Film film;
    private int jumlahTiket;

    public Tiket(Film film, int jumlahTiket) {
        this.film = film;
        this.jumlahTiket = jumlahTiket;
    }

    public double hitungTotalHarga() {
        return film.getHargaTiket() * jumlahTiket;
    }

    public String getDetail() {
        return "Film: " + film.getJudul() + "\nJumlah Tiket: " + jumlahTiket + 
               "\nTotal Harga: Rp " + hitungTotalHarga();
    }
}
