package controller;

import model.Film;
import java.util.ArrayList;
import java.util.List;

public class FilmController {
    private List<Film> daftarFilm;

    public FilmController() {
        daftarFilm = new ArrayList<>();
    }

    public void tambahFilm(Film film) {
        daftarFilm.add(film);
    }

    public List<Film> getDaftarFilm() {
        return daftarFilm;
    }
}
