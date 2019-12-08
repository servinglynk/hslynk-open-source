package com.servinglynk.hmis.file.export;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


// tag::setup[]
@Configuration
@EnableBatchProcessing
public class BatchConfiguration extends DefaultBatchConfigurer {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    // end::setup[]
    

//    @Autowired
//    public PersonReader personReader;

//    
    @Autowired
    public PersonItemProcessor personItemProcessor;
    
    @Bean(destroyMethod = "")
    public JdbcCursorItemReader<User> reader(){
	     JdbcCursorItemReader<User> reader = new JdbcCursorItemReader<User>();
	     reader.setDataSource(dataSource());
	     reader.setSql("SELECT first_name,last_name FROM base.hmis_user");
	     reader.setRowMapper(new RowMapper<User>() {
	            @Override
	            public User mapRow(ResultSet rs, int i) throws SQLException {
	                return new User(rs.getString("first_name"), rs.getString("last_name"));
	            }
	        });
	     return reader;
	    }
    
    
    
    @Bean
	public FlatFileItemWriter<User> writer(){
	     FlatFileItemWriter<User> writer = new FlatFileItemWriter<User>();
//	     writer.setResource(new ClassPathResource("users.csv"));
	     writer.setResource(new FileSystemResource("users.csv"));
	     writer.setLineAggregator(new DelimitedLineAggregator<User>() {{
	      setDelimiter(",");
	      setFieldExtractor(new BeanWrapperFieldExtractor<User>() {{
	       setNames(new String[] { "lastName", "firstName" });
	      }});
	     }});
	     
	     return writer;
	    }
    
    @Bean
    public DataSource dataSource() {
     final DriverManagerDataSource dataSource = new DriverManagerDataSource();
     dataSource.setDriverClassName("org.postgresql.Driver");
     dataSource.setUrl("jdbc:postgresql://localhost:5432/hmis");
     dataSource.setUsername("postgres");
     dataSource.setPassword("postgres");
     return dataSource;
    }
    


    @Bean
    public Step step1() {
     return stepBuilderFactory.get("step1").<User, User> chunk(10)
       .reader(reader())
       .processor(personItemProcessor)
       .writer(writer())
       .build();
    }
    
    @Bean
    public Job exportUserJob() {
     return jobBuilderFactory.get("exportUserJob")
       .incrementer(new RunIdIncrementer())
       .flow(step1())
       .end()
       .build();
    }
    
    @Override
    protected JobRepository createJobRepository() throws Exception {
        MapJobRepositoryFactoryBean factoryBean = new MapJobRepositoryFactoryBean();
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    
    
    // end::jobstep[]
}
