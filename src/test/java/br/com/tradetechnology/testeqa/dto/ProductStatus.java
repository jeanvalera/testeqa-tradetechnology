package br.com.tradetechnology.testeqa.dto;

public enum ProductStatus {

    ACTIVE("Ativo"),
    INACTIVE("Inativo");

    public final String description;

    private ProductStatus(String description) {
        this.description = description;
    }
    
}
