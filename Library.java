import java.util.*;

class Library {
    String content;
    HashMap<String, Set<String>> parsedLib = new HashMap<String, Set<String>>();

    public Library(String content){
        this.content = content;
    }

    public Set<String> search(String word) {
        Set<String> titles = new HashSet<String>();

        if(parsedLib.containsKey(word)){
            titles = parsedLib.get(word);
        }

        return titles;

    }
}