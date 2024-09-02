package br.com.techbrasilia.webfluxcourse.service;

import br.com.techbrasilia.webfluxcourse.entity.User;
import br.com.techbrasilia.webfluxcourse.mapper.UserMapper;
import br.com.techbrasilia.webfluxcourse.model.request.UserRequest;
import br.com.techbrasilia.webfluxcourse.repository.UserRepository;
import br.com.techbrasilia.webfluxcourse.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    public Mono<User> save(final UserRequest request) {
       return repository.save(mapper.toEntity(request));
    }

    public Mono<User> findById(final String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(
                        new ObjectNotFoundException(
                                format("Object Not found. Id %s type: %s", id, User.class)
                        )
                ));
    }
}
