import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PowerStoneTest {
  Person testPerson = null;
  PowerStone powerStone= null;

  @BeforeEach
  void setUp() {
    testPerson = new Person();
    powerStone = PowerStone.getInstance();
  }

  @AfterEach
  void tearDown() {
    testPerson = null;
    powerStone = null;
  }

  @Test
  void singletonTest(){
    String powerStoneToString = powerStone.toString();
    assertEquals(powerStoneToString,powerStone.toString());
    System.out.println("Pretest: " + powerStone);
    powerStone = PowerStone.getInstance();
    assertEquals(powerStoneToString,powerStone.toString());
    System.out.println("post test: " + powerStone);
  }


  @Test
  void special() {
    double originalPower = testPerson.getPower();
    assertEquals(originalPower, testPerson.getPower());
    powerStone.special(testPerson);
    assertTrue(originalPower < testPerson.getPower());
  }
}