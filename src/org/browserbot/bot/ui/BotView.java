package org.browserbot.bot.ui;

import java.awt.Dimension;

import org.browserbot.Configuration;

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
import com.teamdev.jxbrowser.chromium.swing.DefaultDownloadHandler;
import com.teamdev.jxbrowser.chromium.swing.DefaultPopupHandler;
import com.teamdev.jxbrowser.chromium.swing.DefaultPrintHandler;

/**
 * Represents a bot view.
 * 
 * @author Desmond Jackson
 */
public class BotView extends BrowserView implements LoadListener, StatusListener, TitleListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 2804097699331967009L;
	
	/**
	 * The bot tab.
	 */
	private BotTab tab;
	
	/**
	 * Creates the bot view.
	 * 
	 * @param tab The bot tab
	 */
	public BotView(BotTab tab) {
		super(new Browser(new BrowserContext(Configuration.DEFAULT_DIR)));
		this.tab = tab;
		setPreferredSize(new Dimension(Configuration.BOT_UI_WIDTH, Configuration.BOT_UI_HEIGHT));
		Browser browser = getBrowser();
		browser.setDialogHandler(new DefaultDialogHandler(this));
		browser.setDownloadHandler(new DefaultDownloadHandler(this));
		browser.setLoadHandler(new DefaultLoadHandler());
		browser.setPopupHandler(new DefaultPopupHandler());
		browser.setPrintHandler(new DefaultPrintHandler(this));
		browser.loadURL(Configuration.HOME_URL);
		browser.addLoadListener(this);
		browser.addStatusListener(this);
		browser.addTitleListener(this);
	}
	
	/**
	 * Gets the bot tab.
	 * 
	 * @return The bot tab
	 */
	public BotTab getTab() {
		return tab;
	}
	
	@Override
	public void onDocumentLoadedInFrame(FrameLoadEvent arg0) {}

	@Override
	public void onDocumentLoadedInMainFrame(LoadEvent arg0) {}

	@Override
	public void onFailLoadingFrame(FailLoadingEvent arg0) {}

	@Override
	public void onFinishLoadingFrame(FinishLoadingEvent arg0) {
		tab.getToolBar().setStopButtonEnabled(false);
		tab.getToolBar().toggleNavigationButtons();
	}

	@Override
	public void onProvisionalLoadingFrame(ProvisionalLoadingEvent arg0) {}

	@Override
	public void onStartLoadingFrame(StartLoadingEvent arg0) {
		tab.getToolBar().setStopButtonEnabled(true);
		tab.getToolBar().toggleNavigationButtons();
	}
	
	@Override
	public void onStatusChange(StatusEvent arg0) {
		onTitleChange(null);
	}

	@Override
	public void onTitleChange(TitleEvent event) {
		tab.getTabComponent().setTitleLabelText(getBrowser().getTitle());
		tab.getToolBar().setAddressBarText(getBrowser().getURL());
	}

}
