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
package org.cruxframework.crux.plugin.cordova.client.plugin.sqlite;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Thiago da Rosa de Bustamante
 */
public class SQLRow extends JavaScriptObject
{
	protected SQLRow() {}
	
	public final native String getString(String key)/*-{
	    return this[key]; 
	}-*/;

	public final native int getInt(String key)/*-{
	    return this[key]; 
	}-*/;

	public final native JavaScriptObject getObject(String key)/*-{
	    return this[key]; 
	}-*/;


	public final native double getDouble(String key)/*-{
	    return this[key]; 
	}-*/;

	public final native boolean hasKey(String key)/*-{
	    return !!this[key]; 
	}-*/;
}
