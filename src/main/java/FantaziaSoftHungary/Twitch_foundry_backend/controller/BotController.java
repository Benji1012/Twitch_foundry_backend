package FantaziaSoftHungary.Twitch_foundry_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import FantaziaSoftHungary.Twitch_foundry_backend.factory.TwitchBotFactory;
import FantaziaSoftHungary.Twitch_foundry_backend.model.UserConfig;
import FantaziaSoftHungary.Twitch_foundry_backend.repository.UserConfigRepository;
import FantaziaSoftHungary.Twitch_foundry_backend.service.BotManager;
import FantaziaSoftHungary.Twitch_foundry_backend.service.TwitchBotService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BotController {

    private final UserConfigRepository userConfigRepo;
    private final TwitchBotFactory botFactory;
    private final BotManager botManager;

    public BotController(UserConfigRepository repository, TwitchBotFactory botFactory, BotManager botManager) {
        this.userConfigRepo = repository;
        this.botFactory = botFactory;
        this.botManager = botManager;
    }
    
    @PostMapping("/start-bot/{userId}")
    public ResponseEntity<String> startBot(@PathVariable Long userId) {
        try {
            UserConfig config = userConfigRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

            botManager.startOrRefreshBot(config);

            return ResponseEntity.ok("Bot started/refreshed for user: " + config.getTwitchUsername());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to start bot: " + e.getMessage());
        }
    }

}

