import java.io.*;
import java.util.*;

public class FlashCard {

    LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();//Creating HashMap
    LinkedHashMap<String, Integer> hardestCard = new LinkedHashMap<String, Integer>();

    public FlashCard() {

    }

    public boolean isExistsKey(String term) {
        return linkedHashMap.containsKey(term);
    }

    public boolean isExistsValue(String definiton) {
        return linkedHashMap.containsValue(definiton);
    }

    public void addTermDefinition(String term, String def) {

        linkedHashMap.put(term, def);

    }

    public void remove(String key) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
            System.out.println("The card has been removed.");
        } else {
            System.out.println("Can't remove \"" + key + "\": there is no such card.");
        }


    }

    private int getNumberOfCards() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("How many times to ask?");
            String numOfCards = scanner.nextLine();
            if (numOfCards.matches("\\b([1-9]|[1-9][0-9]+)\\b")) {
                return Integer.parseInt(numOfCards);
            } else {
                System.out.println("Please input a positive integer greater than 0.");
            }
        }
    }
    /*public void compare() {

        List keys = new ArrayList(linkedHashMap.keySet());
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            System.out.println("Print the definition of \"" + key + "\":");
            Scanner scanner = new Scanner(System.in);
            String  value   = scanner.nextLine();
            if (linkedHashMap.get(key).equals(value)) {
                System.out.println("Correct!");
            } else {
                boolean check = true;
                for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
                    String key1   = entry.getKey();
                    String value1 = entry.getValue();
                    if (value1.equals(value)) {
                        System.out.println("Wrong.The right answer is \"" + linkedHashMap.get(key) + "\"," + " but your definition is correct for \"" + key1 + "\".");
                        check = false;
                    }
                }
                if (check) {
                    System.out.println("Wrong.The right answer is \"" + linkedHashMap.get(key) + "\".");
                }

            }

        }


    }*/

    public void compare(int cards) {

        Random random = new Random();
        List keys = new ArrayList(linkedHashMap.keySet());

        for (int i = 0; i < cards; i++) {
            //String key = (String) keys.get(i);
            String key = (String) keys.get(random.nextInt(keys.size()));
            System.out.println("Print the definition of \"" + key + "\":");
            Scanner scanner = new Scanner(System.in);
            String  value   = scanner.nextLine();
            if (linkedHashMap.get(key).equals(value)) {
                System.out.println("Correct!");
            } else {
                boolean check = true;
                for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
                    String key1   = entry.getKey();
                    String value1 = entry.getValue();
                    if (value1.equals(value)) {
                        System.out.println("Wrong.The right answer is \"" + linkedHashMap.get(key) + "\"," + " but your definition is correct for \"" + key1 + "\".");
                        hardestCard.replace(key1, 1);
                        
                        check = false;
                    }
                }
                if (check) {
                    System.out.println("Wrong.The right answer is \"" + linkedHashMap.get(key) + "\".");
                }

            }

        }

    }


    public void hardestCard(){


    }


    public void ask() {
        int cards = getNumberOfCards();
        compare(cards);


    }

    public void importFromFile(String fileName) throws IOException {
        String line;
        try {
            BufferedReader reader        = new BufferedReader(new FileReader("/Users/wasimhoque/Desktop/FlashCardsTest/src/" + fileName));
            int            numberOfCards = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length >= 2) {
                    String key   = parts[0];
                    String value = parts[1];
                    if (isExistsKey(key)) {
                        linkedHashMap.replace(key, value);
                        numberOfCards++;
                    } else {
                        linkedHashMap.put(key, value);
                        numberOfCards++;

                    }

                } else {
                    System.out.println("ignoring line: " + line);
                }
            }
            System.out.println(numberOfCards + " cards have been loaded.");

        } catch (Exception e) {
            System.out.println("File not Found");
        }

    }


    public void exportFromMap(String fileName) {
        String         outputFilePath    = "/Users/wasimhoque/Desktop/FlashCardsTest/src/" + fileName;
        File           file              = new File(outputFilePath);
        BufferedWriter bf                = null;
        int            numberOfCardSaved = 0;
        try {

            //create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            //iterate map entries
            for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {

                //put key and value separated by a colon
                bf.write(entry.getKey() + ":" + entry.getValue());
                numberOfCardSaved++;
                //new line
                bf.newLine();
            }

            bf.flush();
            System.out.println(numberOfCardSaved + " cards have been saved.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
