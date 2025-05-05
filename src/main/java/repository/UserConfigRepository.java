package repository;


import org.springframework.data.jpa.repository.JpaRepository;

import model.UserConfig;

import java.util.Optional;

public interface UserConfigRepository extends JpaRepository<UserConfig, Long> {
    Optional<UserConfig> findByTwitchUsername(String twitchUsername);
}
