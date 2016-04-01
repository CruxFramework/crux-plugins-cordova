/*
 * Copyright 2016 cruxframework.org.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.cruxframework.crux.plugin.cordova.client;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.user.client.Timer;

/**
 * Cordova integration plugin. Before use any cordova feature, you must call
 * Cordova.init() to load cordova into your page.
 * @author Thiago da Rosa de Bustamante
 */
public class Cordova
{
	private static boolean initialized = false;
	private static Cordova instance = new Cordova();
	private static final int TIMEOUT = 1000;
	private static Timer timeoutTimer;
	private Plugins plugins = new Plugins();
	
	protected Cordova()
    {
    }
	
	public Plugins getPlugins()
	{
		return plugins;
	}
	
	/**
	 * Initialize Cordova
	 */
	public static void init(CordovaAvailableCallback callback)
	{
		if (!initialized)
		{
			startTimeoutTimer(callback);
			initializeListener(instance, callback);
			injectCordovaScript();
			initialized = true;
		}
		else
		{
			callback.onCordovaAvailable(instance);
		}
	}

	public native void exitApp()/*-{
		$wnd.navigator.app.exitApp();	
	}-*/;
	
	public native void addBackPressedListener(EventCallback callback) /*-{
	  	$doc.addEventListener("backbutton", $entry(function() 
		{
	    	callback.@org.cruxframework.crux.plugin.cordova.client.Cordova.EventCallback::onEvent()();
	  	}), false);
	}-*/;
	
	private static native void initializeListener(Cordova cordova, CordovaAvailableCallback callback) /*-{
	  	$doc.addEventListener("deviceready", $entry(function() 
		{
	    	@org.cruxframework.crux.plugin.cordova.client.Cordova::stopTimeoutTimer()();
	    	callback.@org.cruxframework.crux.plugin.cordova.client.Cordova.CordovaAvailableCallback::onCordovaAvailable(Lorg/cruxframework/crux/plugin/cordova/client/Cordova;)(cordova);
	  	}), false);
	}-*/;
	
	private static void injectCordovaScript()
	{
		ScriptInjector.fromUrl("cordova.js").setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

	private static void startTimeoutTimer(final CordovaAvailableCallback callback)
	{
		timeoutTimer = new Timer()
		{
			@Override
			public void run()
			{
				callback.onError();
			}
		};
		timeoutTimer.schedule(TIMEOUT);
	}
	
	private static void stopTimeoutTimer()
	{
		if (timeoutTimer != null)
		{
			timeoutTimer.cancel();
			timeoutTimer = null;
		}
	}
	
	/**
	 * A callback interface to be called when cordova is initialized
	 * @author Thiago da Rosa de Bustamante
	 *
	 */
	public interface CordovaAvailableCallback  
	{
		void onCordovaAvailable(Cordova cordova);
		void onError();
	}
	
	/**
	 * A Cordova event callback
	 * @author Thiago da Rosa de Bustamante
	 *
	 */
	public interface EventCallback  
	{
		void onEvent();
	}

	public static class Plugins
	{
		private Plugins() {}
		
		/**
		 * Verify if Google Analytics plugin is supported.
		 * @return
		 */
		public final native boolean isGoogleAnalyticsSupported()/*-{
			var analyticsSupport = !!$wnd.analytics;
			return analyticsSupport;
		}-*/;
		
		/**
		 * Verify if SQLite plugin is supported.
		 * @return
		 */
		public final native boolean isSQLiteSupported()/*-{
			var sqlsupport = !!$wnd.sqlitePlugin;
			return sqlsupport;
		}-*/;
		
	}
}
