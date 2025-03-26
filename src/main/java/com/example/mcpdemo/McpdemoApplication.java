package com.example.mcpdemo;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
public class McpdemoApplication {

	static final String FOLDER = "/Users/nasan/Downloads/mcpdemo/src/main/resources/language";
	public static void main(String[] args) {
		SpringApplication.run(McpdemoApplication.class, args);
	}

}
//@Configuration
//class ThirdPArtyConfiguration{
//
//	@Bean
//	McpSyncClient mcpSyncClient(){
//		System.out.println("mcpSyncClient girdi");
//
//		var mcp =  McpClient.sync(new HttpClientSseClientTransport("http://localhost:8087")).build();
//
//		mcp.initialize();
//		return mcp;
//
//	}
//
//	@Bean
//	NamedMcpClientRunner namedMcpClientRunner(ChatClient.Builder builder, McpSyncClient mcpSyncClient) {
//		System.out.println("namedMcpClientRunner girdi");
//
//		var mcpClientProvider = new SyncMcpToolCallbackProvider(mcpSyncClient);
//
//		return new NamedMcpClientRunner(builder.defaultTools(mcpClientProvider));
//	}
//}

//
//@Configuration
//class ThirdPArtyConfiguration{

//
//	@Bean
//	NamedMcpClientRunner namedMcpClientRunner(ChatClient.Builder builder, McpSyncClient mcpSyncClient) {
//		var tools = new SyncMcpToolCallbackProvider(mcpSyncClient);
//
//		return new NamedMcpClientRunner(builder.defaultTools(tools));
//	}
//
//	@Bean
//	McpSyncClient mcpSyncClient(@Value("/Users/nasan/Downloads/mcpdemo/src/main/resources/language") File root){
//		var stdioParameters = ServerParameters.builder("npx").args("-y","@modelcontextprotocol/server-filesystem", root.getAbsolutePath())
//				.build();
//
//		var mcp = McpClient.sync(new StdioClientTransport(stdioParameters))
//				.requestTimeout(Duration.ofMinutes(1)).build();
//		mcp.initialize();
//		return mcp;
//	}
//}
//
//
//@Configuration
//class LocalToolsAutoConfiguration {
//
//	@Component
//	static class Tools{
//		@Tool(description = "returns all the txt files names in the folder a called " + McpdemoApplication.FOLDER)
//		String [] listFiles(){
//			System.out.println("listing files: " + McpdemoApplication.FOLDER);
//			return new java.io.File(McpdemoApplication.FOLDER).list();
//		}
//
//	}
//
//	@Bean
//	NamedMcpClientRunner namedMcpClientRunner(ChatClient.Builder builder, Tools tools) {
//		return new NamedMcpClientRunner(builder.defaultTools(tools));
//	}
//
//
//}

//class NamedMcpClientRunner implements ApplicationRunner, BeanNameAware{
//
//	public final ChatClient.Builder builder;
//	private final AtomicReference<String> beanName = new AtomicReference<>();
//
//	NamedMcpClientRunner(ChatClient.Builder builder) {
//		this.builder = builder;
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("run girdi");
////		var prompt = """
////				what files are in the language folder, and of those files, Which word in these files is used to greet in English??
////				""";
////		languagesFile response = this.builder.build().prompt(prompt).call().entity(languagesFile.class);
////		var prompt = """
////				"Can you set an alarm 10 minutes from now?"
////				""";
////		String  response = this.builder.build().prompt(prompt).call().content();
////
////		System.out.println(this.beanName.get() + ": " +  response);
//
//	}
//
//	@Override
//	public void setBeanName(String name) {
//		this.beanName.set(name);
//
//	}
//}
//
//record languagesFile(List<String> fileNames, String word){}