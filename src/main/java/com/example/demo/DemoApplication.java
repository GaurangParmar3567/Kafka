package com.example.demo;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import jakarta.annotation.PreDestroy;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	private Process zookeeperProcess;
	private Process kafkaProcess;

	public static void main(String[] args) {

		System.out.println("Gaurang Parmar");
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		startZookeeper();
		Thread.sleep(7000); // wait 5 sec for ZooKeeper to be ready
		startKafka();
	}

	private void startZookeeper() throws IOException {
		// String command = "cmd.exe /c start \"ZookeeperConsole\" cmd /k
		// \"E:\\kafka_2.13-3.3.2\\bin\\windows\\zookeeper-server-start.bat
		// E:\\kafka_2.13-3.3.2\\config\\zookeeper.properties\"";
		// zookeeperProcess = Runtime.getRuntime().exec(command);
		// System.out.println("✅ Zookeeper started in new CMD window");
	}

	private void startKafka() throws IOException, InterruptedException {
		// String command = "cmd.exe /c start \"KafkaConsole\" cmd /k
		// \"E:\\kafka_2.13-3.3.2\\bin\\windows\\kafka-server-start.bat
		// E:\\kafka_2.13-3.3.2\\config\\server.properties\"";
		// kafkaProcess = Runtime.getRuntime().exec(command);
		// Thread.sleep(5000);
		// kafkaProcess = Runtime.getRuntime().exec(command);
		// System.out.println("✅ Kafka started in new CMD window");
	}

	@PreDestroy
	public void stopKafka() throws IOException {
		// String stopCmd = "cmd.exe /c
		// \"E:\\kafka_2.13-3.3.2\\bin\\windows\\kafka-server-stop.bat\"";
		// String stopCmdZookeeper = "cmd.exe /c
		// \"E:\\kafka_2.13-3.3.2\\bin\\windows\\zookeeper-server-stop.bat\"";
		// Runtime.getRuntime().exec(stopCmd);
		// Runtime.getRuntime().exec(stopCmdZookeeper);
		// System.out.println("🛑 Shutting down Kafka & Zookeeper...");
		// // Kill the CMD windows by their titles
		// Runtime.getRuntime().exec("taskkill /FI \"WINDOWTITLE eq KafkaConsole*\" /T
		// /F");
		// Runtime.getRuntime().exec("taskkill /FI \"WINDOWTITLE eq ZookeeperConsole*\"
		// /T /F");

		System.out.println("✅ Kafka & Zookeeper stopped.");
	}
}
