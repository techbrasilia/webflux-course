package br.com.techbrasilia.webfluxcourse.service;

import br.com.techbrasilia.webfluxcourse.entity.User;
import br.com.techbrasilia.webfluxcourse.mapper.UserMapper;
import br.com.techbrasilia.webfluxcourse.model.request.UserRequest;
import br.com.techbrasilia.webfluxcourse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    public Mono<User> save(final UserRequest request) {
       return repository.save(mapper.toEntity(request));
    }
}
