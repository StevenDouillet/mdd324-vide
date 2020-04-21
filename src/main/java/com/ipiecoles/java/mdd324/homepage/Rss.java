package com.ipiecoles.java.mdd324.homepage;

public class Rss {
    private Channel channel;

    public Rss(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
