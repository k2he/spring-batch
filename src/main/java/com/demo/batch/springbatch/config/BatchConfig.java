package com.demo.batch.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import com.demo.batch.springbatch.batch.OrderJobListener;
import com.demo.batch.springbatch.batch.order.MoveStageToOrderAndBackupTasklet;
import com.demo.batch.springbatch.batch.stage.DataCleaningTasklet;
import com.demo.batch.springbatch.batch.stage.OrderStageProcessor;
import com.demo.batch.springbatch.batch.stage.OrderStageReader;
import com.demo.batch.springbatch.batch.stage.OrderStageWriter;
import com.demo.batch.springbatch.batch.stage.SchemaValidationTasklet;
import com.demo.batch.springbatch.dto.OrderList.Order;
import com.demo.batch.springbatch.model.OrderStage;
import com.demo.batch.springbatch.util.BatchConstants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableBatchProcessing
@Configuration
public class BatchConfig {

  @NonNull
  private JobBuilderFactory jobBuilderFactory;

  @NonNull
  private StepBuilderFactory stepBuilderFactory;

  @NonNull
  private SchemaValidationTasklet schemaValidationTasklet;

  @NonNull
  private TaskExecutor taskExecutor;
  
  @NonNull
  private DataCleaningTasklet dataCleaningTasklet;

  @NonNull
  private OrderStageReader orderStageReader;

  @NonNull
  private OrderStageProcessor orderStageProcessor;

  @NonNull
  private OrderStageWriter orderStageWriter;

  @NonNull
  private MoveStageToOrderAndBackupTasklet moveStageToOrderAndBackupTasklet;
  
  @NonNull
  private OrderJobListener orderJobListener;
  
  @NonNull
  private AppProperties appProperties;

  @Bean(name = "orderLoadJob")
  public Job orderLoadJob() {
    Job job = jobBuilderFactory.get(BatchConstants.ORDER_PROCESS_JOB)
        .incrementer(new RunIdIncrementer())
        .listener(orderJobListener)
        .start(step1())
        .next(step2())
        .next(step3())
        .next(step4())
        .build();
    return job;
  }


  // Validate Schema
  @Bean
  protected Step step1() {
    return stepBuilderFactory.get(BatchConstants.BATCH_STEP_1).tasklet(schemaValidationTasklet)
        .build();
  }

  // Clean Existing data in Stage table
  @Bean
  protected Step step2() {
    return stepBuilderFactory.get(BatchConstants.BATCH_STEP_2).tasklet(dataCleaningTasklet)
        .build();
  }

  // Parse XML, Convert to OrderStage and save into Stage table
  @Bean
  public Step step3() {
    Step step = stepBuilderFactory.get(BatchConstants.BATCH_STEP_3)
        .<Order, OrderStage>chunk(appProperties.getFileBatchSize())
        .reader(orderStageReader)
        .processor(orderStageProcessor)
        .writer(orderStageWriter)
        .taskExecutor(taskExecutor)
        .throttleLimit(appProperties.getThreadpoolSize())
        .build();
    return step;
  }

  // Copy OrderStage data into Order table and then move old data into OrderHistory table
  @Bean
  public Step step4() {
    return stepBuilderFactory.get(BatchConstants.BATCH_STEP_4)
        .tasklet(moveStageToOrderAndBackupTasklet).build();
  }
}
