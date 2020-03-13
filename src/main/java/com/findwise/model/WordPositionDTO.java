package com.findwise.model;

public class WordPositionDTO {
    private String idDocument;
    private int position;

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public WordPositionDTO(String idDocument, int position) {
        this.idDocument = idDocument;
        this.position = position;
    }
}