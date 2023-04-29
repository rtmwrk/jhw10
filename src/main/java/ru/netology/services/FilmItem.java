package ru.netology.services;

// --- Класс данных для работы с афишей фильмов -----------------------------------------------------------
public class FilmItem {
    // Структура объекта
    private int filmId;                             // идентификатор фильма
    private String filmName;                        // имя фильма
    private int filmProductionYear;                 // год производства
    private String filmCountry;                     // страна
    private String filmCategory;                    // жанр
    private String filmDirector;                    // режисер
    private int filmDuration;                       // длительность (мин)

    // Конструктор с параметрами
    public FilmItem(int filmId, String filmName, int filmProductionYear, String filmCountry,
                    String filmCategory, String filmDirector, int filmDuration) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmProductionYear = filmProductionYear;
        this.filmCountry = filmCountry;
        this.filmCategory = filmCategory;
        this.filmDirector = filmDirector;
        this.filmDuration = filmDuration;
    }

    // Методы get... и set... для класса
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmProductionYear() {
        return filmProductionYear;
    }

    public void setFilmProductionYear(int filmProductionYear) {
        this.filmProductionYear = filmProductionYear;
    }

    public String getFilmCountry() {
        return filmCountry;
    }

    public void setFilmCountry(String filmCountry) {
        this.filmCountry = filmCountry;
    }

    public String getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(String filmCategory) {
        this.filmCategory = filmCategory;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }

    public int getFilmDuration() {
        return filmDuration;
    }

    public void setFilmDuration(int filmDuration) {
        this.filmDuration = filmDuration;
    }
}


