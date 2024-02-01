//package com.tm30.softposclient.configuration.analytics;
//
//import com.tm30.softposclient.SoftposclientApplication;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.sql.SparkSession;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//
//@Configuration
//public class SparkConfiguration {
//
//	@Bean
//	public SparkConf sparkConf(){
//
//		return new SparkConf()
//				.setAppName(SoftposclientApplication.class.getSimpleName())
//				.setMaster("local");
//	}
//
//	@Bean
//	public JavaSparkContext javaSparkContext() {
//		return new JavaSparkContext(sparkConf());
//	}
//
//	@Bean
//	public SparkSession sparkSession() {
//		return SparkSession
//				.builder()
//				.sparkContext(javaSparkContext().sc())
//				.appName(SoftposclientApplication.class.getSimpleName())
//				.master("local")
//				.getOrCreate();
//	}
//
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
//
//}
