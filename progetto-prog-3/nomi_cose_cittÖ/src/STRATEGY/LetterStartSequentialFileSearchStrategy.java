package STRATEGY;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;





public class LetterStartSequentialFileSearchStrategy implements SearchStrategy {
    @Override
    public boolean searchWord(String word, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String search(char startingLetter, String fileName) {
        if (new Random().nextInt(10) < 3) {
           
            return "";

        }else{
            List<String> wordsWithSameLetter = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty() && line.toLowerCase().charAt(0) == Character.toLowerCase(startingLetter)) {
                        wordsWithSameLetter.add(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        
            System.out.println("Number of words found: " + wordsWithSameLetter.size());
        
            if (wordsWithSameLetter.isEmpty()) {
                return ""; 
            }
        
            Random random = new Random();
            int randomIndex = random.nextInt(wordsWithSameLetter.size());
            String randomWord = wordsWithSameLetter.get(randomIndex);
            return randomWord;
        }
    }
}


