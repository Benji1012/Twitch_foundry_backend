package FantaziaSoftHungary.Twitch_foundry_backend.controller;

import org.springframework.web.bind.annotation.*;

import FantaziaSoftHungary.Twitch_foundry_backend.dto.UserConfigDTO;
import FantaziaSoftHungary.Twitch_foundry_backend.model.UserConfig;
import FantaziaSoftHungary.Twitch_foundry_backend.repository.UserConfigRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/config")
public class UserConfigController {

    private final UserConfigRepository repository;
   

    public UserConfigController(UserConfigRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{username}")
    public Optional<UserConfig> getConfig(@PathVariable String username) {
        return repository.findByTwitchUsername(username);
    }

    @PostMapping("/register")
    public UserConfig registerConfig(@RequestBody UserConfigDTO dto) {
        // Delete old config if exists
        repository.findByTwitchUsername(dto.getTwitchUsername())
                  .ifPresent(repository::delete);

        // Convert DTO to Entity and enrich
        UserConfig config = new UserConfig();
        config.setTwitchUsername(dto.getTwitchUsername());
        config.setTwitchToken(dto.getTwitchToken());
        config.setFoundryApiUrl(dto.getFoundryApiUrl());
        config.setFoundryApiKey(dto.getFoundryApiKey());

        config.setPlayer1Name(dto.getPlayer1Name());
        config.setPlayer2Name(dto.getPlayer2Name());
        config.setPlayer3Name(dto.getPlayer3Name());
        config.setPlayer4Name(dto.getPlayer4Name());
        config.setPlayer5Name(dto.getPlayer5Name());
        config.setPlayer6Name(dto.getPlayer6Name());

        // Call Foundry API to get UUIDs/clientId
        enrichWithFoundryData(config);

        return repository.save(config);
    }

    private void enrichWithFoundryData(UserConfig config) {
        
    	 try {
			FoundryApiClientController foundryClient = new FoundryApiClientController(config.getFoundryApiUrl(), config.getFoundryApiKey());
			config.setClientId(foundryClient.getClienId());
			config.setPlayer1Uuid(foundryClient.getPlayerIdByName(config.getPlayer1Name()));
	        config.setPlayer2Uuid(foundryClient.getPlayerIdByName(config.getPlayer2Name()));
	        config.setPlayer3Uuid(foundryClient.getPlayerIdByName(config.getPlayer3Name()));
	        config.setPlayer4Uuid(foundryClient.getPlayerIdByName(config.getPlayer4Name()));
	        config.setPlayer5Uuid(foundryClient.getPlayerIdByName(config.getPlayer5Name()));
	        config.setPlayer6Uuid(foundryClient.getPlayerIdByName(config.getPlayer6Name()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
    	  
    }
    
}

