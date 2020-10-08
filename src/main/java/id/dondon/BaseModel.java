package id.dondon;

public class BaseModel {

  @Override
  public boolean equals(Object obj) {
    return ObjectHelper.equals(this, obj);
  }

  @Override
  public int hashCode() {
    return ObjectHelper.hashCode(this);
  }

}
