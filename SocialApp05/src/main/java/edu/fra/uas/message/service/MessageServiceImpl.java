package edu.fra.uas.message.service;

import edu.fra.uas.conversation.model.Conversation;
import edu.fra.uas.conversation.model.ConversationUser;
import edu.fra.uas.conversation.service.ConversationService;
import edu.fra.uas.conversation.service.ConversationUserService;
import edu.fra.uas.message.model.Message;
import edu.fra.uas.message.service.dto.JokeActionResponseDTO;
import edu.fra.uas.message.service.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    private ConversationUserService conversationUserService;

    private ConversationService conversationService;

    //private PaymentService paymentService;

    private ComedyService comedyService;

    @Autowired
    public MessageServiceImpl(ConversationUserService conversationUserService, ConversationService conversationService,  ComedyService comedyService) {
        log.debug("MessageService instantiated");
        this.conversationUserService = conversationUserService;
        this.conversationService = conversationService;
        //this.paymentService = paymentService;
        this.comedyService = comedyService;
    }

    @Override
    public List<MessageDTO> listAllMessagesFromTo(String from, String to) {
        log.debug("list all messages from " + from + " to " + to);
        ConversationUser userFrom = conversationUserService.getByNickname(from);
        List<Message> targetListOrigin = new ArrayList<>(userFrom.getConversations().get(to).getMessages());
        List<MessageDTO> targetList = new ArrayList<MessageDTO>();
        for (Message source : targetListOrigin) {
            MessageDTO target = new MessageDTO();
            BeanUtils.copyProperties(source, target);
            targetList.add(target);
        }
        ;
        conversationService.resetNewMessages(from, to);
        return targetList;
    }

    @Override
    public void addMessage(String from, String to, String content) {
        log.debug("add message from " + from + " to " + to + " with content: " + content);

        /*if (to.equals("ps")) {
            log.debug("---> calling remote payment service");
            Conversation conversationFrom = conversationUserService.getConversationFromByNicknameTo(to, from);
            conversationService.saveMessages(conversationFrom, content, "out");
            PayActionResponseDTO payActionResponseDTO = paymentService.doPayAction(from, to, content);
            conversationService.saveMessages(conversationFrom, payActionResponseDTO.getDescription(), "in");
            return;
        }*/

        if(to.equals("js")){
            log.debug("---> calling remote joke serice");
            Conversation conversationFrom = conversationUserService.getConversationFromByNicknameTo(to, from);
            conversationService.saveMessages(conversationFrom, content, "out");
            JokeActionResponseDTO jokeActionResponseDTO = comedyService.doJokeAction(from, to, content);
            conversationService.saveMessages(conversationFrom, jokeActionResponseDTO.getDescription(), "in");
            return;
        }

        Conversation conversationFrom = conversationUserService.getConversationFromByNicknameTo(to, from);
        Conversation conversationTo = conversationUserService.getConversationFromByNicknameTo(from, to);
        if (conversationTo != null) {
            conversationService.saveMessages(conversationFrom, content, "out");
            conversationTo.addNewMessages();
            conversationService.saveMessages(conversationTo, content, "in");
        } else {
            conversationService.saveMessages(conversationFrom, content, "out");
            conversationService.saveMessages(conversationFrom, "conversation with " + to + " deleted", "in");
        }
    }

}
