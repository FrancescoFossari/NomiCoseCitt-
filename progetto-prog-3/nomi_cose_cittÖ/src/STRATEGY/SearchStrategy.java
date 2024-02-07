package STRATEGY;


// Interfaccia per la strategia di ricerca
public interface SearchStrategy {
    boolean searchWord(String word, String fileName);
    String search(char startingLetter, String fileName);
}