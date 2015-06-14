package mainPack;

// Importiere Awt und Swing Bibliothek
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

public class Client {
	// Deklaration ! Bitte eine Ordnung einbringen (Strings untereinander oder ints untereinander!)!

	private static final long serialVersionUID = 1L;

	private final int frameBreite = 1024;
	private final int frameHoehe = 788;
	private final int blockGroesse = 32;
	private final int statsBreite = 52;
	public String lvl;

	private final int breiteInBlock = frameBreite / blockGroesse; // 32
	private final int hoeheInBlock = (frameHoehe - statsBreite) / blockGroesse; // 23

	private final String spielTitel = "Roguelike";

	private int playerX = 1;
	private int playerY = 11;

	private JFrame frame;
	private JSplitPane statsUndBoardSplit;
	private JSplitPane levelHerz;
	private JSplitPane herz1;
	private JSplitPane herz2;
	private JSplitPane herz3;
	private JSplitPane herz4;
	private JPanel boardPanel;
	private JPanel statsPanel;

	// Setzt alle Bilder als lokale Variablen
	private final ImageIcon flieseBild = new ImageIcon(getClass().getResource("Fliese" + blockGroesse + ".png"));
	private final ImageIcon wandBild = new ImageIcon(getClass().getResource("Wand" + blockGroesse + ".png"));
	private final ImageIcon ausgangBild = new ImageIcon(getClass().getResource("Ausgang" + blockGroesse + ".png"));
	private final ImageIcon spielerBild = new ImageIcon(getClass().getResource("Spieler" + blockGroesse + ".png"));
	private final ImageIcon spielerUpBild = new ImageIcon(getClass().getResource("Spieler" + blockGroesse + ".png"));
	private final ImageIcon spielerDownBild = new ImageIcon(getClass().getResource("Spieler" + blockGroesse + ".png"));
	private final ImageIcon spielerRightBild = new ImageIcon(getClass().getResource("Spieler" + blockGroesse + ".png"));
	private final ImageIcon spielerLeftBild = new ImageIcon(getClass().getResource("Spieler" + blockGroesse + ".png"));
	private final ImageIcon herzBild = new ImageIcon(getClass().getResource("Herz-Dungen.png"));

