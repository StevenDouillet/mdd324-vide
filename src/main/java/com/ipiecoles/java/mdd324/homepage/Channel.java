package com.ipiecoles.java.mdd324.homepage;

import java.util.List;

public class Channel {
    private String title;
    private String description;
    private String copyright;
    private String link;
    private String pubDate;
    private String langage;
    private List<Item> items;

    public Channel(String title, String description, String copyright, String link, String pubDate, String langage) {
        this.title = title;
        this.description = description;
        this.copyright = copyright;
        this.link = link;
        this.pubDate = pubDate;
        this.langage = langage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", copyright='" + copyright + '\'' +
                ", link='" + link + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", langage='" + langage + '\'' +
                ", items=" + items +
                '}';
    }
}
