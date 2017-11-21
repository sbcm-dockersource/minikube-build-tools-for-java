/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.tools.crepecake.json;

import com.google.cloud.tools.crepecake.image.Digest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/** Interface to a custom {@link Gson} JSON parser. */
public class JsonParser {
  private static final Gson GSON;

  static {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Digest.class, new DigestSerializer());
    gsonBuilder.registerTypeAdapter(Digest.class, new DigestDeserializer());
    GSON = gsonBuilder.create();
  }

  public static String toJson(Object src) {
    return GSON.toJson(src);
  }

  public static <T> T fromJson(String json, Class<T> classOfT) {
    return GSON.fromJson(json, classOfT);
  }
}
