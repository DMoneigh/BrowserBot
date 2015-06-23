package org.browserbot.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import org.browserbot.ui.handler.BrowserDownloadHandler;

import com.teamdev.jxbrowser.chromium.DownloadItem;

/**
 * The "File Download" window.
 * 
 * @author Desmond Jackson
 */
public class BrowserDownloadWindow extends JFrame implements ActionListener, WindowListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 2410136199201371583L;

	/**
	 * The download handler.
	 */
	private BrowserDownloadHandler downloadHandler;

	/**
	 * The progress bar.
	 */
	private JProgressBar progressBar = new JProgressBar();
	
	/**
	 * The "Speed" label.
	 */
	private JLabel speedLabel = new JLabel("Speed: 0 B/s");
	
	/**
	 * The "Cancel" button.
	 */
	private JButton cancelButton = new JButton("Cancel");

	/**
	 * Creates the "File Download" window.
	 * 
	 * @param downloadHandler The download handler
	 */
	public BrowserDownloadWindow(BrowserDownloadHandler downloadHandler) {
		super("File Download");
		this.downloadHandler = downloadHandler;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(200, 100);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);
		add(progressBar, BorderLayout.NORTH);
		add(speedLabel, BorderLayout.CENTER);
		cancelButton.addActionListener(this);
		add(cancelButton, BorderLayout.SOUTH);
		addWindowListener(this);
	}
	
	/**
	 * Called when download completes.
	 */
	public void updateComplete() {
		cancelButton.setText("Close");
		speedLabel.setText("Download Complete!");
		progressBar.setForeground(Color.GREEN);
	}

	/**
	 * Sets the speed label text to the specified text.
	 * 
	 * @param text The text to change to
	 */
	public void setSpeedLabelText(String text) {
		speedLabel.setText("Speed: " + text + " B/s");
	}

	/**
	 * Sets the progress bar value.
	 * 
	 * @param value The value to set
	 */
	public void setProgressBarValue(int value) {
		progressBar.setValue(value);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DownloadItem item = downloadHandler.getDownloadItem();
		if (!item.isCompleted()) {
			item.cancel();
			item.getDestinationFile().delete();
		}
		dispose();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {
		actionPerformed(null);
	}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
