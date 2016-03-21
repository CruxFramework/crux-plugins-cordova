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
package org.cruxframework.crux.plugin.cordova.client.plugin.ga;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * This requires the https://github.com/danwilson/google-analytics-plugin
 * cordova plugin.
 * 
 * @author Thiago da Rosa de Bustamante
 */
@JsType(namespace=JsPackage.GLOBAL, name="analytics")
public class GoogleAnalytics
{
	private GoogleAnalytics(){}
	
	public static native void addCustomDimension(String key, String value, SuccessCallback success, ErrorCallback error);

	public static native void addTransaction(String ID, String affiliation, double revenue, double tax, double shipping, String currencyCode);
	
	public static native void addTransactionItem(String ID, String name, String sku, String category, double price, int quantity, String currencyCode);

	public static native void debugMode();

	public static native void enableUncaughtExceptionReporting(boolean enabled, SuccessCallback success, ErrorCallback error);
	
	public static native void setUserId(String userId);
	
	public static native void startTrackerWithId(String key);
	
	public static native void trackEvent(String category, String action);
	
	public static native void trackEvent(String category, String action, String label);
	
	public static native void trackEvent(String category, String action, String label, double value);
	
	public static native void trackException(String description, boolean fatal);
	
	public static native void trackTiming(String category, int intervalInMilliseconds, String variable, String label);
	
	public static native void trackView(String pageView);
	
	@JsFunction
	public static interface ErrorCallback
	{
		void onError();
	}
	
	@JsFunction
	public static interface SuccessCallback
	{
		void onSuccess();
	}
}
