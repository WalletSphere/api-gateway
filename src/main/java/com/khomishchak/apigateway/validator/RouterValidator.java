package com.khomishchak.apigateway.validator;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    // TODO: update logic flow for APIs list
    //  create an logic where we will save hash of secret keys in db where admin via separate APIs in backoffice:
    //   /balances/transactions/history
    public static final List<String> openApiEndpoints = List.of(
            "/auth/register", "/auth/login", "/auth/token", "/users", "/users/authenticate", "/exchangers/used-currencies",
            "/balances/history/transactions/amount"
    );

    public Predicate<ServerHttpRequest> isPublicEndpoint =
            request -> openApiEndpoints.stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
