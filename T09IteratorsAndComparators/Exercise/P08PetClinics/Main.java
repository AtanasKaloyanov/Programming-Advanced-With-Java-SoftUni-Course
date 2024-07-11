package T09IteratorsAndComparators.Exercise.P08PetClinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Creating 2 maps and a for cycle
        Map<String, Pet> petsByName = new HashMap<>();
        Map<String, Clinic> clinicByName = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            String command = array[0];
            switch (command) {
                case "Create":
                    String creation = array[1];
                    if (creation.equals("Pet")) {
                        String petName = array[2];
                        int petAge = Integer.parseInt(array[3]);
                        String petKind = array[4];
                        Pet pet = new Pet(petName, petAge, petKind);
                        petsByName.put(petName, pet);
                    } else if (creation.equals("Clinic")) {
                        int rooms = Integer.parseInt(array[3]);
                        if (rooms % 2 == 0) {
                            System.out.println("Invalid Operation!");
                        } else {
                            String clinicName = array[2];
                            Clinic clinic = new Clinic(clinicName, rooms);
                            clinicByName.put(clinicName, clinic);
                        }
                    }
                    break;
                case "Add":
                    boolean possibleAdding = false;
                    String petsName = array[1];
                    String clinicsName = array[2];
                    Pet addingPet = petsByName.get(petsName);
                    Clinic clinic = clinicByName.get(clinicsName);

                    if (addingPet != null && clinic != null) {
                        Pet[] pets = clinic.getPets();
                        int start = clinic.getRooms() / 2;
                        Pet centrePet = pets[start];
                        if (centrePet == null) {
                            pets[start] = addingPet;
                            possibleAdding = true;
                        } else {
                            int index = 1;
                            while (index <= start) {
                                int leftPosition = start - index;
                                Pet leftPet = pets[leftPosition];
                                if (leftPet == null) {
                                    pets[leftPosition] = addingPet;
                                    possibleAdding = true;
                                    break;
                                }

                                int rightPosition = start + index;
                                Pet rightPet = pets[rightPosition];
                                if (rightPet == null) {
                                    pets[rightPosition] = addingPet;
                                    possibleAdding = true;
                                    break;
                                }
                                index++;
                            }
                        }
                    }
                    System.out.println(possibleAdding);
                    break;
                case "Release":
                    String clinicsName2 = array[1];
                    Clinic clinic2 = clinicByName.get(clinicsName2);
                    boolean canRelease = false;
                    if (clinic2 != null) {
                        Pet[] pets = clinic2.getPets();
                        int rooms = clinic2.getRooms();
                        int startIndex = rooms / 2;

                        canRelease = canRemovePet(pets, startIndex, rooms);

                        if (!canRelease) {
                            canRelease = canRemovePet(pets, 0, startIndex);
                        }

                    }
                    System.out.println(canRelease);
                    break;
                case "HasEmptyRooms":
                    boolean hasEmptyRooms = false;
                    String clinicName = array[1];
                    Clinic clinic3 = clinicByName.get(clinicName);
                    if (clinic3 != null) {
                        Pet[] pets = clinic3.getPets();
                        for (Pet pet : pets) {
                            if (pet == null) {
                                hasEmptyRooms = true;
                                break;
                            }
                        }
                    }

                    System.out.println(hasEmptyRooms);
                    break;
                case "Print":
                    String clinicName4 = array[1];
                    Clinic clinic4 = clinicByName.get(clinicName4);
                    Pet[] pets = clinic4.getPets();
                    if (array.length == 2) {
                        for (Pet pet : pets) {
                            printPet(pet);
                        }
                    } else if (array.length == 3) {
                        int roomIndex = Integer.parseInt(array[2]) - 1;
                        Pet pet = pets[roomIndex];
                        printPet(pet);
                    }
                    break;
            }
        }
    }

    private static void printPet(Pet pet) {
        if (pet == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(pet);
        }
    }

    private static boolean canRemovePet(Pet[] pets, int startIndex, int endIndex) {
        boolean canRelease = false;
        for (int j = startIndex; j < endIndex; j++) {
            Pet currentPet = pets[j];
            if (currentPet != null) {
                pets[j] = null;
                canRelease = true;
                break;
            }
        }
        return canRelease;
    }
}

