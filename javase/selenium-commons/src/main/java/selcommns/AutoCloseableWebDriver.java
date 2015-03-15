package selcommns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

/**
 * Created by Affan Hasan on 3/15/2015.
 */
class AutoClosableWebDriver implements WebDriver, AutoCloseable {

    private final WebDriver _wd;

    AutoClosableWebDriver( WebDriver wd ){
        this._wd = wd;
    }

    @Override
    public void get(String s) {
        this._wd.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return this._wd.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return this._wd.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this._wd.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this._wd.findElement(by);
    }

    @Override
    public String getPageSource() {
        return this._wd.getPageSource();
    }

    @Override
    public void close() {
        this._wd.close();
    }

    @Override
    public void quit() {
        this._wd.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return this._wd.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return this._wd.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return this._wd.switchTo();
    }

    @Override
    public Navigation navigate() {
        return this._wd.navigate();
    }

    @Override
    public Options manage() {
        return this._wd.manage();
    }
}