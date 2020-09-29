
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

//    public static void keyCheck(String term, FlashCard flashCard, int i) {
//        Scanner scanner = new Scanner(System.in);
//        //System.out.printf("The card \"%s\" already exists. Try again:\n", term);
//        String term2 = scanner.nextLine();
//        System.out.printf("The definition of the card #%s:\n", i);
//        String definiton = scanner.nextLine();
//        if (flashCard.isExistsValue(definiton)) {
//            System.out.printf("The definition of \"%s\" already exists. Try again:\n", definiton);
//            String def2 = scanner.nextLine();
//            flashCard.addTermDefinition(term2, def2);
//
//        } else {
//            flashCard.addTermDefinition(term2, definiton);
//        }
//    }


//    private static int getNumberOfCards() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Input the number of cards:");
//            String numOfCards = scanner.nextLine();
//            if (numOfCards.matches("\\b([1-9]|[1-9][0-9]+)\\b")) {
//                return Integer.parseInt(numOfCards);
//            } else {
//                System.out.println("Please input a positive integer greater than 0.");
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        // new file

        Scanner scanner = new Scanner(System.in);
        FlashCard flashCard = new FlashCard();
        System.out.println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
        String userInput = scanner.nextLine();

        do{
            switch (userInput)
            {
                case "add":
                    System.out.println("The card: ");
                    String term = scanner.nextLine();
                    if(flashCard.isExistsKey(term))
                    {
                        System.out.printf("The card \"%s\" already exists. Try again:\n", term);
                        break;
                    }
                    System.out.println("The definition of the card:");
                    String definition = scanner.nextLine();
                    if(flashCard.isExistsValue(definition))
                    {
                        System.out.printf("The definition of \"%s\" already exists. Try again:\n", definition);
                        break;
                    }
                    flashCard.addTermDefinition(term, definition);
                    System.out.println("The pair (\"" + term + ":" + definition +"\") has been added.");
                    break;
                case "remove":
                    System.out.println("The card: ");
                    String removeInput = scanner.nextLine();
                    flashCard.remove(removeInput);
                    break;
                case "import":
                    System.out.println("File name:");
                    String inputFileName = scanner.nextLine();
                    flashCard.importFromFile(inputFileName);
                    break;

                case "export":
                    System.out.println("File name:");
                    String exportFileName = scanner.nextLine();
                    flashCard.exportFromMap(exportFileName);
                    break;

                case "ask":
                    flashCard.ask();
                    break;
                case "log":
                case "hardest card":
                    flashCard.hardestCard();
                    break;
                case "reset stats":
                    break;
                case "exit":
                    break;


            }
            System.out.println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            userInput = scanner.nextLine();

        }while (!(userInput.equals("exit")));
        System.out.println("Bye bye!");










        //int cards = getNumberOfCards();
      /*  for(int card = 1; card<=cards; card++)
        {
            System.out.printf("The card #%d:\n", card);
            String term = scanner.nextLine();
            if(flashCard.isExistsKey(term))
            {
                do {
                    System.out.printf("The card \"%s\" already exists. Try again:\n", term);
                    term = scanner.nextLine();

                }while (flashCard.isExistsKey(term));
            }
            System.out.printf("The definition of card #%d\n", card);
            String definition = scanner.nextLine();
            if(flashCard.isExistsValue(definition))
            {
                do {
                    System.out.printf("The definition of \"%s\" already exists. Try again:\n", definition);
                    definition = scanner.nextLine();

                }while (flashCard.isExistsValue(definition));
            }

            flashCard.addTermDefinition(term, definition);
        }

        flashCard.compare();*/



























        //old file
        //Scanner   scanner   = new Scanner(System.in);
//        System.out.println("Input the number of cards: ");
//        int numberOfTimes = scanner.nextInt();
//        scanner.nextLine();
//        int i = 1;
//        while (i <= numberOfTimes) {
//            System.out.printf("The card #%s:\n", i);
//            String term = scanner.nextLine();
//            if (flashCard.isExistsKey(term)) {
//                do {
//                    System.out.printf("The card \"%s\" already exists. Try again:\n", term);
//                    term = scanner.nextLine();
//                }while(flashCard.isExistsKey(term));
//                keyCheck(term, flashCard, i);
//                i++;
//            } else {
//
//
//                System.out.printf("The definition of the card #%s:\n", i);
//                String definiton = scanner.nextLine();
//                if (flashCard.isExistsValue(definiton)) {
//                    do {
//                        System.out.printf("The definition of \"%s\" already exists. Try again:\n", definiton);
//                        definiton = scanner.nextLine();
//
//                    } while (flashCard.isExistsValue(definiton));
////                    System.out.printf("The definition of \"%s\" already exists. Try again:\n", definiton);
//                    flashCard.addTermDefinition(term, definiton);
//                    i++;
//
//                } else {
//                    flashCard.addTermDefinition(term, definiton);
//                    i++;
//                }
//
//
//            }
//
//        }
//        flashCard.compare();


    }
}
