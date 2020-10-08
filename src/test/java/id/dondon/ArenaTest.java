package id.dondon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ArenaTest {

  @Test
  public void playerTwoHasMoreDamage_thenPlayerOneTheWinner() {
    Arena arena = new Arena(5);

    Player playerOne = createPlayerOne(5);
    Player playerTwo = createPlayerTwo(5);
    arena.setPlayerOne(playerOne);
    arena.setPlayerTwo(playerTwo);


    int[][] playerOneMove = {{0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}};
    int[][] playerTwoMove = {{0, 3}, {1, 3}, {2, 3}, {3, 3}, {4, 3}};
    arena.movePlayerOne(playerOneMove);
    arena.movePlayerTwo(playerTwoMove);

    int[][] missilesPlayerOne = {{0, 3}, {1, 0}, {2, 3}, {3, 3}, {4, 0}};
    int[][] missilesPlayerTwo = {{0, 1}, {1, 0}, {2, 0}, {3, 0}, {4, 0}};
    arena.shotFromPlayerOne(missilesPlayerOne);
    arena.shotFromPlayerTwo(missilesPlayerTwo);

    arena.printGame();

    Player winner = arena.getWinner();
    assertEquals(playerOne.getPlayerName(), winner.getPlayerName());
  }

  @Test
  public void playerOneHasMoreDamage_thenPlayerTwoTheWinner() {
    Arena arena = new Arena(5);

    Player playerOne = createPlayerOne(5);
    Player playerTwo = createPlayerTwo(5);
    arena.setPlayerOne(playerOne);
    arena.setPlayerTwo(playerTwo);


    int[][] playerOneMove = {{0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}};
    int[][] playerTwoMove = {{0, 3}, {1, 3}, {2, 3}, {3, 3}, {4, 3}};
    arena.movePlayerOne(playerOneMove);
    arena.movePlayerTwo(playerTwoMove);

    int[][] missilesPlayerOne = {{0, 3}, {1, 0}, {2, 0}, {3, 0}, {4, 0}};
    int[][] missilesPlayerTwo = {{0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 0}};
    arena.shotFromPlayerOne(missilesPlayerOne);
    arena.shotFromPlayerTwo(missilesPlayerTwo);

    arena.printGame();

    Player winner = arena.getWinner();
    assertEquals(playerTwo.getPlayerName(), winner.getPlayerName());
  }

  @Test
  public void playerOneAndPlayerTwoHasSameDamage_thenGameIsDraw() {
    Arena arena = new Arena(5);

    Player playerOne = createPlayerOne(5);
    Player playerTwo = createPlayerTwo(5);
    arena.setPlayerOne(playerOne);
    arena.setPlayerTwo(playerTwo);


    int[][] playerOneMove = {{0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}};
    int[][] playerTwoMove = {{0, 3}, {1, 3}, {2, 3}, {3, 3}, {4, 3}};
    arena.movePlayerOne(playerOneMove);
    arena.movePlayerTwo(playerTwoMove);

    int[][] missilesPlayerOne = {{0, 3}, {1, 0}, {2, 3}, {3, 3}, {4, 0}};
    int[][] missilesPlayerTwo = {{0, 1}, {1, 1}, {2, 1}, {3, 0}, {4, 0}};
    arena.shotFromPlayerOne(missilesPlayerOne);
    arena.shotFromPlayerTwo(missilesPlayerTwo);

    arena.printGame();

    Player winner = arena.getWinner();
    assertNull(winner);
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
