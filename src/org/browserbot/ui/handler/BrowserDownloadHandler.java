package org.browserbot.ui.handler;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import org.browserbot.ui.BrowserDownloadWindow;
import org.browserbot.util.FileManager;

import com.teamdev.jxbrowser.chromium.DownloadHandler;
import com.teamdev.jxbrowser.chromium.DownloadItem;
import com.teamdev.jxbrowser.chromium.events.DownloadEvent;
import com.teamdev.jxbrowser.chromium.events.DownloadListener;

/**
 * The browser download handler.
 * 
 * @author Desmond Jackson
 */
public class BrowserDownloadHandler extends Object implements DownloadHandler, DownloadListener {

	/**
	 * The "File Download" window.
	 */
	private BrowserDownloadWindow downloadWindow;

	/**
	 * The download item.
	 */
	private DownloadItem downloadItem;

	/**
	 * Creates the browser download handler.
	 */
	public BrowserDownloadHandler() {
		super();
	}

	/**
	 * Gets the download item.
	 * 
	 * @return The download item
	 */
	public DownloadItem getDownloadItem() {
		return downloadItem;
	}

	@Override
	public void onDownloadUpdated(DownloadEvent event) {
		DownloadItem item = event.getDownloadItem();
		downloadWindow.setProgressBarValue(item.getPercentComplete());
		downloadWindow.setSpeedLabelText(item.getCurrentSpeed() + "");
		if (item.isCompleted())
			downloadWindow.updateComplete();
	}

	@Override
	public boolean allowDownload(DownloadItem item) {
		JFileChooser fileChooser = new JFileChooser(FileManager.STORAGE_DIR);
		downloadWindow = new BrowserDownloadWindow(this);
		if (fileChooser.showDialog(downloadWindow, "Select") == 0) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					downloadWindow.setVisible(true);
				}
				
			});
			downloadItem = item;
			item.setDestinationFile(fileChooser.getSelectedFile());
			item.addDownloadListener(this);
			return true;
		}
		return false;
	}

}
