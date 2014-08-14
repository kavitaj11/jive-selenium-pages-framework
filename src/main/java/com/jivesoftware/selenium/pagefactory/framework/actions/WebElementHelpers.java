package com.jivesoftware.selenium.pagefactory.framework.actions;

import com.google.common.collect.Lists;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Static helper methods that don't require a WebDriver instance belong here.
 */
public class WebElementHelpers {
    /**
     * Determine whether the given WebElement has the given Class
     *
     * @param webElement element to check
     * @param className  to search for
     * @return boolean
     */
    public static boolean webElementHasClass(WebElement webElement, String className) {
        return getCssClasses(webElement).contains(className);
    }

    /**
     * Get the CSS classes of a given WebElement. Split on whitespace in case it's possible to have multiple spaces in the
     * "class" attribute of an HTML element.
     *
     * @param webElement
     * @return
     */
    public static List<String> getCssClasses(WebElement webElement) {
        if (webElement.getAttribute("class") == null) {
            return Lists.newArrayList();
        }
        return Lists.newArrayList(webElement.getAttribute("class").split("\\s+"));
    }
}
