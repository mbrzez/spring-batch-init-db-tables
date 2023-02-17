package pl.brzezins.app.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    @Bean
    public Job sampleJob(JobRepository jobRepository, Step sampleStep) {
        return new JobBuilder("sample-job", jobRepository)
                .start(sampleStep)
                .build();
    }

    @Bean
    public Step sampleStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("sample-step", jobRepository)
                .tasklet((contribution, chunkContext) -> RepeatStatus.FINISHED, transactionManager)
                .build();
    }
}
