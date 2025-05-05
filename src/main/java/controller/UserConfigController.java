package controller;

import org.springframework.web.bind.annotation.*;

import model.UserConfig;
import repository.UserConfigRepository;

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

    @PostMapping
    public UserConfig saveConfig(@RequestBody UserConfig config) {
        return repository.save(config);
    }
}

