package org.browserbot.ui.menu;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.browserbot.ui.BrowserMenu;
import org.browserbot.ui.menuitem.ActualSizeMenuItem;
import org.browserbot.ui.menuitem.ReloadThisPageMenuItem;
import org.browserbot.ui.menuitem.StopMenuItem;
import org.browserbot.ui.menuitem.ZoomInMenuItem;
import org.browserbot.ui.menuitem.ZoomOutMenuItem;

public class ViewMenu extends BrowserMenu implements ChangeListener {

	private static final long serialVersionUID = -3109821477561973176L;
	
	private StopMenuItem stopMenuItem;

	public ViewMenu() {
		super("View");
		addChangeListener(this);
	}

	@Override
	public void addMenuItems() {
		stopMenuItem = new StopMenuItem();
		add(stopMenuItem);
		add(new ReloadThisPageMenuItem());
		add(new ActualSizeMenuItem());
		add(new ZoomInMenuItem());
		add(new ZoomOutMenuItem());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		stopMenuItem.setEnabled(getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay()
				.getBrowser().isLoading());
	}

}
