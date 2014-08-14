package com.jivesoftware.selenium.pagefactory.framework.pages;

import com.jivesoftware.selenium.pagefactory.framework.actions.SeleniumActions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

/**
 * Base class for a SubPage. Implements the default pageLoadHook that waits for the page identifier to be present.
 * <p/>
 * Subclasses should call super.pageLoadHook() if they want to wait on the page identifier.
 */
public class BaseSubPage implements SubPage {
    @SuppressWarnings("unused")
    private static Logger logger = LoggerFactory.getLogger(BaseSubPage.class);
    private static final PageUtils PAGE_UTILS = new PageUtils();
    protected SeleniumActions a;
    protected Page parent = null;

    public final void setParent(Page parent) {
        this.parent = parent;
    }

    public final Page getParent() {
        return this.parent;
    }

    public final boolean hasParent() {
        return this.parent != null;
    }

    public final SeleniumActions getActions() {
        return a;
    }

    public final void setActions(SeleniumActions actions) {
        this.a = actions;
    }

    @Override
    public void pageLoadHook() {
        PAGE_UTILS.defaultPageLoadHook(this, a);
    }

    @Nullable
    @Override
    public String getPageIdentifierCSS() {
        return null;
    }

    @Override
    public String getPageContainerCSS() {
        return "body";
    }

    public final void initSubPages() {
        PAGE_UTILS.initSubPages(this, a);
    }

    @Override
    public final void refreshElements() {
        PageFactory.initElements(getActions().getBrowser().getWebDriver(), this);
        initSubPages();
        pageLoadHook();
    }

    @Override
    public final void refreshPage() {
        getActions().getBrowser().refreshPage();
        refreshElements();
    }

}
