package br.com.tradetechnology.testeqa.dto;

public enum StockLevel {
    
    REGULAR("Regular"),
    LOW("Baixo"),
    EMPTY("Sem estoque");

    public final String description;

    private StockLevel(String description) {
        this.description = description;
    }

}
