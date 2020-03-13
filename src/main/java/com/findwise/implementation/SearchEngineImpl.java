package com.findwise.implementation;

import com.findwise.IndexEntry;
import com.findwise.SearchEngine;
import com.findwise.model.WordPositionDTO;

import java.util.*;

public class SearchEngineImpl implements SearchEngine {

    Map<String, List<WordPositionDTO>> index = new HashMap<String, List<WordPositionDTO>>();
    Map<String, Integer> indexByDocument = new HashMap<>();

    public void indexDocument(String id, String content){
        List<String> listContent = Arrays.asList(content.split("\\W+"));

        int pos = 0;
        for(String wordArray : listContent){
            String word = wordArray.toLowerCase();
            pos++;
            List<WordPositionDTO> idx = index.get(word);
            if (idx == null) {
                idx = new LinkedList<WordPositionDTO>();
                index.put(word, idx);
            }
            idx.add(new WordPositionDTO(id, pos));
        }
        indexByDocument.put(id, pos);
    }

    public List<IndexEntry> search(String term) {
        Set<String> answer = new HashSet<String>();
        String word = term.toLowerCase();

        List<WordPositionDTO> idx = index.get(word);

        if (idx != null) {
            for (WordPositionDTO t : idx) {
                answer.add(t.getIdDocument());
            }
        }

        List<IndexEntry> answerList = new ArrayList<>();

        for (String f : answer) {
            Integer occurrences = 0;
            for(WordPositionDTO wordPosition : idx){
                if(wordPosition.getIdDocument().equals(f)){
                    occurrences++;
                }

            }
            answerList.add(new IndexEntryImpl(f, occurrences.doubleValue()/indexByDocument.get(f).doubleValue()));
        }

        return answerList;

    }
}