package edu.fra.uas.message.service.dto;

import java.io.Serializable;

public class JokeResponseDTO implements Serializable {
    private String joke;

    public JokeResponseDTO(){
    }

    public JokeResponseDTO(String joke){
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

}
