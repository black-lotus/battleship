package id.dondon;

import java.util.List;

public class Player extends BaseModel {

  private String playerName;
  private List<Ship> ships;
  private int totalDamage;

  public Player(String playerName, List<Ship> ships) {
    this.playerName = playerName;
    this.ships = ships;
    this.totalDamage = 0;
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

  public int getTotalDamage() {
    return totalDamage;
  }

  public void setTotalDamage(int totalDamage) {
    this.totalDamage = totalDamage;
  }

  @Override
  public String toString() {
    return playerName;
  }

}
