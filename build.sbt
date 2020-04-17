name := "humm"
version := "1.0"
scalaVersion := "2.11.12"
libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.4.5",
  "org.apache.spark" % "spark-sql_2.11" % "2.4.5",
  "org.apache.spark" % "spark-streaming_2.11" % "2.4.5",
  "org.apache.spark" % "spark-mllib_2.11" % "2.4.5",
  "org.apache.hadoop" % "hadoop-client" % "3.2.1",
  "org.apache.hadoop" % "hadoop-hdfs" % "3.2.1",
  "org.apache.hadoop" % "hadoop-azure" % "3.2.1",
  "org.apache.hadoop" % "hadoop-common" % "3.2.1",
  "com.microsoft.azure" % "msal4j" % "1.4.0",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.10.1",
  "com.azure" % "azure-identity" % "1.0.4",
  "com.azure" % "azure-storage-file-datalake" % "12.1.0",
  "org.jmockit" % "jmockit" % "1.34" % "test"
)
dependencyOverrides += "com.google.guava" % "guava" % "27.0-jre"