import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "soma2"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
        "org.json" % "json" % "20090211",
        "mysql" % "mysql-connector-java" % "5.1.21"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
