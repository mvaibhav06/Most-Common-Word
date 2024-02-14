import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned){
        paragraph = paragraph.toLowerCase();
        HashMap<String, Integer> counter = new HashMap<>();
        List<String> bannedStrings = new ArrayList<>();

        for (int k=0; k<banned.length; k++){
            bannedStrings.add(banned[k]);
        }
        int i = 0 ;
        int j = 0;

        while (j<paragraph.length()){
            char ch = paragraph.charAt(j);
            if (Character.isLetter(ch)){
                j++;
                continue;
            }else {
                if (j > i){
                    String temp = paragraph.substring(i,j);
                    if (counter.containsKey(temp)){
                        counter.put(temp, counter.get(temp)+1);
                    }else {
                        if (!bannedStrings.contains(temp)) {
                            counter.put(temp, 1);
                        }
                    }
                }
                j++;
                i = j;

            }
        }

        if (j > i){
            String temp = paragraph.substring(i,j);
            if (counter.containsKey(temp)){
                counter.put(temp, counter.get(temp)+1);
            }else {
                if (!bannedStrings.contains(temp)) {
                    counter.put(temp, 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        String out = "";

        for (String key : counter.keySet()){
            if (counter.get(key) > max){
                max = counter.get(key);
                out = key;
            }
        }

        return out;
    }
    public static void main(String[] args) {
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = {"hit"};

        String paragraph = "Bob";
        String[] banned = {};

        System.out.println(mostCommonWord(paragraph, banned));
    }
}
