package org.progchen.SurveyZone.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * �����action����,ר�����ڼ̳�
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>,
		Preparable {

	private static final long serialVersionUID = 1L;

	public void prepare() throws Exception {
	}

	public abstract T getModel();
}
