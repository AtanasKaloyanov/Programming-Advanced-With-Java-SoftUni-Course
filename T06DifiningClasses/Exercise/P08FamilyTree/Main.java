package T06DifiningClasses.Exercise.P08FamilyTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        String searchedField = scanner.nextLine();

        Map<String, Person> personByName = new HashMap<>();
        Map<String, Person> personByBirthday = new HashMap<>();

        // 2.
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            if (line.contains("-")) {

            }
            line = scanner.nextLine();
        }
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
