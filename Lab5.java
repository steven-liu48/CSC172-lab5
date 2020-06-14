//Lab Partners:

//Xiaoxiang "Steven" Liu
//xliu102@u.rochester.edu
//MW 6:15PM - 7:30PM

//Grant Yap
//gyap@u.rochester.edu
//MW 2:00 - 3:15PM

//Lab 5

import java.io.File;
import java.util.Scanner;

public class Lab5 {

    public static void main(String[] args) throws Exception{

        Trie lab05_trie = new Trie();

        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        String[] command_words;

        while (sc.hasNextLine()) {
            command_words = sc.nextLine().split(" ");
            if (command_words[0].equals("insert")){
                lab05_trie.insert(lab05_trie, command_words[1]);
            }
            else if (command_words[0].equals("search")){
                System.out.println(lab05_trie.search(lab05_trie, command_words[1]));
            }
            else if (command_words[0].equals("print")){
                System.out.println(lab05_trie.trieToList(lab05_trie).toString().replace("[", "").replace("]","").replace(",",""));
            }
            else if (command_words[0].equals("largest")){
                System.out.println(lab05_trie.largest(lab05_trie));
            }
            else if (command_words[0].equals("smallest")){
                System.out.println(lab05_trie.smallest(lab05_trie));
            }
            else if (command_words[0].equals("height")){
                System.out.println(lab05_trie.height(lab05_trie));
            }
            else if (command_words[0].equals("size")){
                System.out.println(lab05_trie.size(lab05_trie));
            }
        }

    }

}