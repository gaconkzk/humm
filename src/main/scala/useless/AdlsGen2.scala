package useless

import java.util.Collections

import org.apache.spark.sql.SparkSession
import useless.SparkHelper.RDDExtensions

object AdlsGen2 extends App {
  println("starting things that not worked")
  def getEnv(envName: String) = Option(sys.env(envName))
    .getOrElse(throw new IllegalArgumentException(s"environment $envName does not exists."))

  val ADLS_GEN2_URL_SRC = getEnv("SOURCE_FILE_URL")
  val ADLS_GEN2_URL_DST = getEnv("DESTINATION_FILE_URL")
  val AD_NAME = getEnv("APPLICATION_NAME")
  val ACCOUNT_NAME_SRC = getEnv("ACCOUNT_NAME_SRC")
  val ACCOUNT_NAME_DST = getEnv("ACCOUNT_NAME_DST")
  val ACCOUNT_SRC_KEY = getEnv("ACCOUNT_NAME_SRC_KEY")
  val ACCOUNT_DST_KEY = getEnv("ACCOUNT_NAME_DST_KEY")

  // well have to use spark and stupid hadoop
  // and need to use `spark.hadoop.` as prefix
  private val adlsConfigurationForSpark = Map(
    // This seem work
    s"spark.hadoop.fs.azure.account.auth.type" -> "SharedKey",
    s"spark.hadoop.fs.azure.account.key.$ACCOUNT_NAME_SRC.dfs.core.windows.net" -> ACCOUNT_SRC_KEY,
    s"spark.hadoop.fs.azure.account.key.$ACCOUNT_NAME_DST.dfs.core.windows.net" -> ACCOUNT_DST_KEY
  )
  // Using OAuth is forbidden because MS don't let me see the `manifest` section when configure
  // application like their guide for rich users
  // YOU NEEEEEEEED MONEYYYYY
//  private val adlsConfigurationForSpark = Map(
//      s"spark.hadoop.fs.azure.account.auth.type" -> "OAuth",
//      s"spark.hadoop.fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
//      s"spark.hadoop.fs.azure.account.oauth2.client.endpoint" -> AZ_AD_ENDPOINT,
//      s"spark.hadoop.fs.azure.account.oauth2.client.id" -> AD_APP_ID,
//      s"spark.hadoop.fs.azure.account.oauth2.client.secret" -> AD_APP_SECRET
//  )

  val spark: SparkSession = {
    val sparkApp = SparkSession.builder().master("local[*]").appName(AD_NAME)
    for ((key, value) <- adlsConfigurationForSpark) {
      sparkApp.config(key, value)
    }
    sparkApp.getOrCreate()
  }

  val sc = spark.sparkContext
  // copy from src to dst
  sc.textFile(s"$ADLS_GEN2_URL_SRC")
      .saveAsSingleTextFile(s"$ADLS_GEN2_URL_DST")

  spark.close()
}
