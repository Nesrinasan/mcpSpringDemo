package com.example.mcpdemo;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdPartyConfig {

    @Bean
    McpSyncClient mcpSyncClient(){

        var mcp =  McpClient.sync(new HttpClientSseClientTransport("http://localhost:8087")).build();

        mcp.initialize();
        return mcp;

    }
}
