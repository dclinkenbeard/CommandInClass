public abstract class Person {
  private double power = 10.0;
  private String name;
  private String location = "";

  public Person(double power, String name, String location) {
    this.power = power;
    this.name = name;
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public double getPower() {
    return power;
  }

  public void setPower(double power) {
    this.power = power;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
