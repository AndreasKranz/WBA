package edu.fra.uas.message.service;


import edu.fra.uas.message.service.dto.InputDTO;
import edu.fra.uas.message.service.dto.JokeActionResponseDTO;
import edu.fra.uas.message.service.dto.JokeResponseDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ComedyServiceImpl implements ComedyService {

    private static final Logger log = LoggerFactory.getLogger(ComedyServiceImpl.class);

    @Value("http://localhost:0666/laugh")
    String jokeUrl;

    @Value("user:plainTextPassword")
    String plainCreds;

    @Override
    public JokeActionResponseDTO doJokeAction(String from, String to, String content) {
        String token1 = "", token2 = "";
        JokeActionResponseDTO jokeActionResponseDTO = new JokeActionResponseDTO().setDescription("empty");

        String[] tokens = content.split("\\s+", 2);//Soll nur nach dem ersten Wort das Leerzeichen spliten den Rest zusammen lassen
        if (tokens.length == 0) {
            return jokeActionResponseDTO.setDescription("wrong syntax");
        }
        for (int i = 0; i < tokens.length; i++) {
            if (i == 0) token1 = tokens[0];
            if (i == 1) token2 = tokens[1];
        }

        if ((token1.equals("joke") || token1.equals("darkjoke")) && token2.equals("")) {
            return comedyCommunication(token1, token2, jokeActionResponseDTO);
        }

        if ((token1.equals("add") || token1.equals("addDark")) && (!token2.equals(""))) {
            return comedyCommunication(token1, token2, jokeActionResponseDTO);
        }
        return jokeActionResponseDTO.setDescription("input is incorrect");
    }

    private JokeActionResponseDTO comedyCommunication(String token1, String token2, JokeActionResponseDTO jokeActionResponse) {

        String uriReturn;
        ResponseEntity<?> response = null;
        RestTemplate restTemplate = new RestTemplate();

        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        HttpEntity<String> request = new HttpEntity<>(headers);

        try {
            switch (token1) {
                case "joke":
                    uriReturn = jokeUrl + "/joke";
                    response = restTemplate.exchange(uriReturn, HttpMethod.GET, request, JokeResponseDTO.class);
                    break;
                case "darkjoke":
                    uriReturn = jokeUrl + "/darkjoke";
                    response = restTemplate.exchange(uriReturn, HttpMethod.GET, request, JokeResponseDTO.class);
                case "add":
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    InputDTO inputDTO = new InputDTO(token2, Rating.unproblematic);
                    HttpEntity<InputDTO> requestPost = new HttpEntity<>(inputDTO, headers);
                    uriReturn = jokeUrl + "/comedian";
                    response = restTemplate.exchange(uriReturn, HttpMethod.POST, requestPost, JokeResponseDTO.class);
                    break;
                case "addDark":
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    InputDTO inputDTO1 = new InputDTO(token2, Rating.dark);
                    HttpEntity<InputDTO> requestPost1 = new HttpEntity<>(inputDTO1, headers);
                    uriReturn = jokeUrl + "/comedian";
                    response = restTemplate.exchange(uriReturn, HttpMethod.POST, requestPost1, JokeResponseDTO.class);
                    break;
                default:
                    return jokeActionResponse.setDescription("wrong syntax - unkown command");
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            log.debug("e to String:" + e.toString());
            response = new ResponseEntity<Object>(new JokeResponseDTO(token1 + " not sucessful" ), HttpStatus.OK);
        }

        JokeResponseDTO jokeResponseDTO = (JokeResponseDTO) response.getBody();
        jokeActionResponse.setDescription(jokeResponseDTO.getJoke());

        return jokeActionResponse;
    }
}
