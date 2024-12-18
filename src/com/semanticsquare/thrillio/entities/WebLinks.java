package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.partner.Shareable;

public class WebLinks  extends Bookmark implements Shareable {
    public String getUrl;
    public  String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUrl() {
        return getUrl;
    }

    public void setUrl(String getUrl) {
        this.getUrl = getUrl;
    }

    @Override
    public String toString() {
        return "WebLinks{" +
                "getUrl='" + getUrl + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

    @Override
    public boolean isKidFriendlyEligible() {
        if (getUrl.contains("porn") || getTitle().contains("porn") ||host.contains("adult")){
            return false;
        }
        return true;
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<type>WebLink</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<url>").append(getUrl).append("</url>");
        builder.append("<host>").append(host).append("</host>");
        builder.append("</item>");
        return builder.toString();
    }
}
