package FantaziaSoftHungary.Twitch_foundry_backend.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import FantaziaSoftHungary.Twitch_foundry_backend.factory.TwitchBotFactory;
import FantaziaSoftHungary.Twitch_foundry_backend.model.UserConfig;

@Service
public class BotManager {

    private final Map<Long, BotSession> activeBots = new ConcurrentHashMap<>();
    private final TwitchBotFactory botFactory;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);

    public BotManager(TwitchBotFactory botFactory) {
        this.botFactory = botFactory;
    }

    public synchronized void startOrRefreshBot(UserConfig config) throws Exception {
        BotSession session = activeBots.get(config.getId());

        if (session == null) {
            TwitchBotService bot = botFactory.create(config);
            session = new BotSession(bot);
            activeBots.put(config.getId(), session);
            bot.setOnCommandActivity(() -> refreshTimer(config.getId()));
            bot.start(); // Custom method that begins listening to Twitch events
        }

        refreshTimer(config.getId());
    }

    private void refreshTimer(Long userId) {
        BotSession session = activeBots.get(userId);
        if (session != null) {
            if (session.scheduledFuture != null) {
                session.scheduledFuture.cancel(false);
            }

            session.scheduledFuture = scheduler.schedule(() -> stopBot(userId), 1, TimeUnit.HOURS);
        }
    }

    public synchronized void stopBot(Long userId) {
        BotSession session = activeBots.remove(userId);
        if (session != null) {
            session.bot.stop(); // You implement this in TwitchBotService
        }
    }

    private static class BotSession {
        TwitchBotService bot;
        ScheduledFuture<?> scheduledFuture;

        BotSession(TwitchBotService bot) {
            this.bot = bot;
        }
    }
}
