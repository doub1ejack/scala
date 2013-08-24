import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "scala"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "org.mongodb" % "casbah_2.10" % "2.6.2",
    "com.novus" % "salat-core_2.10" % "1.9.2",
    "se.radley" %% "play-plugins-salat" % "1.2"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here     
    routesImport += "se.radley.plugin.salat.Binders._",
    templatesImport += "org.bson.types.ObjectId",
    resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/" 
  )

}
