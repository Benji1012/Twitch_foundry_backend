package model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String twitchUsername;
    private String twitchToken;
    private String foundryApiUrl;
    private String foundryApiKey;

    private String player1Name;
    private String player2Name;
    private String player3Name;
    private String player4Name;
    private String player5Name;
    private String player6Name;
    
    private String player1Uuid;
    private String player2Uuid;
    private String player3Uuid;
    private String player4Uuid;
    private String player5Uuid;
    private String player6Uuid;
}

