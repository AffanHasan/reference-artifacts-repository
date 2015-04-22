package com.rc.wefunit;

import com.bowstreet.util.IXml;
import com.bowstreet.util.SystemProperties;
import com.bowstreet.util.SystemTrace;
import com.bowstreet.util.cache.CacheManager;
import com.bowstreet.webapp.*;
import com.bowstreet.webapp.util.URLMapper;
import com.bowstreet.webapp.util.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Affan Hasan on 4/22/15.
 */
class WebAppAccessMock implements WebAppAccess {
    @Override
    public void processPage(String s) {

    }

    @Override
    public Object callMethod(String s) {
        return null;
    }

    @Override
    public Object callMethod(String s, Object o) {
        return null;
    }

    @Override
    public Object callMethod(String s, Object o, Object o1) {
        return null;
    }

    @Override
    public Object callMethod(String s, Object o, Object o1, Object o2) {
        return null;
    }

    @Override
    public Object callMethod(String s, Object o, Object o1, Object o2, Object o3) {
        return null;
    }

    @Override
    public Object callMethod(String s, Object o, Object o1, Object o2, Object o3, Object o4) {
        return null;
    }

    @Override
    public Object callMethod(String s, Object[] objects) {
        return null;
    }

    @Override
    public Object fireEvent(String s, Object[] objects) {
        return null;
    }

    @Override
    public Object fireEvent(Object o, String s, Object[] objects) {
        return null;
    }

    @Override
    public LinkedModel addLinkedModel(String s, String s1, boolean b) {
        return null;
    }

    @Override
    public LinkedModel getLinkedModel(String s) {
        return null;
    }

    @Override
    public void logError(String s, Throwable throwable) {

    }

    @Override
    public void freeWebApp() {

    }

    @Override
    public CacheManager getOutputCacheManager() {
        return null;
    }

    @Override
    public WebApp getWebApp() {
        return null;
    }

    @Override
    public WebAppData getWebAppData() {
        return null;
    }

    @Override
    public void freeLinkedModel(String s) {

    }

    @Override
    public WebAppAccess getLinkedModelInstance(String s) {
        return null;
    }

    @Override
    public Variables getVariables() {
        return null;
    }

    @Override
    public RequestInputs getRequestInputs() {
        return null;
    }

    @Override
    public SystemProperties getSystemProperties() {
        return null;
    }

    @Override
    public RequestData getRequestData() {
        return null;
    }

    @Override
    public HttpServletRequest getHttpServletRequest() {
        return null;
    }

    @Override
    public HttpServletResponse getHttpServletResponse() {
        return null;
    }

    @Override
    public String getModelName() {
        return null;
    }

    @Override
    public URLMapper getURLMapper() {
        return null;
    }

    @Override
    public URLMapper getDefaultURLMapper() {
        return null;
    }

    @Override
    public String getActionURL(String s) {
        return null;
    }

    @Override
    public String getPartialPageRefreshURL(String s, boolean b) {
        return null;
    }

    @Override
    public URLMapper getPartialPageRefreshURLMapper(boolean b) {
        return null;
    }

    @Override
    public String getBackchannelActionURL(String s, boolean b) {
        return null;
    }

    @Override
    public URLMapper getBackchannelURLMapper(boolean b) {
        return null;
    }

    @Override
    public SystemTrace addSystemTrace(int i, String s) {
        return null;
    }

    @Override
    public SystemTrace setSystemTrace(SystemTrace systemTrace) {
        return null;
    }

    @Override
    public Object processAction(String s) {
        return null;
    }

    @Override
    public Object processAction(String s, Object[] objects) {
        return null;
    }

    @Override
    public WebAppAccess getModelInstance(String s, String s1, boolean b) {
        return null;
    }

    @Override
    public UserInfo getUserInfo() {
        return null;
    }

    @Override
    public Object getProfileData(String s, String s1) {
        return null;
    }

    @Override
    public String getCurrentPage() {
        return null;
    }

    @Override
    public void setCurrentPage(String s) {

    }

    @Override
    public void resetCurrentPage(String s) {

    }

    @Override
    public String getInstanceID() {
        return null;
    }

    @Override
    public IXml getDataServiceParameterXml(String s, String s1, String s2, String s3) {
        return null;
    }

    @Override
    public String getDataServiceParameterText(String s, String s1, String s2, String s3) {
        return null;
    }

    @Override
    public void addRequestCompleteListener(RequestCompleteListener requestCompleteListener) {

    }
}
