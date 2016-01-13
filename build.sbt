name := """vaadin-sbt-template"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

resolvers += "Vaadin-addons" at "http://maven.vaadin.com/vaadin-addons"

libraryDependencies ++= Seq(
  "com.vaadin" % "vaadin-server" % "7.6.0",
  "com.vaadin" % "vaadin-client" % "7.6.0",
  "com.vaadin" % "vaadin-client-compiler" % "7.6.0",
  "com.vaadin" % "vaadin-client-compiled" % "7.6.0",
  "com.vaadin" % "vaadin-themes" % "7.6.0",
//  "com.vaadin.addon" % "vaadin-charts" % "2.1.3",
//  "com.vaadin.addon" % "vaadin-spreadsheet" % "1.1.1",
  "org.vaadin.addons" % "scaladin" % "3.1.0",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",
  "com.typesafe.play" % "play-ws_2.11" % "2.4.6"
)

vaadinThemes := Seq("apptheme")

lazy val root = project.in(file(".")).enablePlugins(JettyPlugin).settings(vaadinWebSettings :_*).settings(
	javaOptions in compileVaadinWidgetsets := Seq("-Xss8M", "-Xmx512M", "-XX:MaxPermSize=512M"),
	vaadinWidgetsets in compileVaadinWidgetsets := Seq("com.eyewyre.AppWidgetSet"),
	skip in compileVaadinWidgetsets in resourceGenerators := true,
	vaadinThemes := Seq("apptheme")
)
