package com.sun.parent.facade.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.bean.abs.AppInfo.java
 * @Date 13:04 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
public class AppInfo implements Serializable{

    private Long id;

    private List<String> screenShotUrlId;

    private Long ipadScreenShotUrlId;

    private Long appleTvScreenShotUrlId;

    private String artWorkUrl512;

    private String artistViewUrl;

    private String artWorkUrl60;

    private String artWorkUrl100;

    private String supportedDevices;

    private String kind;

    private String features;

    private String advisories;

    private Boolean isGameCenterEnabled;

    private String averageUserRatingForCurrentversion;

    private String languageCodesIso2a;

    private String fileSizeBytes;

    private String userRatingCountForCurrentVersion;

    private String trackContentRating;

    private String contentAdvisoryRating;

    private String trackViewUrl;

    private String trackCensoredName;

    private String isVppDeviceBasedLicensingEnabled;

    private String sellerName;

    private Date releaseDate;

    private String trackId;

    private String trackName;

    private String primaryGenreName;

    private String primaryGenreId;

    private String currency;

    private String wrapperType;

    private String version;

    private String artistId;

    private String artistName;

    private Long price;

    private String bundleId;

    private String releaseNotes;

    private Date currentVersionReleaseDate;

    private String minimumOsVersion;

    private String formattedPrice;

    private String averageUserRating;

    private String userRatingCount;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getScreenShotUrlId() {
        return screenShotUrlId;
    }

    public void setScreenShotUrlId(List<String> screenShotUrlId) {
        this.screenShotUrlId = screenShotUrlId;
    }

    public Long getIpadScreenShotUrlId() {
        return ipadScreenShotUrlId;
    }

    public void setIpadScreenShotUrlId(Long ipadScreenShotUrlId) {
        this.ipadScreenShotUrlId = ipadScreenShotUrlId;
    }

    public Long getAppleTvScreenShotUrlId() {
        return appleTvScreenShotUrlId;
    }

    public void setAppleTvScreenShotUrlId(Long appleTvScreenShotUrlId) {
        this.appleTvScreenShotUrlId = appleTvScreenShotUrlId;
    }

    public String getArtWorkUrl512() {
        return artWorkUrl512;
    }

    public void setArtWorkUrl512(String artWorkUrl512) {
        this.artWorkUrl512 = artWorkUrl512;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getArtWorkUrl60() {
        return artWorkUrl60;
    }

    public void setArtWorkUrl60(String artWorkUrl60) {
        this.artWorkUrl60 = artWorkUrl60;
    }

    public String getArtWorkUrl100() {
        return artWorkUrl100;
    }

    public void setArtWorkUrl100(String artWorkUrl100) {
        this.artWorkUrl100 = artWorkUrl100;
    }

    public String getSupportedDevices() {
        return supportedDevices;
    }

    public void setSupportedDevices(String supportedDevices) {
        this.supportedDevices = supportedDevices;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getAdvisories() {
        return advisories;
    }

    public void setAdvisories(String advisories) {
        this.advisories = advisories;
    }

    public Boolean getGameCenterEnabled() {
        return isGameCenterEnabled;
    }

    public void setGameCenterEnabled(Boolean gameCenterEnabled) {
        isGameCenterEnabled = gameCenterEnabled;
    }

    public String getAverageUserRatingForCurrentversion() {
        return averageUserRatingForCurrentversion;
    }

    public void setAverageUserRatingForCurrentversion(String averageUserRatingForCurrentversion) {
        this.averageUserRatingForCurrentversion = averageUserRatingForCurrentversion;
    }

    public String getLanguageCodesIso2a() {
        return languageCodesIso2a;
    }

    public void setLanguageCodesIso2a(String languageCodesIso2a) {
        this.languageCodesIso2a = languageCodesIso2a;
    }

    public String getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(String fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public String getUserRatingCountForCurrentVersion() {
        return userRatingCountForCurrentVersion;
    }

    public void setUserRatingCountForCurrentVersion(String userRatingCountForCurrentVersion) {
        this.userRatingCountForCurrentVersion = userRatingCountForCurrentVersion;
    }

    public String getTrackContentRating() {
        return trackContentRating;
    }

    public void setTrackContentRating(String trackContentRating) {
        this.trackContentRating = trackContentRating;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getIsVppDeviceBasedLicensingEnabled() {
        return isVppDeviceBasedLicensingEnabled;
    }

    public void setIsVppDeviceBasedLicensingEnabled(String isVppDeviceBasedLicensingEnabled) {
        this.isVppDeviceBasedLicensingEnabled = isVppDeviceBasedLicensingEnabled;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public String getPrimaryGenreId() {
        return primaryGenreId;
    }

    public void setPrimaryGenreId(String primaryGenreId) {
        this.primaryGenreId = primaryGenreId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getReleaseNotes() {
        return releaseNotes;
    }

    public void setReleaseNotes(String releaseNotes) {
        this.releaseNotes = releaseNotes;
    }

    public Date getCurrentVersionReleaseDate() {
        return currentVersionReleaseDate;
    }

    public void setCurrentVersionReleaseDate(Date currentVersionReleaseDate) {
        this.currentVersionReleaseDate = currentVersionReleaseDate;
    }

    public String getMinimumOsVersion() {
        return minimumOsVersion;
    }

    public void setMinimumOsVersion(String minimumOsVersion) {
        this.minimumOsVersion = minimumOsVersion;
    }

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    public String getAverageUserRating() {
        return averageUserRating;
    }

    public void setAverageUserRating(String averageUserRating) {
        this.averageUserRating = averageUserRating;
    }

    public String getUserRatingCount() {
        return userRatingCount;
    }

    public void setUserRatingCount(String userRatingCount) {
        this.userRatingCount = userRatingCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
