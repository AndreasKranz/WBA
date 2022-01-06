package edu.fra.uas.message.service.dto;

public class JokeActionResponseDTO {

    private String token1 = "", token2 = "", description = "";

    public JokeActionResponseDTO() {
    }


    public String getDescription() {
        return description;
    }

    public JokeActionResponseDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
