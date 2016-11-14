package pl.ether.Web.interfaces;

import pl.ether.models.WebSite;

public interface URLDownloaderI {
	/*
	 * Funkcja pobiera kod Ÿród³owy strony
	 */
	public String getPageSource();
	/*
	 * Funkcja ma za zadanie szybkie sprawdzenie czy kod Ÿród³owy siê zmieni³
	 * poprzez porównanie sum kontrolnych.
	 * Przy ka¿dym pobraniu strony jest wyliczana jej 8 znakowa.
	 */
	public boolean isPageChangedFastCheck();
	/*
	 * Funkcja wylicza sume kontrolon¹ dla strony
	 */
	public String countHash();
	
	public boolean isTimeToRefresh();
	
	public boolean checkWebSite();
}
