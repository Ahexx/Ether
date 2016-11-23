package pl.ether.Main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pl.ether.models.WebSite;

public class StateService {
	private File plik;
	private static Logger log = Logger.getLogger(StateService.class);
	public StateService() {
		plik = new File("data.dat");
		try {
		if (!plik.exists()) {
			
				if (!plik.createNewFile()) {
					log.error("ERROR Nie udało się stworzyć pliku danych 'data.dat'");
				} else {
					log.info("Stworzono nowy plik danych 'data.dat'");
				}
			
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("ERROR podczas tworzenia pliku 'data.dat':\n" + e);
		}
	}
	
	public void save(List<WebSite> lista) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(plik));
			oos.writeInt(lista.size()); // zapisuje ile obiektów mam w liście
			lista.stream().forEach(site -> {
				try {
					oos.writeObject(site);
				} catch (IOException e) {
					
					log.error("ERROR podczas zapisu strony: \n"
							+ site+"\n"
									+ e );
				}
			});
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("ERROR podczas zapisu stron " + e);
			
		}
		
	}
	public List<WebSite> read() {
		List<WebSite> retn = new ArrayList<>();
		if (plik.length() == 0) {
			return retn;
		}
		try {
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(plik));
			int iloscStron = ois.readInt();
			for (int i = 0; i < iloscStron; i++) {
				WebSite w = (WebSite) ois.readObject();
				retn.add(w);
			}
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("ERROR przy odczycie listy WebSite ");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.error("ERROR nie udało się skonwertować obiektu z pliku na WebSite " + e);
		}
		return retn;
	}
}
