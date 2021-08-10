package random;

import random.entity.People;

import java.util.ArrayList;
import java.util.List;

public class PeopleRandom {
  public static void main(String[] args) {
    getRandomPeople().forEach(System.out::println);
  }
  public static List<People> getRandomPeople() {
    List<People> result = new ArrayList<>();
    List<String> names =NameRandom.randomNames();

    /**
     * 400 * 4000 = 1600000
     */
    for(long i=1;i<names.size()*4000;i++) {
      long id = (long) i;
      String name = names.get((int)(i%400));
      int age = NumberRandom.randomNumber(80);
      People people = new People();
      people.setId(id);
      people.setName(name);
      people.setAge(age);
      result.add(people);
    }
    return result;
  }
}
