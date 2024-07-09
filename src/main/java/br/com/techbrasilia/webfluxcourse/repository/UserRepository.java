package br.com.techbrasilia.webfluxcourse.repository;

import br.com.techbrasilia.webfluxcourse.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final ReactiveMongoTemplate monoTemplate;

    public Mono<User> save(final User user) {
        return monoTemplate.save(user);
    }
}
