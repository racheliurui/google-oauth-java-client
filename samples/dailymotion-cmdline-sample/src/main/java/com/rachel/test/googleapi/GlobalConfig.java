/*
 * Copyright (c) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.rachel.test.googleapi;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Rachel@google.com (Your Name Here)
 *
 */
public class GlobalConfig {

  private static final java.io.File DATA_STORE_DIR =
      new java.io.File(System.getProperty("user.home"), ".store/googleDataStore");


  public static File getDataStoreDir() {

    return DATA_STORE_DIR;

  }


  public static String getConfig(String configName) {
    String configFile = DATA_STORE_DIR + "/config.json";

    try {
      String configString = new String(Files.readAllBytes(Paths.get(configFile)));


      JSONObject jsonConfig = new JSONObject(configString);
      return jsonConfig.optString(configName);
    } catch (IOException e) {

      return null;
    }



  }

}
