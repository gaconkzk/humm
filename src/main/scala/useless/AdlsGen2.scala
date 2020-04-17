***REMOVED***

***REMOVED***

***REMOVED***
***REMOVED***

***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
    s"spark.hadoop.fs.azure.account.key.$ACCOUNT_NAME_SRC.dfs.core.windows.net" -> "***REMOVED***",
    s"spark.hadoop.fs.azure.account.key.$ACCOUNT_NAME_DST.dfs.core.windows.net" -> "***REMOVED***"
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
//***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
//***REMOVED***

***REMOVED***
    val sparkApp = SparkSession.builder().master("local[*]").appName("useless")
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
***REMOVED***
  sc.textFile(s"$ADLS_GEN2_URL_SRC/README.md")
      .saveAsSingleTextFile(s"$ADLS_GEN2_URL_DST/README_bk.md")

***REMOVED***
***REMOVED***
