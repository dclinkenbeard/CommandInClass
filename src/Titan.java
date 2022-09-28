public class Titan extends Person{

  public Titan(){
    super(200.0, "Thanos", "Titan");
  }

  @Override
  public String toString() {
    return getName();
  }
}
