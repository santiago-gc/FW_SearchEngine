package main;

import com.findwise.IndexEntry;
import com.findwise.SearchEngine;
import com.findwise.implementation.SearchEngineImpl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args) {
        Map<String, String> documents = new TreeMap<>();
        documents.put("document 1", "the brown fox jumped over the brown dog");
        documents.put("document 2", "the lazy brown dog sat in the corner");
        documents.put("document 3", "the red fox bit the lazy dog");
        String word = "fox";

        SearchEngine searchEngine = new SearchEngineImpl();
        for (Map.Entry<String, String> entry : documents.entrySet()) {
            searchEngine.indexDocument(entry.getKey(), entry.getValue());
        }

        List<IndexEntry> listIndex = searchEngine.search(word);
        List<IndexEntry> sortedList = listIndex
                .stream()
                .sorted((o1,o2)-> Double.valueOf(o2.getScore()).compareTo(Double.valueOf(o1.getScore())))
                .collect(Collectors.toList());

        System.out.print("Word to look for: '" + word + "' --> [ ");
        int size = sortedList.size();

        for(IndexEntry doc :sortedList){
            size--;
            System.out.print(" id: " + doc.getId() + " - score: "+doc.getScore()+ ((size == 0) ? "" : ",") );
        }
        System.out.println("]");

    }

}
