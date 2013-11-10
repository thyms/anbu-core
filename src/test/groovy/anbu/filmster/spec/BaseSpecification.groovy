package anbu.spec

import groovyx.net.http.RESTClient
import spock.lang.Specification

class BaseSpecification extends Specification {
  static ConfigObject config = initializeConfig()
  static RESTClient core = new RESTClient(config.core.baseUrl)

  private static ConfigObject initializeConfig() {
    return new ConfigSlurper(System.getProperty('test.env')).parse(configFileUrl)
  }

  private static URL getConfigFileUrl() {
    File file = new File('./src/test/groovy/anbu/spec/Config.groovy')
    if (!file.exists()) { // This check is done for tests run on IDE
      file = new File('./core-functional/src/test/groovy/anbu/spec/Config.groovy')
    }

    return file.toURI().toURL()
  }
}
