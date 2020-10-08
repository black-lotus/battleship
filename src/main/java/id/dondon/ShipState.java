package id.dondon;

public enum  ShipState {

  ALIVE("Alive"),
  DEAD("Dead");

  private String value;

  ShipState(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
