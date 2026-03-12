package br.com.clinicacheckup.appcheckup.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Garante que o Flyway execute as migrations ANTES que o JPA/Hibernate
 * tente validar o schema. Necessário no Spring Boot 4.x.
 *
 * Usa BeanDefinitionRegistryPostProcessor para injetar a dependência
 * diretamente na definição do bean entityManagerFactory, antes de
 * qualquer instanciação.
 */
@Configuration
public class FlywayConfig {

    /**
     * Bean Flyway que executa as migrations ao ser inicializado.
     */
    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();
    }

    /**
     * Post-processor que adiciona "flyway" como dependência do
     * entityManagerFactory, garantindo a ordem correta de criação.
     */
    @Bean
    public static BeanDefinitionRegistryPostProcessor flywayJpaOrderEnforcer() {
        return new BeanDefinitionRegistryPostProcessor() {
            @Override
            public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
                if (registry.containsBeanDefinition("entityManagerFactory")) {
                    BeanDefinition beanDef = registry.getBeanDefinition("entityManagerFactory");
                    beanDef.setDependsOn("flyway");
                }
            }

            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
                // Não é necessário alterar nada aqui
            }
        };
    }
}
