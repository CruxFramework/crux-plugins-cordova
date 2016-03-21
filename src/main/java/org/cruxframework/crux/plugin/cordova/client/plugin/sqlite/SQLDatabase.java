/*
 * Copyright 2013 cruxframework.org.
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

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;


/**
 * @author Thiago da Rosa de Bustamante
 *
 */
@JsType
public class SQLDatabase 
{
	public native void transaction(SQLTransactionCallback transactionCallback, 
								   SQLTransactionErrorCallback transactionErrorCallback, 
								   SQLTransactionEndCallback successCallback);
	
	public native void readTransaction(SQLTransactionCallback transactionCallback, 
									   SQLTransactionErrorCallback transactionErrorCallback, 
									   SQLTransactionEndCallback successCallback);

	public native void changeVersion(int oldVersion, int newVersion, 
									SQLTransactionCallback transactionCallback, 
									SQLTransactionErrorCallback transactionErrorCallback, 
									SQLTransactionEndCallback successCallback);
	
	@JsProperty
	public native int getVersion();
	
	@JsFunction
	public static interface SQLTransactionCallback
	{
		void onTransaction(SQLTransaction tx);
	}
	
	@JsFunction
	public static interface SQLTransactionErrorCallback
	{
		void onError(SQLError error);
	}
	
	@JsFunction
	public static interface SQLTransactionEndCallback
	{
		void onSuccess();
	}
}
