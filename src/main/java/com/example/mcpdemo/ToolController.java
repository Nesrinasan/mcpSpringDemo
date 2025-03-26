package com.example.mcpdemo;

import io.modelcontextprotocol.client.McpSyncClient;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mcp")
@RestController
public class ToolController {
    public final ChatClient.Builder builder;
    private final McpSyncClient mcpSyncClient;

    public ToolController(ChatClient.Builder builder, McpSyncClient mcpSyncClient) {
        this.builder = builder;
        this.mcpSyncClient = mcpSyncClient;
    }


    @GetMapping("/greeting")
    public languageFile greeting(){
        var mcpClientProvider = new SyncMcpToolCallbackProvider(mcpSyncClient);
        builder.defaultTools(mcpClientProvider);
        var prompt = """
				what files are in the language folder, and of those files, Which word in these files is used to greet in English??
				""";
        return this.builder.build().prompt(prompt).call().entity(languageFile.class);
    }


    @GetMapping("/setAlarm")
    public String setAlarm(){
        var mcpClientProvider = new SyncMcpToolCallbackProvider(mcpSyncClient);
        builder.defaultTools(mcpClientProvider);
        var prompt = """
				"Can you set an alarm 10 minutes from now?"
				""";
        return this.builder.build().prompt(prompt).call().content();
    }


}
