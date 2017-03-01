package com.sentinels.kwd.engine.cmd.context;

import java.util.HashMap;

public class SessionContext {
	
	private SessionContext(){
		parameters = new HashMap<String, String>();
	}
	
	public static SessionContext INSTANCE = null;

    public static synchronized SessionContext getInstance() {
        if(INSTANCE == null)
            return new SessionContext();

        return INSTANCE;
    }
    
    public static synchronized SessionContext reBuildInstance() {
        if(INSTANCE == null){
            return new SessionContext();
        }else{
        	INSTANCE.parameters.clear();
        }
        return INSTANCE;
    }

    private HashMap<String, String> parameters = null;
    
    public void add(String index, String value){
    	parameters.put(index, value);
    }
    
    public String get(String index){
    	return parameters.get(index);
    }
    
    public boolean exists(String index){
    	return parameters.containsKey(index);
    }


}
