package br.com.flmwg.provadeliver.model;

import java.util.ArrayList;

public class Characters {

    private String word;

    public Characters(String word) {
        this.word = word;
    }

    public String getBiggerSequence() {
        ArrayList<String> sequences = new ArrayList<>();
        char auxFirst = word.charAt(0);
        char auxNext;
        StringBuilder sequence = new StringBuilder(String.valueOf(auxFirst));
        int acc = 0;

        for (int i = 0; i < word.length(); i++) {
            if (i == word.length() - 1) {
                break;
            }else {
                auxNext = word.charAt(i + 1);
            }

            if (auxFirst == auxNext) {
                sequence.append(auxNext);
                acc = 1;
            }

            if (acc == 1) {
                sequences.add(sequence.toString().toString());
                acc = 0;
            }else {
                sequence = new StringBuilder(String.valueOf(auxNext));
            }
            auxFirst = auxNext;
        }
        return getSequence(sequences);
    }

    private String getSequence(ArrayList<String> sequences) {
        String result = null;
        int len = 0;

        for (int i = 0; i < sequences.size(); i++) {
            len = sequences.get(i).length();

            for (String sequence : sequences) {
                if (len < sequence.length()) {
                    result = sequence;
                    break;
                }
                result = sequence;
            }
        }
        if (result == null) {
            result = "Não possue sequência!";
        }
        return result;
    }
}
