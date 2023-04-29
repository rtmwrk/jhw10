package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// --- Тестовый класс на класс-менеджер и класс-данных -------------------------------------------------------------
public class FilmManagerTest {

    // Формируем тестовую структуру данных
    FilmItem item1 = new FilmItem(1, "Риддик", 2013, "США",
                                "Фантастика", "Девид Туи", 110);
    FilmItem item2 = new FilmItem(2, "Форест Гамп", 1994, "США",
            "Драма", "Роберт Земекис", 142);
    FilmItem item3 = new FilmItem(3, "Интерстеллар", 2014, "США",
            "Фантастика", "Кристофер Нолан", 160);
    FilmItem item4 = new FilmItem(4, "1+1", 2011, "США",
            "Комедия", "Оливье Накаш", 112);
    FilmItem item5 = new FilmItem(5, "Темный рыцарь", 2008, "США",
            "Фантастика", "Кристофер Нолан", 152);
    FilmItem item6 = new FilmItem(6, "Гарри Поттер и узник Азкабана", 2004, "США",
            "Фантастика", "Альфонсо Куарон", 142);
    FilmItem item7 = new FilmItem(7, "Гладиатор", 2000, "США",
            "Боевик", "Ридли Скотт", 155);
    FilmItem item8 = new FilmItem(8, "Начало", 2010, "США",
            "Фантастика", "Кристофер Нолан", 148);
    FilmItem item9 = new FilmItem(9, "Зеленая книга", 2018, "США",
            "Биография", "Питер Фаррели", 130);

    // Тесты класса "FilItem" --------------------------------------------------------------------------------------

    // Тест метода "getFilmId"
    // метод просто возвращает значение поля объекта, поэтому тестом проверяем только сам факт возврата данных
    // требуемого типа
    @Test
    public void testGetFilmId() {
        int actual = item1.getFilmId();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }
    // Тест метода "setFilmId"
    // метод сохраняет значение поля объекта, никаких ограничений на поле, кроме соответствия типа,
    // с учетом задания тестом проверяем только сам факт присвоения данных, отрабатываем эквивалентные значения
    @Test
    public void testSetFilmId() {
        item1.setFilmId(11);                                // установим тестовое значение поля

        int actual = item1.getFilmId();                     // метод "getFilmId" считаем уже проверенным
        int expected = 11;
        Assertions.assertEquals(expected, actual);          // сравниваем значения
    }

    // Остальные методы get|set будем проверять по той же логике - смотрим просто эквивалентные значения

