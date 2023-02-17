package pl.brzezins.app.batch;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBatchConfigTest {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job sampleJob;

    @Test
    public void sampleJobCompletesSuccessfully() throws Exception {
        JobExecution jobExecution = jobLauncher.run(sampleJob, new JobParameters());

        assertThat(jobExecution.getExitStatus()).isEqualTo(ExitStatus.COMPLETED);
    }
}