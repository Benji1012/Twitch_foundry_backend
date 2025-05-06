package FantaziaSoftHungary.Twitch_foundry_backend.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
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
    private String clientId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTwitchUsername() {
		return twitchUsername;
	}
	public void setTwitchUsername(String twitchUsername) {
		this.twitchUsername = twitchUsername;
	}
	public String getTwitchToken() {
		return twitchToken;
	}
	public void setTwitchToken(String twitchToken) {
		this.twitchToken = twitchToken;
	}
	public String getFoundryApiUrl() {
		return foundryApiUrl;
	}
	public void setFoundryApiUrl(String foundryApiUrl) {
		this.foundryApiUrl = foundryApiUrl;
	}
	public String getFoundryApiKey() {
		return foundryApiKey;
	}
	public void setFoundryApiKey(String foundryApiKey) {
		this.foundryApiKey = foundryApiKey;
	}
	public String getPlayer1Name() {
		return player1Name;
	}
	public void setPlayer1Name(String player1Name) {
		this.player1Name = player1Name;
	}
	public String getPlayer2Name() {
		return player2Name;
	}
	public void setPlayer2Name(String player2Name) {
		this.player2Name = player2Name;
	}
	public String getPlayer3Name() {
		return player3Name;
	}
	public void setPlayer3Name(String player3Name) {
		this.player3Name = player3Name;
	}
	public String getPlayer4Name() {
		return player4Name;
	}
	public void setPlayer4Name(String player4Name) {
		this.player4Name = player4Name;
	}
	public String getPlayer5Name() {
		return player5Name;
	}
	public void setPlayer5Name(String player5Name) {
		this.player5Name = player5Name;
	}
	public String getPlayer6Name() {
		return player6Name;
	}
	public void setPlayer6Name(String player6Name) {
		this.player6Name = player6Name;
	}
	public String getPlayer1Uuid() {
		return player1Uuid;
	}
	public void setPlayer1Uuid(String player1Uuid) {
		this.player1Uuid = player1Uuid;
	}
	public String getPlayer2Uuid() {
		return player2Uuid;
	}
	public void setPlayer2Uuid(String player2Uuid) {
		this.player2Uuid = player2Uuid;
	}
	public String getPlayer3Uuid() {
		return player3Uuid;
	}
	public void setPlayer3Uuid(String player3Uuid) {
		this.player3Uuid = player3Uuid;
	}
	public String getPlayer4Uuid() {
		return player4Uuid;
	}
	public void setPlayer4Uuid(String player4Uuid) {
		this.player4Uuid = player4Uuid;
	}
	public String getPlayer5Uuid() {
		return player5Uuid;
	}
	public void setPlayer5Uuid(String player5Uuid) {
		this.player5Uuid = player5Uuid;
	}
	public String getPlayer6Uuid() {
		return player6Uuid;
	}
	public void setPlayer6Uuid(String player6Uuid) {
		this.player6Uuid = player6Uuid;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public UserConfig(Long id, String twitchUsername, String twitchToken, String foundryApiUrl, String foundryApiKey,
			String player1Name, String player2Name, String player3Name, String player4Name, String player5Name,
			String player6Name, String player1Uuid, String player2Uuid, String player3Uuid, String player4Uuid,
			String player5Uuid, String player6Uuid, String clientId) {
		super();
		this.id = id;
		this.twitchUsername = twitchUsername;
		this.twitchToken = twitchToken;
		this.foundryApiUrl = foundryApiUrl;
		this.foundryApiKey = foundryApiKey;
		this.player1Name = player1Name;
		this.player2Name = player2Name;
		this.player3Name = player3Name;
		this.player4Name = player4Name;
		this.player5Name = player5Name;
		this.player6Name = player6Name;
		this.player1Uuid = player1Uuid;
		this.player2Uuid = player2Uuid;
		this.player3Uuid = player3Uuid;
		this.player4Uuid = player4Uuid;
		this.player5Uuid = player5Uuid;
		this.player6Uuid = player6Uuid;
		this.clientId = clientId;
	}
	public UserConfig() {
		super();
	}
}