    // Тест методов "get|setFilmName"
    @Test
    public void testGetFilmName() {
        String actual = item1.getFilmName();
        String expected = "Риддик";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSetFilmName() {
        item1.setFilmName("12 стульев");
        String actual = item1.getFilmName();
        String expected = "12 стульев";
        Assertions.assertEquals(expected, actual);
    }

    // Тест методов "get|setFilmProductionYear"
    @Test
    public void testGetFilmProductionYear() {
        int actual = item1.getFilmProductionYear();
        int expected = 2013;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSetFilmProductionYear() {
        item1.setFilmProductionYear(1974);
        int actual = item1.getFilmProductionYear();
        int expected = 1974;
        Assertions.assertEquals(expected, actual);
    }

    // Тест методов "get|setFilmCountry"
    @Test
    public void testGetFilmCountry() {
        String actual = item1.getFilmCountry();
        String expected = "США";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSetFilmCountry() {
        item1.setFilmCountry("СССР");
        String actual = item1.getFilmCountry();
        String expected = "СССР";
        Assertions.assertEquals(expected, actual);
    }

    // Тест методов "get|setFilmCategory"
    @Test
    public void testGetFilmCategory() {
        String actual = item1.getFilmCategory();
        String expected = "Фантастика";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSetFilmCategory() {
        item1.setFilmCategory("Комедия");
        String actual = item1.getFilmCategory();
        String expected = "Комедия";
        Assertions.assertEquals(expected, actual);
    }

    // Тест методов "get|setFilmDirector"
    @Test
    public void testGetFilmDirector() {
        String actual = item1.getFilmDirector();
        String expected = "Девид Туи";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSetFilmDirector() {
        item1.setFilmDirector("Эльдар Рязанов");
        String actual = item1.getFilmDirector();
        String expected = "Эльдар Рязанов";
        Assertions.assertEquals(expected, actual);
    }

    // Тест методов "get|setFilmDuration"
    @Test
    public void testGetFilmDuration() {
        int actual = item1.getFilmDuration();
        int expected = 110;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSetFilmDuration() {
        item1.setFilmDuration(85);
        int actual = item1.getFilmDuration();
        int expected = 85;
        Assertions.assertEquals(expected, actual);
    }

    // Тесты класса "FilmManager" ----------------------------------------------------------------------------------

    // Тест конструктора "по умолчанию". В данном случае просто проверяем присвоение счетчику "последних" фильмов
    // значения по умолчанию - 5.
    @Test
    public void testFileManagerConstructorWithoutParameter() {
        FilmManager films = new FilmManager();

        int expected = 5;
        int actual = films.countLast;
        Assertions.assertEquals(expected, actual);
    }

    // Тест конструктора с параметром - количество "последних" фильмов афиши для вывода.
    // В данном случае проверяем присвоение счетчику "последних" фильмов требуемого значения.
    // Используем методику "эквивалентных значения" + "граничных значений" для нижней границы
    // параметра "countLast" (считаем разумным, что данный параметр не может принимать отрицательные
    // значения). Условий на ограничение верхней границы нет, поэтому проверим варианты присвоения
    // параметру значений: 1, 0 и -1.
    @Test
    public void testFileManagerConstructorWithParameterOne() {
        FilmManager films = new FilmManager(1);

        int expected = 1;
        int actual = films.countLast;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testFileManagerConstructorWithParameterZero() {
        FilmManager films = new FilmManager(0);

        int expected = 5;
        int actual = films.countLast;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testFileManagerConstructorWithParameterMinusOne() {
        FilmManager films = new FilmManager(-1);

        int expected = 5;
        int actual = films.countLast;
        Assertions.assertEquals(expected, actual);
    }

    // Тест метода на добавление объекта - фильма в афишу
    // В данном случае достаточно проверить факт добавления в наш массив - "афишу" нового объекта
    // требуемой структуры - 2, 1 и 0 объектов покроем методиками "эквивалентных" и "граничных значений"
    @Test
    public void testAddTwoFilms() {
        FilmManager films = new FilmManager();
        films.add(item2);
        films.add(item4);

        FilmItem[] expected = {item2,item4};
        FilmItem[] actual = films.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddOneFilm() {
        FilmManager films = new FilmManager();
        films.add(item2);

        FilmItem[] expected = {item2};
        FilmItem[] actual = films.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddZeroFilms() {
        FilmManager films = new FilmManager();
        FilmItem[] expected = {};
        FilmItem[] actual = films.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    // Тест метода вывода всей афиши - "findAll", всех элементов массива фильмов.
    // Для тестов используем методы "эквивалентных значений", когда афиша имеет положительное число элементов,
    // и "граничных значений", когда афиша пуста. Другими словами для тестов выберем 2-ва варианта: афиша состоит
    // 1 фильма и афиша пуста
    @Test
    public void testFindAllWithOneFilm() {
        FilmManager films = new FilmManager();
        films.add(item1);

        FilmItem[] expected = {item1};
        FilmItem[] actual = films.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindAllWithNoFilm() {
        FilmManager films = new FilmManager();

        FilmItem[] expected = {};
        FilmItem[] actual = films.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    // Тесты метода вывода "последних" значений - "findLast".
    // В тестах используем методики "эквивалентных" и "граничных значений".
    // Сначала проверим вывод на эквивалентных значениях по умолчанию - афиша включает 9 фильмов, вывести нужно 5.
    @Test
    public void testfindLastFiveFromNineFilm() {
        FilmManager films = new FilmManager();
        films.add(item1);
        films.add(item2);
        films.add(item3);
        films.add(item4);
        films.add(item5);
        films.add(item6);
        films.add(item7);
        films.add(item8);
        films.add(item9);

        FilmItem[] expected = {item9,item8,item7,item6,item5};
        FilmItem[] actual = films.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    // Отработаем ситуацию "верхней границы", когда кол-во "последних" для вывода фильмов приближается
    // к верхней границе длины "афиши". Для этого протестируем метод на значениях "countlast" 8, 9, 10
    // при длине афиши в 9 фильмов. Тест при "countLast" = 10 отражает негативный сценарий.
    @Test
    public void testfindLastEightFromNineFilm() {
        FilmManager films = new FilmManager(8);
        films.add(item1);
        films.add(item2);
        films.add(item3);
        films.add(item4);
        films.add(item5);
        films.add(item6);
        films.add(item7);
        films.add(item8);
        films.add(item9);

        FilmItem[] expected = {item9,item8,item7,item6,item5,item4,item3,item2};
        FilmItem[] actual = films.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testfindLastNineFromNineFilm() {
        FilmManager films = new FilmManager(9);
        films.add(item1);
        films.add(item2);
        films.add(item3);
        films.add(item4);
        films.add(item5);
        films.add(item6);
        films.add(item7);
        films.add(item8);
        films.add(item9);

        FilmItem[] expected = {item9,item8,item7,item6,item5,item4,item3,item2,item1};
        FilmItem[] actual = films.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testfindLastTenFromNineFilm() {                  // ситуация, когда "countLas" > чем длина афиши
        FilmManager films = new FilmManager(10);
        films.add(item1);
        films.add(item2);
        films.add(item3);
        films.add(item4);
        films.add(item5);
        films.add(item6);
        films.add(item7);
        films.add(item8);
        films.add(item9);

        FilmItem[] expected = {item9,item8,item7,item6,item5,item4,item3,item2,item1};
        FilmItem[] actual = films.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    // Отработаем ситуацию "нижней границы", когда кол-во "последних" для вывода фильмов приближается
    // к нижней границе длины "афиши". Для этого протестируем метод на значениях "countlast" 1, 0
    // при длине афиши в 9 фильмов
    @Test
    public void testfindLastOneFromNineFilm() {
        FilmManager films = new FilmManager(1);
        films.add(item1);
        films.add(item2);
        films.add(item3);
        films.add(item4);
        films.add(item5);
        films.add(item6);
        films.add(item7);
        films.add(item8);
        films.add(item9);

        FilmItem[] expected = {item9};
        FilmItem[] actual = films.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testfindLastZeroFromNineFilm() {
        FilmManager films = new FilmManager(0);
        films.add(item1);
        films.add(item2);
        films.add(item3);
        films.add(item4);
        films.add(item5);
        films.add(item6);
        films.add(item7);
        films.add(item8);
        films.add(item9);

        FilmItem[] expected = {item9,item8,item7,item6,item5};
        FilmItem[] actual = films.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
