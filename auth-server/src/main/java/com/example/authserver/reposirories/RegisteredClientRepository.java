package com.example.authserver.reposirories;

import jakarta.annotation.Nullable;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

public interface RegisteredClientRepository {


    @Nullable
    RegisteredClient findById(String clientId);
    @Nullable
    RegisteredClient findByClientId(String clientId);
}
