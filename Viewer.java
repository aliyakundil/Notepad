import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

class Viewer {

	private JTextArea textArea;
	private JFrame frame;

    public Viewer() {
		Controller controller = new Controller(this);

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);

		JMenuBar jMenuBar = new JMenuBar();

		JMenu menuFile = new JMenu("File");

		JMenuItem createMenuItem = new JMenuItem("New", new ImageIcon("images/New.gif"));
		createMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		createMenuItem.setActionCommand("New Document");
        createMenuItem.addActionListener(controller);

		JMenuItem openMenuItem = new JMenuItem("Open", new ImageIcon("images/Open.gif"));
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openMenuItem.addActionListener(controller);
		openMenuItem.setActionCommand("Open File");

		JMenuItem saveMenuItem = new JMenuItem("Save", new ImageIcon("images/Save.gif"));
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveMenuItem.addActionListener(controller);
		saveMenuItem.setActionCommand("Save File");

		JMenuItem saveAsMenuItem = new JMenuItem("Save As ...", new ImageIcon("images/Save as.gif"));
        saveAsMenuItem.addActionListener(controller);
		saveAsMenuItem.setActionCommand("Save As File");

		JMenuItem pageSetupMenuItem = new JMenuItem("Page Setup ...", new ImageIcon("images/Page setup.gif"));

		JMenuItem printMenuItem = new JMenuItem("Print ...", new ImageIcon("images/Print.gif"));
		printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        printMenuItem.addActionListener(controller);
		printMenuItem.setActionCommand("Print");

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setActionCommand("Exit");
		exitMenuItem.addActionListener(controller);

		menuFile.add(createMenuItem);
		menuFile.add(openMenuItem);
		menuFile.add(saveMenuItem);
		menuFile.add(saveAsMenuItem);
		menuFile.add(new JSeparator());
		menuFile.add(pageSetupMenuItem);
		menuFile.add(printMenuItem);
		menuFile.add(new JSeparator());
		menuFile.add(exitMenuItem);

		JMenu menuEdit = new JMenu("Edite");

		JMenuItem undoMenuItem = new JMenuItem("Undo", new ImageIcon("images/Undo.gif"));
		undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undoMenuItem.addActionListener(controller);
		undoMenuItem.setActionCommand("Undo");

		JMenuItem cutMenuItem = new JMenuItem("Cut", new ImageIcon("images/Cut.gif"));
		cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cutMenuItem.addActionListener(controller);
		cutMenuItem.setActionCommand("Cut");

		JMenuItem copyMenuItem = new JMenuItem("Copy", new ImageIcon("images/Copy.gif"));
		copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copyMenuItem.addActionListener(controller);
		copyMenuItem.setActionCommand("Copy");

		JMenuItem pasteMenuItem = new JMenuItem("Paste", new ImageIcon("images/Paste.gif"));
		pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        pasteMenuItem.addActionListener(controller);
		pasteMenuItem.setActionCommand("Paste");

		JMenuItem deleteMenuItem = new JMenuItem("Delete", new ImageIcon("images/Delete.gif"));
		deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        deleteMenuItem.addActionListener(controller);
		deleteMenuItem.setActionCommand("Delete");

		JMenuItem findMenuItem = new JMenuItem("Find ...", new ImageIcon("images/Find.gif"));
		findMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));

		JMenuItem findNextMenuItem = new JMenuItem("Find Next ...", new ImageIcon("images/Find next.gif"));
		findNextMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));

		JMenuItem replaceMenuItem = new JMenuItem("Replace", new ImageIcon("images/Replace.gif"));
		replaceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        replaceMenuItem.addActionListener(controller);
		replaceMenuItem.setActionCommand("Replace");

		JMenuItem goToMenuItem = new JMenuItem("Go To ...", new ImageIcon("images/Go to.gif"));
		goToMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));

		JMenuItem selectAllMenuItem = new JMenuItem("Select All", new ImageIcon("images/Select all.gif"));
		selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

		JMenuItem timeDateMenuItem = new JMenuItem("Time/Date", new ImageIcon("images/Time.gif"));
		timeDateMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));

		menuEdit.add(undoMenuItem);
		menuEdit.add(new JSeparator());
		menuEdit.add(cutMenuItem);
		menuEdit.add(copyMenuItem);
		menuEdit.add(pasteMenuItem);
		menuEdit.add(deleteMenuItem);
		menuEdit.add(new JSeparator());
		menuEdit.add(findMenuItem);
		menuEdit.add(findNextMenuItem);
		menuEdit.add(replaceMenuItem);
		menuEdit.add(goToMenuItem);
		menuEdit.add(new JSeparator());
		menuEdit.add(selectAllMenuItem);
		menuEdit.add(timeDateMenuItem);

		JMenu menuFormat = new JMenu("Format");
		JMenuItem wordWrapMenuItem = new JMenuItem("Word Wrap", new ImageIcon("images/Word wrap.gif"));
		JMenuItem fondMenuItem = new JMenuItem("Font ...", new ImageIcon("images/Font.gif"));
		menuFormat.add(wordWrapMenuItem);
		menuFormat.add(fondMenuItem);      

		JMenu menuViewer = new JMenu("Viewer");
		JMenuItem statusBarMenuItem = new JMenuItem("Status Bar");
		menuViewer.add(statusBarMenuItem);

		JMenu menuHelp = new JMenu("Help");
		JMenuItem viewerHelpMenuItem = new JMenuItem("Viewe Help");
		JMenuItem aboutNotepadeMenuItem = new JMenuItem("About Notepade");
        aboutNotepadeMenuItem.addActionListener(controller);
		aboutNotepadeMenuItem.setActionCommand("About Notepade");
		menuHelp.add(viewerHelpMenuItem);
		menuHelp.add(new JSeparator());
		menuHelp.add(aboutNotepadeMenuItem);      

		jMenuBar.add(menuFile);
		jMenuBar.add(menuEdit);
		jMenuBar.add(menuFormat);
		jMenuBar.add(menuViewer);
		jMenuBar.add(menuHelp);

		frame = new JFrame("Notepad Aliya");
		frame.setSize(600,400);
		frame.setLocation(300,200);
		frame.add("Center", scroll);
		frame.setJMenuBar(jMenuBar);
		frame.setVisible(true);
	
	}

	public void update(String text) {
		textArea.setText(text);
	}

	public JFrame getMainFrame() {
		return frame;
	}

    public JTextArea getTextField() {
		return textArea;
    }

    public String getTextFromTextArea() {
		return textArea.getText();
    }

    public void setTextFromTextArea(String text) {
		textArea.setText(text);
    }

    public void setAlmas(String name) {
		frame.setTitle(name + " - Notepad");
    }


}