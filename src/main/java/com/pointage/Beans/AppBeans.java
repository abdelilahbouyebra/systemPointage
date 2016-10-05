package com.pointage.Beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.pointage.Utils.MyUtil;

@ManagedBean
@ApplicationScoped
public class AppBeans {

	public AppBeans() {
	}

	public String getUrlBase() {
		return MyUtil.Urlbase();
	}

	public String getUrlPatBase() {
		return MyUtil.UrlPatBas();

	}

}
