package FantaziaSoftHungary.Twitch_foundry_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import FantaziaSoftHungary.Twitch_foundry_backend.model.UserConfig;

import java.util.Optional;

public interface UserConfigRepository extends JpaRepository<UserConfig, Long> {
    Optional<UserConfig> findByTwitchUsername(String twitchUsername);
}
