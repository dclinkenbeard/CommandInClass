public class PowerStone implements IStone{

  private static final double POWER_INCREMENT = 1.5;

  private static PowerStone POWERSTONE = null;

  private PowerStone(){
    //no code needed.
    //this exists to force the singleton pattern
  }

  public static PowerStone getInstance(){
    if(POWERSTONE == null){
      POWERSTONE = new PowerStone();
    }
    return POWERSTONE;
  }

  @Override
  public void special(Person person){
    double power = person.getPower();
    System.out.println(person + " is powering up");
    System.out.println("power == " + power);
    power = power * POWER_INCREMENT;
    person.setPower(power);
    System.out.println(person + " power == " + person.getPower());
  }

}