/*
class Pet               class Clinic
  1. String name          1. String name
  2. int age              2. int capacity
  3. String kind          3. Pet[] pets

   Input 1:
     Map<String, Pet> petsByName = new HashSet<>();
     Map<String, Clinic> clicicByName = new HashMap<>();

       1. Create Pet George 7 Cat

           pets = {1. George, 7, Cat}

       2. Create Clinic Sofia 4 - Invalid operation
           pets = {1. George, 7, Cat}

       3. Create Clinic Sofiq 1
           pets = {1. George -> { George, 7, Cat} }
           clinicByName = {1. Sofiq -> {  1. Sofiq
                                          2. 1
                                          3. null
                                                     }
                                                      }

       4. HasEmptyRooms Sofiq - true
            pets = {1. George -> { George, 7, Cat} }
            clinicByName = {1. Sofiq -> {  1. Sofiq
                                           2. 1
                                           3. null
                                                     }
                                                      }

       5. Release Sofiq - false
            pets = {1. George -> { George, 7, Cat} }
            clinicByName = {1. Sofiq -> {  1. Sofiq
                                           2. 1
                                           3. null }
                                                     }

       6. Add George Sofiq - true
            pets = {1. George -> { George, 7, Cat} }
            clinicByName = {1. Sofiq -> {  1. Sofiq
                                           2. 1
                                           3. George }
                                                       }

       7. HasEmptyRooms Sofiq - false
            pets = {1. George -> { George, 7, Cat} }
            clinicByName = {1. Sofiq -> {  1. Sofiq
                                           2. 1
                                           3. George }
                                                       }

       8. Create Pet Sharo 2 Dog
           pets = {1. George -> { George, 7, Cat},
                   2. Sharo -> {Sharo, 2, Dog}}
           clinicByName = {1. Sofiq -> {  1. Sofiq
                                           2. 1
                                           3. George }
                                                       }

       9. Add Sharo Sofiq - false
           pets = {1. George -> { George, 7, Cat},
                   2. Sharo -> {Sharo, 2, Dog}}
           clinicByName = {1. Sofiq -> {  1. Sofiq
                                           2. 1
                                           3. George }
                                                       }

      Output 1:
        2. Invalid Operation
        4. true
        5. false
        6. true
        7. false
        9 false


 Input 2:
     Map<String, Pet> petsByName = new HashSet<>();
     Map<String, Clinic> clicicByName = new HashMap<>();

     1. Create Pet George 7 Cat
           pets = {1. George -> { George, 7, Cat} }
           clinicByName = {}

     2. Create Pet Sam 1 Cata
           pets = {1. George -> { George, 7, Cat},
                   2. Sam     ->  {Sam, 1, Cata}
                                                  }
           clinicByName = {}

     3. Create Clinic Rim 5
            pets = {1. George -> { George, 7, Cat},
                    2. Sam    -> { Sam, 1, Cata}
                                                  }
           clinicByName = {1. Rim -> { 1. Rim,
                                       2. 5
                                       3. null null null null null }
                                                                    }

     4. Add George Rim - true
           pets = {1. George -> { George, 7, Cat},
                   2. Sam    -> { Sam, 1, Cata}
                                                  }
           clinicByName = {1. Rim -> { 1. Rim,
                                       2. 5
                                       3. null null George null null }
                                                                       }

     5. Add Sam Rim - true
           pets = {1. George -> { George, 7, Cat},
                   2. Sam    -> { Sam, 1, Cata}
                                                  }
           clinicByName = {1. Rim -> { 1. Rim,
                                       2. 5
                                       3. null Sam George null null }

     6. Print Rim 3 - George
         pets = {1. George -> { George, 7, Cat},
                   2. Sam    -> { Sam, 1, Cata}
                                                  }
           clinicByName = {1. Rim -> { 1. Rim,
                                       2. 5
                                       3. null Sam George null null }

     7. Release Rim - true
             pets = {1. George -> { George, 7, Cat},
                     2. Sam    -> { Sam, 1, Cata}
                                                  }
              clinicByName = {1. Rim -> { 1. Rim,
                                          2. 5
                                          3. null Sam null null null }

     8. Print Rim - Sam
             pets = {1. George -> { George, 7, Cat},
                     2. Sam    -> { Sam, 1, Cata}
                                                  }
              clinicByName = {1. Rim -> { 1. Rim,
                                          2. 5
                                          3. null Sam null null null }

     Output 2:
         4. true
         5. true
         6. George 7 Cat
         7. true
         8. Room empty
            Sam 1 Cata
            Room empty
            Room empty
            Room empty
 */