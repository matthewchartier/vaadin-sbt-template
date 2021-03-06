name := """vaadin-sbt-template"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  "eyeWyre Snapshot Repo" at "http://repo.eyewyre.com:8000/repository/snapshots",
  "eyeWyre Release Repo" at "http://repo.eyewyre.com:8000/repository/releases",
  "Vaadin-addons" at "http://maven.vaadin.com/vaadin-addons"
)

libraryDependencies ++= Seq(
  "com.vaadin" % "vaadin-server" % "7.6.4",
  "com.vaadin" % "vaadin-client" % "7.6.4",
  "com.vaadin" % "vaadin-client-compiler" % "7.6.4",
  "com.vaadin" % "vaadin-client-compiled" % "7.6.4",
  "com.vaadin" % "vaadin-themes" % "7.6.4",
  "com.vaadin.addon" % "vaadin-charts" % "3.0.0",
  "com.vaadin.addon" % "vaadin-spreadsheet" % "1.1.6",
//  "com.vaadin.addon" % "vaadin-touchkit-cval" % "4.1.0",
  "org.vaadin.addons" % "scaladin" % "3.1.0",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",
  "com.typesafe.play" % "play-ws_2.11" % "2.4.6",
  "com.typesafe.play" %% "play-json" % "2.4.6",
//  "org.scalactic" %% "scalactic" % "2.2.6",
//  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.specs2" %% "specs2" % "3.7" % "test"
)

lazy val root = project.in(file(".")).enablePlugins(JettyPlugin).settings(vaadinWebSettings :_*).settings(
	javaOptions in compileVaadinWidgetsets := Seq("-Xss8M", "-Xmx512M", "-XX:MaxPermSize=512M"),
	vaadinWidgetsets in compileVaadinWidgetsets := Seq("com.eyewyre.AppWidgetSet"),
	skip in compileVaadinWidgetsets in resourceGenerators := true,
	vaadinThemes := Seq("apptheme")
)
