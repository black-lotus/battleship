package id.dondon;

import java.util.List;

public class Arena {

  private static final String EMPTY = "-";
  private static final String ALIVE_STATE = "B";
  private static final String DEAD_STATE = "X";
  private static final String MISSILE_STATE = "O";

  private Object[][] maps;
  private Player playerOne;
  private Player playerTwo;

  public Arena(int mapSize) {
    this.maps = new Object[mapSize][mapSize];
    resetMaps();
  }

  private void resetMaps() {
    int size = maps.length;
    for (int i = 0; i < size; i++) {
      int jSize = maps[i].length;
      for (int j = 0; j < jSize; j++) {
        maps[i][j] = EMPTY;
      }
    }
  }

  public void printGame() {
    for (Object[] map : maps) {
      for (Object s : map) {
        System.out.print(s);
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public void setPlayerOne(Player playerOne) {
    this.playerOne = playerOne;
    List<Ship> ships = this.playerOne.getShips();
    drawShips(ships);

    System.out.println(playerOne.getPlayerName() + " Start...");
    printGame();
  }

  public void setPlayerTwo(Player playerTwo) {
    this.playerTwo = playerTwo;
    List<Ship> ships = this.playerTwo.getShips();
    drawShips(ships);

    System.out.println(playerTwo.getPlayerName() + " Start...");
    printGame();
  }

  public void movePlayerOne(int[][] locations) {
    this.playerOne.moveShips(locations);
    List<Ship> ships = this.playerOne.getShips();
    drawShips(ships);

    System.out.println(playerOne.getPlayerName() + " Move...");
    printGame();
  }

  public void movePlayerTwo(int[][] locations) {
    this.playerTwo.moveShips(locations);
    List<Ship> ships = this.playerTwo.getShips();
    drawShips(ships);

    System.out.println(playerTwo.getPlayerName() + " Move...");
    printGame();
  }

  public void shotFromPlayerOne(int[][] missiles) {
    shootTarget(this.playerTwo, missiles);

    System.out.println(playerOne.getPlayerName() + " Shoot...");
    printGame();
  }

  public void shotFromPlayerTwo(int[][] missiles) {
    shootTarget(this.playerOne, missiles);

    System.out.println(playerTwo.getPlayerName() + " Shoot...");
    printGame();
  }

  public Player getWinner() {
    System.out.println(playerOne.getPlayerName() + ":" + playerOne.getTotalDamage());
    System.out.println(playerTwo.getPlayerName() + ":" + playerTwo.getTotalDamage());

    if (playerOne.getTotalDamage() > playerTwo.getTotalDamage()) {
      System.out.println(playerTwo.getPlayerName() + " wins");
      return playerTwo;
    }

    if (playerOne.getTotalDamage() < playerTwo.getTotalDamage()) {
      System.out.println(playerOne.getPlayerName() + " wins");
      return playerOne;
    }

    System.out.println("It is a draw");
    return null;
  }

  private void shootTarget(Player playerTarget, int[][] missiles) {
    int size = missiles.length;
    for (int i = 0; i < size; i++) {
      int[] missile = missiles[i];
      int x = missile[0];
      int y = missile[1];

      int score = shootShips(x, y);
      playerTarget.setTotalDamage(playerTarget.getTotalDamage() + score);
    }
  }

  private int shootShips(int x, int y) {
    Object object = this.maps[y][x];
    if (object instanceof Ship) {
      Ship ship = (Ship) object;
      if (ship.getShipState().equals(ShipState.ALIVE) && ship.getX() == x && ship.getY() == y) {
        this.maps[y][x] = DEAD_STATE;
        return 1;
      }
    }

    if (object instanceof String) {
      this.maps[y][x] = MISSILE_STATE;
    }

    return 0;
  }

  private void drawShips(List<Ship> ships) {
    int size = ships.size();
    for (int i = 0; i < size; i++) {
      int x = ships.get(i).getX();
      int y = ships.get(i).getY();
      int oldX = ships.get(i).getOldX();
      int oldY = ships.get(i).getOldY();

      Object current = this.maps[y][x];
      if (current instanceof String) {
        String currentState = (String) current;
        if (currentState.equalsIgnoreCase(EMPTY)) {
          this.maps[y][x] = ships.get(i);
          if (oldY >= 0 && oldX >= 0) {
            this.maps[oldY][oldX] = EMPTY;
          }
        }
      }
    }
  }

}
