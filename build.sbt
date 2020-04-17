name := "humm"
version := "1.0"
scalaVersion := "2.11.12"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.5",
  "org.apache.spark" %% "spark-sql" % "2.4.5",
  "org.apache.hadoop" % "hadoop-client" % "3.2.1",
  "org.apache.hadoop" % "hadoop-hdfs" % "3.2.1",
  "org.apache.hadoop" % "hadoop-azure" % "3.2.1",
  "org.apache.hadoop" % "hadoop-common" % "3.2.1",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.10.1",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.10.1"
)
dependencyOverrides += "com.google.guava" % "guava" % "27.0-jre"