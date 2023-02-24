# Example of Spring Batch 5.0.0 configuration

A minimal reproducible example of [Spring Batch issue](https://github.com/spring-projects/spring-batch/issues/4306).

The expectation is [SpringBatchConfigTest.java](https://github.com/mbrzez/spring-batch-init-db-tables/blob/main/src/test/java/pl/brzezins/app/batch/SpringBatchConfigTest.java) creates [metatables](https://docs.spring.io/spring-batch/docs/current/reference/html/schema-appendix.html) when job is launched and property `initialize-schema: always` is set

Test will pass when `@EnableBatchProcessing` is removed. Since 5.0.0 the following annotation should be used to tell the [auto-configuration to back off](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Migration-Guide#spring-batch-changes), that allows the application to take complete control of how Batch is configured.

Please see [Spring Batch 5.0 Migration Guide](https://github.com/spring-projects/spring-batch/wiki/Spring-Batch-5.0-Migration-Guide)
