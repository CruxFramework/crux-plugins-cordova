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
package org.cruxframework.crux.plugin.cordova.client.sqlite;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Thiago da Rosa de Bustamante
 */
@JsType
public class SQLError
{
	public static final short UNKNOWN_ERR = 0;
	public static final short DATABASE_ERR = 1;
	public static final short VERSION_ERR = 2;
	public static final short TOO_LARGE_ERR = 3;
	public static final short QUOTA_ERR = 4;
	public static final short SYNTAX_ERR = 5;
	public static final short CONSTRAINT_ERR = 6;
	public static final short TIMEOUT_ERR = 7;

	@JsProperty
	public native short getCode();
	
	@JsProperty
	public native String getMessage();
}
