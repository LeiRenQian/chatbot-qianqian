package com.csust.ai;

import java.io.IOException;

public interface IOpenAI {
    String doChatGPT(String Question) throws IOException;
}
