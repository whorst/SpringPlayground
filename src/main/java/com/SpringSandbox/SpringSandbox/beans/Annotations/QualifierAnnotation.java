package com.SpringSandbox.SpringSandbox.beans.Annotations;

public class QualifierAnnotation {
//    https://www.javaguides.net/2018/06/spring-qualifier-annotation-example.html
    /*
    * public interface MessageProcessor {
    public void processMsg(String message);
}

public class MessageProcessorImpl implements MessageProcessor {

    private MessageService messageService;

    // setter based DI
    @Autowired
    @Qualifier("TwitterService")
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    // constructor based DI
    @Autowired
    public MessageProcessorImpl(@Qualifier("TwitterService") MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMsg(String message) {
        messageService.sendMsg(message);
    }
}
    * */
}
