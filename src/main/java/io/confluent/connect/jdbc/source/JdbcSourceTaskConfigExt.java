/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.connect.jdbc.source;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;

import java.util.Map;

/**
 * Configuration options for a single JdbcSourceTask. These are processed after all
 * Connector-level configs have been parsed.
 */
public class JdbcSourceTaskConfigExt extends JdbcSourceConnectorConfig {

  public static final String TABLES_CONFIG = "tables";
  private static final String TABLES_DOC = "List of tables for this task to watch for changes.";
  public static final String AUTO_STOP_CONFIG = "auto.stop";
  private static final String AUTO_STOP_DOC = "Automatically stop connector task (sleep infinite) "
          + "when there is no more data to read from source. "
          + "Only applicable for bulk mode.";

  static ConfigDef config = baseConfigDef()
          .define(TABLES_CONFIG, Type.LIST, Importance.HIGH, TABLES_DOC)
          .define(AUTO_STOP_CONFIG, Type.BOOLEAN, Importance.MEDIUM, AUTO_STOP_DOC);

  public JdbcSourceTaskConfigExt(Map<String, String> props) {
    super(config, props);
  }
}
