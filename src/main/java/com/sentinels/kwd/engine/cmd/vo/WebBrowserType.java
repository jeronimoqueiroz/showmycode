package com.sentinels.kwd.engine.cmd.vo;

public enum WebBrowserType {

	FIREFOX("FIREFOX"), 
	CHROME("CHROME"), 
	INTERNET_EXPLORER("INTERNET_EXPLORER");

	private final String stringValue;

	WebBrowserType(final String s) {
		stringValue = s;
	}
	
	public static WebBrowserType buildType(String type){

        for (WebBrowserType item : WebBrowserType.values()) {
            if (item.toString().equals(type) ) {
                return item;
            }
        }
        return null;
    }


	public String toString() {
		return stringValue;
	}

}
