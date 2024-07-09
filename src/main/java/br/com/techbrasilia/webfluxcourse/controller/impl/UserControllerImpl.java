package br.com.techbrasilia.webfluxcourse.controller.impl;

import br.com.techbrasilia.webfluxcourse.controller.UserController;
import br.com.techbrasilia.webfluxcourse.model.request.UserRequest;
import br.com.techbrasilia.webfluxcourse.model.response.UserResponse;
import br.com.techbrasilia.webfluxcourse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserControllerImpl implements UserController {

    private final UserService service;
    @Override
    public ResponseEntity<Mono<Void>> save(final UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(userRequest).then());
    }

    @Override
    public ResponseEntity<Mono<UserResponse>> find(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Flux<UserResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Mono<UserResponse>> update(String id, UserRequest userRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Mono<Void>> delete(String id) {
        return null;
    }
}
