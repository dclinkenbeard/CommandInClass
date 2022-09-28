public class SpaceStone implements IStone{

  private String previousLocation;
  private String newLocation;

  private static SpaceStone SPACESTONE = null;

  public static SpaceStone getInstance(){
    if(SPACESTONE == null){
      SPACESTONE = new SpaceStone();
      SPACESTONE.setNewLocation("Knowwhere");
    }
    return SPACESTONE;
  }

  @Override
  public String toString() {
    return "SpaceStone{" +
        super.toString() + ", " +
        "previousLocation='" + previousLocation + '\'' +
        ", newLocation='" + newLocation + '\'' +
        '}';
  }

  public String getPreviousLocation() {
    return previousLocation;
  }

  public void setPreviousLocation(String previousLocation) {
    this.previousLocation = previousLocation;
  }

  public String getNewLocation() {
    return newLocation;
  }

  public void setNewLocation(String newLocation) {
    this.newLocation = newLocation;
  }

  @Override
  public void special(Person person) {
    System.out.println(person + " is going from " + person.getLocation() + " to " + newLocation);
    previousLocation = person.getLocation();
    person.setLocation(newLocation);
    System.out.println("BAMPF!!");
    System.out.println(person + " is now at " + person.getLocation());
  }

  public void undo(Person person){
    System.out.println(person + " changed their mind");
    System.out.println(person + " is going back to " + previousLocation);
    person.setLocation(previousLocation);
    System.out.println(person + " is now at " + person.getLocation());
  }

}
