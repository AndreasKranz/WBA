package edu.fra.uas.message.service;

import edu.fra.uas.message.service.dto.JokeActionResponseDTO;

public interface ComedyService {

    JokeActionResponseDTO doJokeAction(String from, String to, String content);
}
