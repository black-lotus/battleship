package id.dondon;

import java.util.List;

public class Arena {

  private static final String EMPTY = "_";
  private static final String ALIVE_STATE = "B";
  private static final String DEAD_STATE = "X";
  private static final String MISSILE_STATE = "O";

  private Object[][] maps;
  private Player playerOne;
  private Player playerTwo;

  public Arena(int mapSize) {
    this.maps = new String[mapSize][mapSize];
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
  }

  public void setPlayerOne(Player playerOne) {
    this.playerOne = playerOne;
    List<Ship> ships = this.playerOne.getShips();
    drawShips(ships);
  }

  public void setPlayerTwo(Player playerTwo) {
    this.playerTwo = playerTwo;
    List<Ship> ships = this.playerTwo.getShips();
    drawShips(ships);
  }

  public void movePlayerOne(int[][] locations) {
    this.playerOne.moveShips(locations);
    List<Ship> ships = this.playerOne.getShips();
    drawShips(ships);
  }

  public void movePlayerTwo(int[][] locations) {
    this.playerTwo.moveShips(locations);
    List<Ship> ships = this.playerTwo.getShips();
    drawShips(ships);
  }

  public void shotFromPlayerOne(int[][] missiles) {
    shootTarget(this.playerTwo, missiles);
  }

  public void shotFromPlayerTwo(int[][] missiles) {
    shootTarget(this.playerOne, missiles);
  }

  public Player getWinner() {
    if (playerOne.getTotalDamage() > playerTwo.getTotalDamage()) {
      return playerOne;
    }

    if (playerOne.getTotalDamage() < playerTwo.getTotalDamage()) {
      return playerTwo;
    }

    return null;
  }

  private void shootTarget(Player playerTarget, int[][] missiles) {
    int size = missiles.length;
    for (int i = 0; i < size; i++) {
      int[] misile = missiles[i];
      int x = misile[0];
      int y = misile[1];

      int score = shootShips(x, y);
      playerTarget.setTotalDamage(playerTarget.getTotalDamage() + score);
    }
  }

  private int shootShips(int x, int y) {
    Object object = this.maps[x][y];
    if (object instanceof Ship) {
      Ship ship = (Ship) object;
      if (ship.getShipState().equals(ShipState.ALIVE) && ship.getX() == x && ship.getY() == y) {
        this.maps[x][y] = DEAD_STATE;
        return 1;
      }
    }

    if (object instanceof String) {
      this.maps[x][y] = MISSILE_STATE;
    }

    return 0;
  }

  private void drawShips(List<Ship> ships) {
    int size = ships.size();
    for (int i = 0; i < size; i++) {
      ShipState shipState = ships.get(i).getShipState();
      int x = ships.get(i).getX();
      int y = ships.get(i).getY();
      int oldX = ships.get(i).getOldX();
      int oldY = ships.get(i).getOldY();

      String state = ALIVE_STATE;
      if (shipState.equals(ShipState.DEAD)) {
        state = DEAD_STATE;
      }

      Object current = this.maps[y][x];
      if (current instanceof Ship) {
        Ship ship = (Ship) current;
        if (ship.getShipState().equals(ShipState.ALIVE)) {
          this.maps[oldY][oldX] = EMPTY;
          this.maps[y][x] = state;
        }
      } else if (current instanceof String) {
        String currentState = (String) current;
//        if (currentState.equalsIgnoreCase(MISSILE_STATE)) {
//
//        }
      }


    }
  }

  private boolean isCollided() {
    return false;
  }

}
