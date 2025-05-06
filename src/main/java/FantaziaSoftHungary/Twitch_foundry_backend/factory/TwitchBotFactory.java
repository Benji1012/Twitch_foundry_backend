package FantaziaSoftHungary.Twitch_foundry_backend.factory;

import org.springframework.stereotype.Component;

import FantaziaSoftHungary.Twitch_foundry_backend.controller.FoundryApiClientController;
import FantaziaSoftHungary.Twitch_foundry_backend.model.UserConfig;
import FantaziaSoftHungary.Twitch_foundry_backend.service.TwitchBotService;

@Component
public class TwitchBotFactory {

    public TwitchBotService create(UserConfig config) throws Exception {
        FoundryApiClientController foundryClient =
            new FoundryApiClientController(config.getFoundryApiUrl(), config.getFoundryApiKey());

        return new TwitchBotService(config, foundryClient);
    }
}
