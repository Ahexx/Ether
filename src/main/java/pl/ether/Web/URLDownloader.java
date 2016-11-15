package pl.ether.Web;

public interface URLDownloader {

    String getPageSource();

    boolean isPageChangedFastCheck();

    String countHash();

    boolean isTimeToRefresh();

    boolean checkWebSite();
}