package T06DifiningClasses.Exercise.P08FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Reading the info of the searched person:
        Scanner scanner = new Scanner(System.in);
        String searchedPersonInfo = scanner.nextLine();

        // 2. Then it comes another information in lines. There are 2 cases:
        //    2.1. The first case is the line contains "-". Then the line is in format parentInfo - childInfo. In this case the line
        // should be added to a List<String> familyConnections.
        //    2.2 If the current line doesn't contain "-" then the line consists
        //        information about one person in format "personName personBirthday. In this we should initialize personName and
        //        personBirthday from this line, then we should create a Person object and put it in a map with a key its name.
        String line = scanner.nextLine();
        List<String> familyConnections = new ArrayList<>();
        Map<String, Person> personByName = new HashMap<>();

        while (!line.equals("End")) {
            if (line.contains("-")) {
                // Line example: Krasimir Kaloyanov - Atanas Kaloyanov
               familyConnections.add(line);
            } else {
                // Line example: Atanas Kaloyanov 10/6/1994
                int nameLastIndex = line.lastIndexOf(" ");
                String name = line.substring(0, nameLastIndex);
                String birthday = line.substring(nameLastIndex + 1);
                Person person = new Person(name, birthday);
                personByName.put(name, person);
            }
            line = scanner.nextLine();
        }

        // 3. The next step is iteration over the list familyConnections. From every element we can initialize 2 fields -
        // parentInfo and childInfo by splitting the line by " - ". There are 4 cases - 2 possible formats (name or birthday)
        // for the parentInfo and the same 2 formats for the childInfo.
        //     3.1. If there is a person with parentsInfo (2 cases) in the map then adding the childInfo to the person's childrenList
        //     3.2. If there is a person with childInfo (same 2 cases) in the map then adding the parentInfo to the person's parentsList
        for (String familyConnection : familyConnections) {
            String[] array = familyConnection.split(" - ");
            String parentInfo = array[0];
            String childInfo = array[1];

            // ParentsInfo cases:
            if (!parentInfo.contains("/")) {
               if (personByName.containsKey(parentInfo)) {
                   Person person = personByName.get(parentInfo);
                   person.getChildrenInfos().add(childInfo);
               }
            } else {
                for (Person person : personByName.values()) {
                    String birthday = person.getBirthday();
                    if (parentInfo.equals(birthday)) {
                        person.getChildrenInfos().add(childInfo);
                    }
                }
            }

            // ChildInfo cases:
            if (!childInfo.contains("/")) {
                if (personByName.containsKey(childInfo)) {
                    Person person = personByName.get(childInfo);
                    person.getParentsInfos().add(parentInfo);
                }
            } else {
                for (Person person : personByName.values()) {
                    String birthday = person.getBirthday();
                    if (birthday.equals(childInfo)) {
                        person.getParentsInfos().add(parentInfo);
                    }
                }
            }
        }

        // 4. Getting the searchedPerson object and printing the needed information
             //  4.1. about his/her
            Person searchedPerson = getPerson(personByName, searchedPersonInfo);
            System.out.println(searchedPerson);

            //   4.2. about his/her parents
            System.out.println("Parents:");
            List<String> parentsInfos = searchedPerson.getParentsInfos();
            printRelative(personByName, parentsInfos);

            //   4.3. about his/her children:
            System.out.println("Children:");
            List<String> childrenInfos = searchedPerson.getChildrenInfos();
            printRelative(personByName, childrenInfos);

    }

    private static void printRelative(Map<String, Person> personByName, List<String> relativeInfos) {
        for (String parentsInfo : relativeInfos) {
            Person parent = getPerson(personByName, parentsInfo);
            System.out.println(parent);
        }
    }

    private static Person getPerson(Map<String, Person> personByName, String parentsInfo) {
        Person person = null;
        if (!parentsInfo.contains("/")) {
            person = personByName.get(parentsInfo);
        } else {
            for (Person pers : personByName.values()) {
                if (pers.getBirthday().equals(parentsInfo)) {
                    person = pers;
                    break;
                }
            }
        }
        return person;
    }
}

/*
        Input 1:

           1. 11/11/1951 - 23/5/1980

                                name=null, birthday=11/11/1951
                                               |
                                name=null, birthday=23/5/1980

          2. Sara Johnson - 23/5/1980

                name=null, birthday=11/11/1951     name=Sara Johnson, birthday=null
                                                |
                                    name=null, birthday=23/5/1980

          3. Sara Johnson 9/2/1953

          name=null, birthday=11/11/1951     name=Sara Johnson, birthday=9/2/1953
                                          |
                                name=null, birthday=23/5/1980

          4. Peter Johnson - George Johnson

           name=null, birthday=11/11/1951     name=Sara Johnson, birthday=9/2/1953
                                           |
                                name=null, birthday=23/5/1980


                  name=Peter Johnson, birthday=null
                                |
                  name=George Johnson, birthday=null

          5. George Johnson 1/1/2005

           name=null, birthday=11/11/1951     name=Sara Johnson, birthday=9/2/1953
                                           |
                                name=null, birthday=23/5/1980


                  name=Peter Johnson, birthday=null
                                   |
                  name=George Johnson, birthday=1/1/2005


          6. Sam Johnson 11/11/1951

          name=Sam Johnson, birthday=11/11/1951     name=Sara Johnson, birthday=9/2/1953
                                           |
                                name=null, birthday=23/5/1980


                  name=Peter Johnson, birthday=null
                                   |
                  name=George Johnson, birthday=1/1/2005


          7. Peter Johnson 23/5/1980

           name=Sam Johnson, birthday=11/11/1951     name=Sara Johnson, birthday=9/2/1953
                                                  |
                               name=Peter Johnson, birthday=23/5/1980
                                                  |
                               name=George Johnson, birthday=1/1/2005


                 Searched Name - Peter Johnson


            Input 2:

       1. 25/3/1934 - 4/4/1961

                          name=null, birthday=25/3/1934
                                      |
                          name=null, birthday=4/4/1961

       2. Peter Samthon 25/3/1934

                         name=Peter Samthon, birthday=25/3/1934
                                      |
                         name=null, birthday=4/4/1961

       3. 4/4/1961 - George Samthon

                  name=Peter Samthon, birthday=25/3/1934
                                     |
                  name=null, birthday=4/4/1961
                                     |
                  name=George Samthon, birthday=null


       4. Sam Samthon - Sara Samthon

                  name=Peter Samthon, birthday=25/3/1934
                                     |
                  name=null, birthday=4/4/1961
                                     |
                  name=George Samthon, birthday=null


                  name=Sam Samthon, birthday=null
                              |
                  name=Sara Samthon, birthday=null


      5. George Samthon 13/12/1993

                   name=Peter Samthon, birthday=25/3/1934
                                     |
                  name=null, birthday=4/4/1961
                                     |
                  name=George Samthon, birthday=13/12/1993


                  name=Sam Samthon, birthday=null
                              |
                  name=Sara Samthon, birthday=null

      6.  Sara Samthon 7/7/1995

                  name=Peter Samthon, birthday=25/3/1934
                                     |
                  name=null, birthday=4/4/1961
                                     |
                  name=George Samthon, birthday=13/12/1993


                  name=Sam Samthon, birthday=null
                              |
                  name=Sara Samthon, birthday=7/7/1995

       7.  Sam Samthon 4/4/1961

                           name=Peter Samthon, birthday=25/3/1934
                                                 |
                               name=Sam Sampton, birthday=4/4/1961
                                     |                   |
    name=George Samthon, birthday=13/12/1993          name=Sara Samthon, birthday=7/7/1995


                            Searched Name: George Sampton
 */
