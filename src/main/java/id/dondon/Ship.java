package id.dondon;

public class Ship extends BaseModel {

  private int x;
  private int y;
  private int oldX;
  private int oldY;
  private ShipState shipState;
  private Player owner;
  private int totalMissiles;

  public Ship(int x, int y, int totalMissiles) {
    this.x = x;
    this.y = y;
    this.totalMissiles = totalMissiles;
    this.shipState = ShipState.ALIVE;
  }

  public Player getOwner() {
    return owner;
  }

  public void setOwner(Player owner) {
    this.owner = owner;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.oldX = this.x;
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.oldY = this.y;
    this.y = y;
  }

  public ShipState getShipState() {
    return shipState;
  }

  public void setShipState(ShipState shipState) {
    this.shipState = shipState;
  }

  public int getTotalMissiles() {
    return totalMissiles;
  }

  public int getOldX() {
    return oldX;
  }

  public int getOldY() {
    return oldY;
  }

  @Override
  public String toString() {
    return shipState.equals(ShipState.ALIVE) ? "B" : "X";
  }

}
