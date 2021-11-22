import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

class CloverRound2 {
    public static void main(String[] args) {
        Library library = new Library(
                "TITLE: Hitchhiker's Guide to the Galaxy\n" +
                        "AUTHOR: Douglas Adams\n" +
                        "DESCRIPTION: Seconds before the Earth is demolished to make way for a galactic freeway,\n" +
                        "Arthur Dent is plucked off the planet by his friend Ford Prefect, a researcher for the\n" +
                        "revised edition of The Hitchhiker's Guide to the Galaxy who, for the last fifteen years,\n" +
                        "has been posing as an out-of-work actor.\n" +
                        "\n" +
                        "TITLE: Dune\n" +
                        "AUTHOR: Frank Herbert\n" +
                        "DESCRIPTION: The troubles begin when stewardship of Arrakis is transferred by the\n" +
                        "Emperor from the Harkonnen Noble House to House Atreides. The Harkonnens don't want to\n" +
                        "give up their privilege, though, and through sabotage and treachery they cast young\n" +
                        "Duke Paul Atreides out into the planet's harsh environment to die. There he falls in\n" +
                        "with the Fremen, a tribe of desert dwellers who become the basis of the army with which \n" +
                        "he will reclaim what's rightfully his. Paul Atreides, though, is far more than just a\n" +
                        "usurped duke. He might be the end product of a very long-term genetic experiment\n" +
                        "designed to breed a super human; he might be a messiah. His struggle is at the center\n" +
                        "of a nexus of powerful people and events, and the repercussions will be felt throughout\n" +
                        "the Imperium.\n" +
                        "\n" +
                        "TITLE: A Song Of Ice And Fire Series\n" +
                        "AUTHOR: George R.R. Martin\n" +
                        "DESCRIPTION: As the Seven Kingdoms face a generation-long winter, the noble Stark family\n" +
                        "confronts the poisonous plots of the rival Lannisters, the emergence of the\n" +
                        "White Walkers, the arrival of barbarian hordes, and other threats.\n");

        HashMap<String, Set<String>> parsedContent = new HashMap<String, Set<String>>();
        String content = library.content;

        String titleContent = null;
        String authorContent = null;
        String descContent = null;
        String[] contentArr = content.split("\n");
        for(String s:contentArr){
            String[] strArr = s.split(": ");
            if(strArr[0].equals("TITLE")){
                titleContent = strArr[1];
                parsedContent = populateMapFromContent(titleContent, parsedContent, titleContent);
            } else if(strArr[0].equals("AUTHOR")){
                authorContent = strArr[1];
                parsedContent = populateMapFromContent(authorContent, parsedContent, titleContent);
            } else if(strArr[0].equals("DESCRIPTION")){
                descContent = strArr[1];
                parsedContent = populateMapFromContent(descContent, parsedContent, titleContent);
            } else {
                parsedContent = populateMapFromContent(strArr[0], parsedContent, titleContent);
            }
        }

        library.parsedLib = parsedContent;
        //System.out.println("*****"+parsedContent);

        Set<String> first_results = library.search("Arrakis");
        System.out.println(first_results.contains("Dune"));

        Set<String> second_results = library.search("winter");
        System.out.println(second_results.contains("A Song Of Ice And Fire Series"));

        Set<String> third_results = library.search("demolished");
        System.out.println(third_results.contains("Hitchhiker's Guide to the Galaxy"));

        Set<String> fourth_results = library.search("the");
        System.out.println(fourth_results.size() == 3);
        System.out.println(fourth_results.contains("Dune"));
        System.out.println(fourth_results.contains("A Song Of Ice And Fire Series"));
        System.out.println(fourth_results.contains("Hitchhiker's Guide to the Galaxy"));
    }

    public static HashMap<String, Set<String>> populateMapFromContent(String content, HashMap<String, Set<String>> inputMap, String title){
        Set<String> titleList = new HashSet<String>();
        for(String word:content.split(" ")){
            word = word.replaceAll("[^a-zA-Z0-9]", "");
            if(inputMap.containsKey(word)){
                titleList = inputMap.get(word);
                titleList.add(title);
                inputMap.put(word, titleList);
            } else {
                titleList.add(title);
                inputMap.put(word, titleList);
            }
        }

        return inputMap;
    }
}