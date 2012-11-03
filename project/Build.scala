import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "soma2"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
        "org.json" % "json" % "20090211"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
