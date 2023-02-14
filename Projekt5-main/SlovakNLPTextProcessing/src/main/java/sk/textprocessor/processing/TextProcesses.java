package sk.textprocessor.processing;

import sk.textprocessor.output.FileHandler;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class TextProcesses {


    //    tokenization
    public String tokenize(String text){

        StringTokenizer str= new StringTokenizer(text);
        ArrayList<String> result = new ArrayList<String>();

        while (str.hasMoreTokens())
        {
            result.add(str.nextToken(" "));
        }

        String output = "";
        output = result.toString();
        return output;

    }

//    extractSentences
    public String extractSentences(String text) {
        ArrayList<String> sentenses = new ArrayList<String>();

        Abbreviation skr = new Abbreviation();
        boolean dictionary = false;

        int sentense_last_char = 0;
        int word_last_char = 0;
        String word = "";
        String input = text;
        String next_line = "";

        input = next_line + " " + input;

        sentense_last_char = 0;
        word_last_char = 0;

        for (int i = 1; i < input.length() - 3; i++) {
            String ch = input.substring(i, i + 3);

            if (input.charAt(i + 2) == ' ') {
                word = input.substring(word_last_char, i + 2).trim().toLowerCase();
                word_last_char = i + 3;
                dictionary = skr.isAbbreviation(word);
            }

            if ((ch.matches("([!?.])(\\s)[A-Z]")) && !dictionary && (input.substring(i-1,i).matches("[a-z]") )) {
                sentenses.add(input.substring(sentense_last_char, i + 1));
                sentense_last_char = i + 1;
            }
        }

        next_line = input.substring(sentense_last_char, input.length()).trim();
        sentenses.add(next_line);

        String output = "";
        for (String sentence : sentenses) {
            output += sentence.trim() + "\n";
        }

        return output;
    }

}

