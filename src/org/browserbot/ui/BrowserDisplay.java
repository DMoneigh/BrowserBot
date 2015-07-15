package org.browserbot.ui;

import org.browserbot.ui.handler.BrowserContextMenuHandler;
import org.browserbot.ui.handler.BrowserDownloadHandler;
import org.browserbot.ui.handler.BrowserPopupHandler;
import org.browserbot.util.FileManager;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.DefaultLoadHandler;
import com.teamdev.jxbrowser.chromium.events.FailLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.FrameLoadEvent;
import com.teamdev.jxbrowser.chromium.events.LoadEvent;
import com.teamdev.jxbrowser.chromium.events.LoadListener;
import com.teamdev.jxbrowser.chromium.events.ProvisionalLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.StartLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.StatusEvent;
import com.teamdev.jxbrowser.chromium.events.StatusListener;
import com.teamdev.jxbrowser.chromium.events.TitleEvent;
import com.teamdev.jxbrowser.chromium.events.TitleListener;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import com.teamdev.jxbrowser.chromium.swing.DefaultDialogHandler;
import com.teamdev.jxbrowser.chromium.swing.DefaultPrintHandler;

/**
 * The browser display.
 * 
 * @author Desmond Jackson
 */
public class BrowserDisplay extends BrowserView implements LoadListener, StatusListener, TitleListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 8542959336384890530L;

	/**
	 * Creates the browser display.
	 */
	public BrowserDisplay() {
		super(new Browser(new BrowserContext(FileManager.DEFAULT_DIR)));
		Browser browser = getBrowser();
		browser.setContextMenuHandler(new BrowserContextMenuHandler(this));
		browser.setDialogHandler(new DefaultDialogHandler(this));
		browser.setDownloadHandler(new BrowserDownloadHandler());
		browser.setLoadHandler(new DefaultLoadHandler());
		browser.setPopupHandler(new BrowserPopupHandler());
		browser.setPrintHandler(new DefaultPrintHandler(this));
		browser.loadURL("http://www.browserbot.org");
		browser.addTitleListener(this);
		browser.addStatusListener(this);
		browser.addLoadListener(this);
	}
	
	/**
	 * Gets the browser tab.
	 * 
	 * @return The browser tab
	 */
	public BrowserTab getTab() {
		return (BrowserTab) getParent();
	}

	@Override
	public void onTitleChange(TitleEvent arg0) {
		getTab().getTabComponent().getTitleLabel().setToolandText(getBrowser().getTitle());
		getTab().getToolBar().getAddressBar().setText(getBrowser().getURL());
	}

	@Override
	public void onStatusChange(StatusEvent arg0) {
		onTitleChange(null);
	}

	@Override
	public void onDocumentLoadedInFrame(FrameLoadEvent arg0) {}

	@Override
	public void onDocumentLoadedInMainFrame(LoadEvent arg0) {}

	@Override
	public void onFailLoadingFrame(FailLoadingEvent arg0) {}

	@Override
	public void onFinishLoadingFrame(FinishLoadingEvent arg0) {
		getTab().getToolBar().getStopButton().setEnabled(false);
		getTab().getToolBar().toggleNavigationButtons();
	}

	@Override
	public void onProvisionalLoadingFrame(ProvisionalLoadingEvent arg0) {}

	@Override
	public void onStartLoadingFrame(StartLoadingEvent arg0) {
		getTab().getToolBar().getStopButton().setEnabled(true);
		getTab().getToolBar().toggleNavigationButtons();
	}

}
