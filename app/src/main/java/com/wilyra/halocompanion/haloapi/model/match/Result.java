
package com.wilyra.halocompanion.haloapi.model.match;

import java.util.UUID;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("Links")
    @Expose
    private Object Links;
    @SerializedName("Id")
    @Expose
    private com.wilyra.halocompanion.haloapi.model.match.Id Id;
    @SerializedName("HopperId")
    @Expose
    private UUID HopperId;
    @SerializedName("MapId")
    @Expose
    private UUID MapId;
    @SerializedName("MapVariant")
    @Expose
    private com.wilyra.halocompanion.haloapi.model.match.MapVariant MapVariant;
    @SerializedName("GameBaseVariantId")
    @Expose
    private UUID GameBaseVariantId;
    @SerializedName("GameVariant")
    @Expose
    private com.wilyra.halocompanion.haloapi.model.match.GameVariant GameVariant;
    @SerializedName("MatchDuration")
    @Expose
    private String MatchDuration;
    @SerializedName("MatchCompletedDate")
    @Expose
    private com.wilyra.halocompanion.haloapi.model.match.MatchCompletedDate MatchCompletedDate;
    @SerializedName("Teams")
    @Expose
    private Team[] Teams;
    @SerializedName("Players")
    @Expose
    private Player[] Players;
    @SerializedName("IsTeamGame")
    @Expose
    private boolean IsTeamGame;
    @SerializedName("SeasonId")
    @Expose
    private Object SeasonId;

    /**
     * 
     * @return
     *     The Links
     */
    public Object getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The Links
     */
    public void setLinks(String Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The Id
     */
    public com.wilyra.halocompanion.haloapi.model.match.Id getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The Id
     */
    public void setId(com.wilyra.halocompanion.haloapi.model.match.Id Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The HopperId
     */
    public UUID getHopperId() {
        return HopperId;
    }

    /**
     * 
     * @param HopperId
     *     The HopperId
     */
    public void setHopperId(UUID HopperId) {
        this.HopperId = HopperId;
    }

    /**
     * 
     * @return
     *     The MapId
     */
    public UUID getMapId() {
        return MapId;
    }

    /**
     * 
     * @param MapId
     *     The MapId
     */
    public void setMapId(UUID MapId) {
        this.MapId = MapId;
    }

    /**
     * 
     * @return
     *     The MapVariant
     */
    public com.wilyra.halocompanion.haloapi.model.match.MapVariant getMapVariant() {
        return MapVariant;
    }

    /**
     * 
     * @param MapVariant
     *     The MapVariant
     */
    public void setMapVariant(com.wilyra.halocompanion.haloapi.model.match.MapVariant MapVariant) {
        this.MapVariant = MapVariant;
    }

    /**
     * 
     * @return
     *     The GameBaseVariantId
     */
    public UUID getGameBaseVariantId() {
        return GameBaseVariantId;
    }

    /**
     * 
     * @param GameBaseVariantId
     *     The GameBaseVariantId
     */
    public void setGameBaseVariantId(UUID GameBaseVariantId) {
        this.GameBaseVariantId = GameBaseVariantId;
    }

    /**
     * 
     * @return
     *     The GameVariant
     */
    public com.wilyra.halocompanion.haloapi.model.match.GameVariant getGameVariant() {
        return GameVariant;
    }

    /**
     * 
     * @param GameVariant
     *     The GameVariant
     */
    public void setGameVariant(com.wilyra.halocompanion.haloapi.model.match.GameVariant GameVariant) {
        this.GameVariant = GameVariant;
    }

    /**
     * 
     * @return
     *     The MatchDuration
     */
    public String getMatchDuration() {
        return MatchDuration;
    }

    /**
     * 
     * @param MatchDuration
     *     The MatchDuration
     */
    public void setMatchDuration(String MatchDuration) {
        this.MatchDuration = MatchDuration;
    }

    /**
     * 
     * @return
     *     The MatchCompletedDate
     */
    public com.wilyra.halocompanion.haloapi.model.match.MatchCompletedDate getMatchCompletedDate() {
        return MatchCompletedDate;
    }

    /**
     * 
     * @param MatchCompletedDate
     *     The MatchCompletedDate
     */
    public void setMatchCompletedDate(com.wilyra.halocompanion.haloapi.model.match.MatchCompletedDate MatchCompletedDate) {
        this.MatchCompletedDate = MatchCompletedDate;
    }

    /**
     * 
     * @return
     *     The Teams
     */
    public Team[] getTeams() {
        return Teams;
    }

    /**
     * 
     * @param Teams
     *     The Teams
     */
    public void setTeams(Team[] Teams) {
        this.Teams = Teams;
    }

    /**
     * 
     * @return
     *     The Players
     */
    public Player[] getPlayers() {
        return Players;
    }

    /**
     * 
     * @param Players
     *     The Players
     */
    public void setPlayers(Player[] Players) {
        this.Players = Players;
    }

    /**
     * 
     * @return
     *     The IsTeamGame
     */
    public boolean getIsTeamGame() {
        return IsTeamGame;
    }

    /**
     * 
     * @param IsTeamGame
     *     The IsTeamGame
     */
    public void setIsTeamGame(boolean IsTeamGame) {
        this.IsTeamGame = IsTeamGame;
    }

    /**
     * 
     * @return
     *     The SeasonId
     */
    public Object getSeasonId() {
        return SeasonId;
    }

    /**
     * 
     * @param SeasonId
     *     The SeasonId
     */
    public void setSeasonId(Object SeasonId) {
        this.SeasonId = SeasonId;
    }

}
