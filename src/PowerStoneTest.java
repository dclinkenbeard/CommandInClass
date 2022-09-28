import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PowerStoneTest {
  Person testPerson = null;
  PowerStone powerStone = null;
  SpaceStone spaceStone = null;

  List<IStone> stones = new ArrayList<>();

  @BeforeEach
  void setUp() {
    testPerson = new Titan();
    powerStone = PowerStone.getInstance();
    spaceStone = SpaceStone.getInstance();
    stones.add(powerStone);
    stones.add(spaceStone);
  }

  @AfterEach
  void tearDown() {
    testPerson = null;
    powerStone = null;
    spaceStone = null;
    stones.clear();
  }

  @Test
  void singletonTest(){
    String powerStoneToString = powerStone.toString();
    String spaceStoneToString = spaceStone.toString();

    assertEquals(powerStoneToString,powerStone.toString());
    assertEquals(spaceStoneToString, spaceStone.toString());

    System.out.println("Pretest:");

    for(IStone stone : stones){
      System.out.println(stone);
    }

    powerStone = PowerStone.getInstance();
    spaceStone = SpaceStone.getInstance();

    assertEquals(powerStoneToString,powerStone.toString());
    assertEquals(spaceStoneToString, spaceStone.toString());

    System.out.println("post test: ");
    for(IStone stone : stones){
      System.out.println(stone);
    }
  }


  @Test
  void special() {
    double originalPower = testPerson.getPower();
    assertEquals(originalPower, testPerson.getPower());
    powerStone.special(testPerson);
    assertTrue(originalPower < testPerson.getPower());

    String oldLocation = testPerson.getLocation();
    String newLocation = "Midgard";

    assertNotEquals(oldLocation, newLocation);

    spaceStone.setNewLocation(newLocation);
    spaceStone.special(testPerson);

    assertEquals(newLocation,testPerson.getLocation());
    assertNotEquals(oldLocation, testPerson.getLocation());

    spaceStone.undo(testPerson);
    assertEquals(oldLocation,testPerson.getLocation());

  }
}