***REMOVED***

import java.io.IOException

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.azurebfs.AzureBlobFileSystem
import org.apache.hadoop.fs.{FileSystem, Path***REMOVED***
import org.apache.hadoop.io.IOUtils
import org.apache.hadoop.io.compress.CompressionCodec
import org.apache.spark.rdd.RDD

import scala.util.Try

object SparkHelper {
  implicit class RDDExtensions(val rdd: RDD[String]) extends AnyVal {
    def saveAsSingleTextFile(path: String): Unit = saveAsSingleTextFileInternal(path, None)

    def saveAsSingleTextFile(path: String, codec: Class[_ <: CompressionCodec]): Unit =
      saveAsSingleTextFileInternal(path, Some(codec))

    private def saveAsSingleTextFileInternal(
      path: String, codec: Option[Class[_ <: CompressionCodec]]
  ***REMOVED***: Unit = {
      val hdfs = new AzureBlobFileSystem()
      hdfs.initialize(new Path(path).getParent.toUri, rdd.sparkContext.hadoopConfiguration)

      hdfs.delete(new Path(s"$path.tmp"), true)
      codec match {
        case Some(codec) => rdd.saveAsTextFile(s"$path.tmp", codec)
        case None => rdd.saveAsTextFile(s"$path.tmp")
  ***REMOVED***

      hdfs.delete(new Path(path), true)
      copyMerge(hdfs, new Path(s"$path.tmp"),
        hdfs, new Path(path),
        deleteSource = true, rdd.sparkContext.hadoopConfiguration
    ***REMOVED***

      hdfs.delete(new Path(s"$path.tmp"), true)
***REMOVED***

    def copyMerge(
                 srcFS: FileSystem, srcDir: Path,
                 dstFS: FileSystem, dstFile: Path,
                 deleteSource: Boolean, conf: Configuration
               ***REMOVED***: Boolean = {
      if (dstFS.exists(dstFile)) {
        throw new IOException(s"Target $dstFile already exists")
  ***REMOVED***

      // Source path is expected to be a directory
      if (srcFS.getFileStatus(srcDir).isDirectory) {
        val outputFile = dstFS.create(dstFile)
        Try {
          srcFS
            .listStatus(srcDir)
            .sortBy(_.getPath.getName)
            .collect {
              case status if status.isFile =>
                val inputFile = srcFS.open(status.getPath)
                Try(IOUtils.copyBytes(inputFile, outputFile, conf, false))
                inputFile.close()
        ***REMOVED***
    ***REMOVED***
        outputFile.close()

        if (deleteSource) srcFS.delete(srcDir, true) else true
  ***REMOVED*** else false
***REMOVED***
***REMOVED***
***REMOVED***
