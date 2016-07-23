package com.example.tom.testapplication.cardview;

public class CardViewModel {

    public final String title, content, siteName, faviconUri;
    public long time;

    private CardViewModel(String title, String content, String siteName, String faviconUri, long time) {
        this.title = title;
        this.content = content;
        this.siteName = siteName;
        this.faviconUri = faviconUri;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + ", Content: " + this.content;
    }

    public static class Builder {

        private String title, content, siteName, faviconUri;
        private long time;

        public Builder() {
            this.title = "Default Title";
            this.content = "Default Content";
            this.siteName = "Default Site Name";
            this.faviconUri = "http://www.quora.com";
            this.time = System.currentTimeMillis();
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setSiteName(String siteName) {
            this.siteName = siteName;
            return this;
        }

        public Builder setFaviconUri(String faviconUri) {
            this.faviconUri = faviconUri;
            return this;
        }

        public Builder setTime(long time) {
            this.time = time;
            return this;
        }

        public CardViewModel build() {
            return new CardViewModel(title, content, siteName, faviconUri, time);
        }

    }

}
