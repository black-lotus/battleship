package id.dondon;

import java.util.List;

public class Player {

  private String playerName;
  private List<Ship> ships;

  public Player(String playerName, List<Ship> ships) {
    this.playerName = playerName;
    this.ships = ships;
  }

  public String getPlayerName() {
    return playerName;
  }


  public List<Ship> getShips() {
    return ships;
  }

  public void moveShips(int[][] locations) {
    int shipSize = ships.size();
    for (int i = 0; i < shipSize; i++) {
      int[] location = locations[i];
      int x = location[0];
      int y = location[1];
      ships.get(i).setX(x);
      ships.get(i).setY(y);
    }
  }


}
