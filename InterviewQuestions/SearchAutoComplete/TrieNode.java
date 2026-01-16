package InterviewQuestions.SearchAutoComplete;

import java.util.*;

//Now what is usually contained in a node
//it will have list of all the children
//since all the children can be only

public class TrieNode {
       Map<Character, TrieNode> children = new HashMap<>();
       boolean isEndOfWord;
       int frequency;

       Map<Character, TrieNode> getChildren()
       {
          return this.children;
       }

       boolean isEndOfWord()
       {
        return this.isEndOfWord;
       }

       void setEndOfWord(boolean endOfWord)
       {
        this.isEndOfWord = endOfWord;
       }

       int getFrequency()
       {
        return frequency;
       }

       void incrementFrequency()
       {
        this.frequency++;
       }
}
