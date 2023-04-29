package ru.netology.services;

// --- Класс - менеджер фильмов ---------------------------------------------------------------------------
public class FilmManager {
    private FilmItem[] films = new FilmItem[0];             // менеджер не содержит фильмы при создании объекта
    protected int countLast;                                // счетчик кол-ва фильмов, выводимых как "последние"

    // Конструктор по умолчанию
    public FilmManager() {
        countLast = 5;                                      // значение счетчика кол-ва "последних" фильмов по умолчанию
    }

    // Конструктор с параметром
    public FilmManager(int countLastParameter) {
        if (countLastParameter > 0) {                       // проверяем, чтобы параметр был больше нуля
            countLast = countLastParameter;                 // меняем счетчик кол-ва "последних" фильмов
        } else {
            countLast = 5;                                  // если пользователь пытается передать в конструктор
                                                            // ошибочное значение параметра, то устанавливаем
                                                            // значение "по умолчанию"
        }
    }

    // Метод добавления фильма в объект - афишу
    public void add(FilmItem item) {
        FilmItem[] tmp = new FilmItem[films.length + 1];    // создаем временный массив для сохранения афиши
        for (int i = 0; i < films.length; i++) {            // во временный массив переписываем существующую афишу
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = item;                         // добавляем новый элемент в афишу
        films = tmp;                                        // переписываем массивы
    }

    // Метод вывода всей афиши
    public FilmItem[] findAll() {
        return films;                                       // просто возвращаем всю афишу
    }

    // Метод вывода заданного кол-ва последних фильмов афиши
    public FilmItem[] findLast() {
        if (countLast <= films.length) {                    // проверяем, чтобы кол-во "последних" фильмов
            FilmItem[] tmp = new FilmItem[countLast];       // не привышало длину существующей афиши
            for (int i = 0; i < countLast; i++) {           // во временный массив переписываем последние
                tmp[i] = films[films.length - 1 - i];       // countLast фильмов
            }
            return tmp;                                     // возвращаем последние countLast фильмов афиши
        } else {                                            // если кол-во "последних" фильмов меньше countLast
            FilmItem[] tmp = new FilmItem[films.length];
            for (int i = 0; i < films.length; i++) {        // выводим всю существующую афишу в обратном порядке
                tmp[i] = films[films.length - 1 - i];
            }
            return tmp;                                     // возвращаем последние countLast фильмов афиши
        }
    }
}
