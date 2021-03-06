package com.ipiecoles.java.mdd324.homepage;

import java.util.List;

public class Item {
    private String title;
    private String pubDate;
    private String description;
    private String link;

    public Item(String title, String pubDate, String description, String link) {
        this.title = title;
        this.pubDate = pubDate;
        this.description = description;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
