package pl.ether.Web.interfaces;

public interface URLDownloaderI {
	/*
	 * Funkcja pobiera kod �r�d�owy strony
	 */
	public String getPageSource();
	/*
	 * Funkcja ma za zadanie szybkie sprawdzenie czy kod �r�d�owy si� zmieni�
	 * poprzez por�wnanie sum kontrolnych.
	 * Przy ka�dym pobraniu strony jest wyliczana jej 8 znakowa.
	 */
	public boolean isPageChangedFastCheck();
	/*
	 * Funkcja wylicza sume kontrolon� dla strony
	 */
	public String countHash();
}
