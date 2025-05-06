package FantaziaSoftHungary.Twitch_foundry_backend.service;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

import FantaziaSoftHungary.Twitch_foundry_backend.controller.FoundryApiClientController;
import FantaziaSoftHungary.Twitch_foundry_backend.model.Player;
import FantaziaSoftHungary.Twitch_foundry_backend.model.UserConfig;
import jakarta.annotation.PostConstruct;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;

public class TwitchBotService {

    private final TwitchClient twitchClient;
    private final String channelName;
    private Runnable onCommandActivity = () -> {};
    private FoundryApiClientController foundryClient;
    private UserConfig config;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    private Player player6;
    
    
    public TwitchBotService(UserConfig config, FoundryApiClientController foundryClient) {
        this.channelName = config.getTwitchUsername();

        this.twitchClient = TwitchClientBuilder.builder()
            .withEnableChat(true)
            .withChatAccount(new OAuth2Credential("twitch", config.getTwitchToken()))
            .build();

        this.foundryClient = foundryClient;
        this.config = config;
        
        if(!config.getPlayer1Name().equals("")) {
        	player1 = new Player(config.getPlayer1Name(), this.foundryClient);
        }
        if(!config.getPlayer2Name().equals("")) {
        	player2 = new Player(config.getPlayer2Name(), this.foundryClient);
        }
        if(!config.getPlayer3Name().equals("")) {
        	player3 = new Player(config.getPlayer3Name(), this.foundryClient);
        }
        if(!config.getPlayer4Name().equals("")) {
        	player4 = new Player(config.getPlayer4Name(), this.foundryClient);
        }
        if(!config.getPlayer5Name().equals("")) {
        	player5 = new Player(config.getPlayer5Name(), this.foundryClient);
        }
        if(!config.getPlayer6Name().equals("")) {
        	player6 = new Player(config.getPlayer6Name(), this.foundryClient);
        }
        
//        twitchClient.getChat().joinChannel(channelName);
//
//        twitchClient.getEventManager().onEvent(ChannelMessageEvent.class, event -> {
//            String message = event.getMessage();
//            if (message.startsWith("!roll")) {
//                String diceCommand = parseDiceCommand(message);
//                try {
//                    foundryClient.rollDice(diceCommand, event.getUser().getName());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    private String parseDiceCommand(String message) {
        String[] parts = message.split(" ");
        return parts.length > 1 ? parts[1] : null;
    }
    
    public void setOnCommandActivity(Runnable callback) {
        this.onCommandActivity = callback;
    }

    public void start() {
        twitchClient.getChat().joinChannel(channelName);

        twitchClient.getEventManager().onEvent(ChannelMessageEvent.class, event -> {
            String message = event.getMessage();
            System.out.println("első játékos neve: "+player1.getName());
            if (message.startsWith("!roll") ) {
                onCommandActivity.run();  // 👈 Reset timer on any command
                String diceCommand = parseDiceCommand(message);
              try {
                  foundryClient.rollDice(diceCommand, event.getUser().getName());
              } catch (Exception e) {
                  e.printStackTrace();
              }
            } else if (message.startsWith("!"+player1.getName())) {
           	 String response = player1.toString();  
                twitchClient.getChat().sendMessage(channelName, response);
           }else if (message.startsWith("!"+player2.getName())) {
	           	 String response = player2.toString();  
	             twitchClient.getChat().sendMessage(channelName, response);
	        }else if (message.startsWith("!"+player3.getName())) {
		       	 String response = player3.toString();  
		         twitchClient.getChat().sendMessage(channelName, response);
		    }else if (message.startsWith("!"+player4.getName())) {
			   	 String response = player4.toString();  
			     twitchClient.getChat().sendMessage(channelName, response);
			}else if (message.startsWith("!"+player5.getName())) {
				 String response = player5.toString();  
			     twitchClient.getChat().sendMessage(channelName, response);
			}else if (message.startsWith("!"+player6.getName())) {
				 String response = player6.toString();  
			     twitchClient.getChat().sendMessage(channelName, response);
			}
        });
    }


    public void stop() {
        twitchClient.close();  // or custom cleanup
    }

}

