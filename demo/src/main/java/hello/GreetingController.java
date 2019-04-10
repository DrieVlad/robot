package hello;

import gui.GameVisualizer;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;


@Controller
public class GreetingController {


    public volatile double m_robotPositionX;
    public volatile double m_robotPositionY;
    public volatile double m_robotDirection;

    public volatile int m_targetPositionX;
    public volatile int m_targetPositionY;

    public volatile double currentWidth;
    public volatile double currentHeight;
    GameVisualizer game;


    GreetingController(){
        this.game = new GameVisualizer();
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
        String s = game.Back(message.getName());

        return new Greeting(HtmlUtils.htmlEscape(s));
    }

}