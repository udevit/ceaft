package com.ceaft.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

/**
 * 
 * @author Gary
 *
 */
public abstract class CeaftBaseController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CeaftBaseController() {

	}

	public void printInfoMessage(String summary, String detail) {
		printMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	}
	
	public void printErrorMessage(String summary, String detail) {
		printMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
	}
	
	public void printWarnMessage(String summary, String detail) {
		printMessage(FacesMessage.SEVERITY_WARN, summary, detail);
	}
	
	public void printFatalMessage(String summary, String detail) {
		printMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
	}
	
	private void printMessage(Severity severity, String summary, String detail) {
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(severity, summary, detail));
	}

	protected void showWindowDialog(String widgetVar){
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('" + widgetVar + "').show();");
	}
	
	protected void hideWindowDialog(String widgetVar){
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('" + widgetVar + "').hide();");
	}
	
	protected void addRequestParameter(String key, String value){
		FacesContext.getCurrentInstance()
        	.getExternalContext()
        	.getRequestMap()
        	.put(key, value);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	protected String getRequestParameter(String key){
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
	}
	
}
