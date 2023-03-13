package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testFirstPlayer() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 100);
        Player fedor = new Player(2, "Федор", 90);

        game.register(ivan);
        game.register(fedor);
        int expected = 1;
        int actual = game.round("Иван", "Федор");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSecondPlayer() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 70);
        Player fedor = new Player(2, "Федор", 190);

        game.register(ivan);
        game.register(fedor);
        int expected = 2;
        int actual = game.round("Иван", "Федор");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testEqualsPlayer() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 70);
        Player fedor = new Player(2, "Федор", 70);

        game.register(ivan);
        game.register(fedor);
        int expected = 0;
        int actual = game.round("Иван", "Федор");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testNotFaundFistPlayer() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 100);
        Player fedor = new Player(2, "Федор", 70);

        game.register(ivan);
        game.register(fedor);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("Илья", "Федор");
                });

    }
    @Test
    public void testNotFaundSecondPlayer() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 100);
        Player fedor = new Player(2, "Федор", 70);

        game.register(ivan);
        game.register(fedor);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("Иван", "Игорь");
                });

    }
    @Test
    public void testNotFaundAllPlayer() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 100);
        Player fedor = new Player(2, "Федор", 70);

        game.register(ivan);
        game.register(fedor);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("Антон", "Игорь");
                });

    }





}
