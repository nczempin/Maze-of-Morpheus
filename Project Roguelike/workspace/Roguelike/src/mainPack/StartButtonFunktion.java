package mainPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonFunktion implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		// Startet Spiel
		final Client client = new Client();
		client.run();

	}

}