	private final JLabel[][] board = {
			{ new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild),
				new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild),
				new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild),
				new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild) },
				{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
					new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
					new JLabel(spielerBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
					new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
					new JLabel(flieseBild), new JLabel(wandBild) },
					{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
						new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
						new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
						new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
						new JLabel(flieseBild), new JLabel(wandBild) },
						{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
							new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
							new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
							new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
							new JLabel(flieseBild), new JLabel(wandBild) },
							{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
								new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
								new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
								new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
								new JLabel(flieseBild), new JLabel(wandBild) },
								{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
									new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
									new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
									new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
									new JLabel(flieseBild), new JLabel(wandBild) },
									{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
										new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
										new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
										new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
										new JLabel(flieseBild), new JLabel(wandBild) },
										{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
											new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
											new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
											new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
											new JLabel(flieseBild), new JLabel(wandBild) },
											{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
												new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
												new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
												new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
												new JLabel(flieseBild), new JLabel(wandBild) },
												{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
													new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
													new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
													new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
													new JLabel(flieseBild), new JLabel(wandBild) },
													{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
														new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
														new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
														new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
														new JLabel(flieseBild), new JLabel(wandBild) },
														{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
															new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
															new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
															new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
															new JLabel(flieseBild), new JLabel(wandBild) },
															{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																new JLabel(flieseBild), new JLabel(wandBild) },
																{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																	new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																	new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																	new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																	new JLabel(flieseBild), new JLabel(wandBild) },
																	{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																		new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																		new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																		new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																		new JLabel(flieseBild), new JLabel(wandBild) },
																		{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																			new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																			new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																			new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																			new JLabel(flieseBild), new JLabel(wandBild) },
																			{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																				new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																				new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																				new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																				new JLabel(flieseBild), new JLabel(wandBild) },
																				{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																					new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																					new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																					new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																					new JLabel(flieseBild), new JLabel(wandBild) },
																					{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																						new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																						new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																						new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																						new JLabel(flieseBild), new JLabel(wandBild) },
																						{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																							new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																							new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																							new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																							new JLabel(flieseBild), new JLabel(wandBild) },
																							{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																								new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																								new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																								new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																								new JLabel(flieseBild), new JLabel(wandBild) },
																								{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																									new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																									new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																									new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																									new JLabel(flieseBild), new JLabel(wandBild) },
																									{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																										new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																										new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																										new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																										new JLabel(flieseBild), new JLabel(wandBild) },
																										{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																											new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																											new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																											new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																											new JLabel(flieseBild), new JLabel(wandBild) },
																											{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																												new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																												new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																												new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																												new JLabel(flieseBild), new JLabel(wandBild) },
																												{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																													new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																													new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																													new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																													new JLabel(flieseBild), new JLabel(wandBild) },
																													{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																														new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																														new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																														new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																														new JLabel(flieseBild), new JLabel(wandBild) },
																														{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																															new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																															new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																															new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																															new JLabel(flieseBild), new JLabel(wandBild) },
																															{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																new JLabel(flieseBild), new JLabel(wandBild) },
																																{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																	new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																	new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																	new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																	new JLabel(flieseBild), new JLabel(wandBild) },
																																	{ new JLabel(wandBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																		new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																		new JLabel(ausgangBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																		new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild), new JLabel(flieseBild),
																																		new JLabel(flieseBild), new JLabel(wandBild) },
																																		{ new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild),
																																			new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild),
																																			new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild),
																																			new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild), new JLabel(wandBild) } };

	// Methode durch welche Spiel gestartet wird
	public Client() {
	}

	public void run() {
		// JFrame Fenster erstellen, Titel setzen, sichtbar setzen, Groesse setzen
		frame = new JFrame(spielTitel);
		frame.setSize(frameBreite, frameHoehe);
		// Macht es, dass das Fenster nicht groesser/kleiner gemacht werden kann (weil das nur nervt)
		frame.setResizable(false);
		frame.setDefaultCloseOperation(3);
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(final KeyEvent e) {
				System.out.println("typed: " + e.getKeyChar());
			}

			@Override
			public void keyReleased(final KeyEvent e) {
				System.out.println("byebye: " + e.getKeyChar());
			}

			@Override
			public void keyPressed(final KeyEvent e) {
				System.out.println("hello: " + e.getKeyChar());
			}
		});

		// Erstelle JPanels rasterPanel statsPanel (Quasi ein Fenster in einem Fenster)
		boardPanel = new JPanel(new GridLayout(hoeheInBlock, breiteInBlock, 0, 0));
		statsPanel = new JPanel();

		// Setup des Stats/Board Splits
		statsUndBoardSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, statsPanel, boardPanel);
		statsUndBoardSplit.setDividerSize(0);
		statsUndBoardSplit.setDividerLocation(statsBreite);
		// statsUndBoardSplit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		frame.add(statsUndBoardSplit);

		// Setzen des Spielers aufs Spielbrett:
		board[playerX][playerY].setIcon(spielerBild);

		// Graphischer Anfang:
		for (int y = board[0].length - 1; y >= 0; --y) {
			for (int x = 0; x < board.length; ++x) {
				boardPanel.add(board[x][y]);
			}
		}

		// Graphisches Updaten des Spiels:
		frame.setVisible(true);

		// Test
		lvl = "35";

		// Einf�gen der Level und Herzen Anzeige
		herz4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JLabel(herzBild), new JLabel(herzBild));
		herz4.setDividerSize(0);
		herz4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		herz3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JLabel(herzBild), herz4);
		herz3.setDividerSize(0);
		herz3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		herz2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JLabel(herzBild), herz3);
		herz2.setDividerSize(0);
		herz2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		herz1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JLabel(herzBild), herz2);
		herz1.setDividerSize(0);
		levelHerz = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JLabel(lvl), herz1);
		levelHerz.setDividerSize(0);

		statsPanel.add(levelHerz);

		// addKeyListener(this);
		// setFocusable(true);
		// setFocusTraversalKeysEnabled(false);

		// Simple Veraenderung der Spielbausteine wird durch das Graphische Updaten sehr leicht in Graphik uebertragen:
		/*
		 * Normales Kartesisches Koordinatensystem! Yay! Unten links ist 0/0, rechts ist groessere x, oben groessere y.
		 * board[<x-Koordinate>][<y-Koordinate>].setIcon(<Name des Spielbausteins>Bild);
		 */
		// board[0][5].setIcon(wandBild);

		final JPanel panel = new JPanel();
		final InputMap im = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		final ActionMap am = panel.getActionMap();

		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RightArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LeftArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UpArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DownArrow");

		am.put("RightArrow", new ArrowAction("RightArrow"));
		am.put("LeftArrow", new ArrowAction("LeftArrow"));
		am.put("UpArrow", new ArrowAction("UpArrow"));
		am.put("DownArrow", new ArrowAction("DownArrow"));

	}

	private void moveAny(final int startX, final int startY, final int zielX, final int zielY) {
		board[zielX][zielY].setIcon(board[startX][startY].getIcon());
		board[startX][startY].setIcon(flieseBild);
	}

	private boolean movePlayer(final int zielX, final int zielY) {
		final Icon pieceType = board[zielX][zielY].getIcon();
		if (pieceType.equals(flieseBild)) {
			moveAny(playerX, playerY, zielX, zielY);
			playerX = zielX;
			playerY = zielY;
			return true;
		} else if (pieceType.equals(ausgangBild)) {
			System.exit(0);
			return true;
		}
		return false;

		// Bewegt also nicht, wenn das Ziel zum Beispiel eine Wand ist.
	}

	private void changePlayerIcon(final Icon icon) {
		board[playerX][playerY].setIcon(icon);
	}

	private boolean movePlayerUp() {
		changePlayerIcon(spielerUpBild);
		return movePlayer(playerX, playerY + 1);
	}

	private boolean movePlayerDown() {
		changePlayerIcon(spielerDownBild);
		return movePlayer(playerX, playerY - 1);
	}

	private boolean movePlayerLeft() {
		changePlayerIcon(spielerLeftBild);
		return movePlayer(playerX - 1, playerY);
	}

	private boolean movePlayerRight() {
		changePlayerIcon(spielerRightBild);
		return movePlayer(playerX + 1, playerY);
	}

	// @Override
	// public void actionPerformed(ActionEvent aEvent) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void keyPressed(KeyEvent kEvent) {
	// int keyCode = kEvent.getKeyCode();
	//
	// switch (keyCode) {
	// case KeyEvent.VK_UP:
	// case KeyEvent.VK_W:
	// movePlayerUp();
	// break;
	// case KeyEvent.VK_DOWN:
	// case KeyEvent.VK_S:
	// movePlayerDown();
	// break;
	// case KeyEvent.VK_LEFT:
	// case KeyEvent.VK_A:
	// movePlayerLeft();
	// break;
	// case KeyEvent.VK_RIGHT:
	// case KeyEvent.VK_D:
	// movePlayerRight();
	// break;
	// default:
	// break;
	// }
	// }
	//
	// @Override
	// public void keyReleased(KeyEvent kEvent) {}
	// @Override
	// public void keyTyped(KeyEvent kEvent) {}

	public class ArrowAction extends AbstractAction {

		private final String cmd;

		public ArrowAction(final String cmd) {
			this.cmd = cmd;
		}

		@Override
		public void actionPerformed(final ActionEvent e) {
			if (cmd.equalsIgnoreCase("LeftArrow")) {
				movePlayerLeft();
			} else if (cmd.equalsIgnoreCase("RightArrow")) {
				movePlayerRight();
			} else if (cmd.equalsIgnoreCase("UpArrow")) {
				movePlayerUp();
			} else if (cmd.equalsIgnoreCase("DownArrow")) {
				movePlayerDown();
			}
		}
	}

}

// TODO Bitte immer Rechtschreibfehler anderer korrigieren oder anderweitig Hilfestellung geben. In dem folgendem TO DO bitte Auftr�ge eintragen !

// TODO Bitte macht folgendes: Luca: Janik: Korbi: Maxim: Mach mal 32p/64p bilder Allgemein:

// TODO Maxim: Mach mal 32p/64p bilder