package id.dondon;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ArenaTest {

  @Test
  public void setPlayers() {
    Arena arena = new Arena(5);

    arena.setPlayerOne(createPlayerOne(5));
    arena.setPlayerTwo(createPlayerTwo(5));


    int[][] playerOneMove = {{0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}};
    int[][] playerTwoMove = {{0, 3}, {1, 3}, {2, 3}, {3, 3}, {4, 3}};
    arena.movePlayerOne(playerOneMove);
    arena.movePlayerTwo(playerTwoMove);
    arena.printGame();

    int[][] mislessPlayerOne = {{0, 3}, {1, 0}, {2, 3}, {3, 3}, {4, 0}};
    int[][] mislessPlayerTwo = {{0, 1}, {1, 0}, {2, 0}, {3, 0}, {4, 0}};
    arena.shotFromPlayerOne(mislessPlayerOne);
    arena.shotFromPlayerTwo(mislessPlayerTwo);
  }

  private Player createPlayerOne(int totalShip) {
    List<Ship> ships = new ArrayList<Ship>();
    for (int i = 0; i < totalShip; i++) {
      ships.add(new Ship(i, 0, 5));
    }

    return new Player("P0", ships);
  }

  private Player createPlayerTwo(int totalShip) {
    List<Ship> ships = new ArrayList<Ship>();
    for (int i = 0; i < totalShip; i++) {
      ships.add(new Ship(i, 4, 5));
    }

    return new Player("P1", ships);
  }

}
