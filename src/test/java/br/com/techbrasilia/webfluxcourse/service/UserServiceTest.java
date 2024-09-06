package br.com.techbrasilia.webfluxcourse.service;

import br.com.techbrasilia.webfluxcourse.entity.User;
import br.com.techbrasilia.webfluxcourse.mapper.UserMapper;
import br.com.techbrasilia.webfluxcourse.model.request.UserRequest;
import br.com.techbrasilia.webfluxcourse.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;
    @Mock
    private UserMapper mapper;

    @InjectMocks
    private UserService service;

    @Test
    void save() {
        UserRequest request = new UserRequest("fabio", "techbrasilia@outlook.com", "12222");
        User entity = User.builder().build();
        when(mapper.toEntity(any(UserRequest.class))).thenReturn(entity);
        when(repository.save(any(User.class))).thenReturn(Mono.just(User.builder().build()));

        Mono<User> result = service.save(request);

        StepVerifier.create(result)
                .expectNextMatches(Objects::nonNull) //ou: expectNextMatches(user -> user != null)
                .expectComplete()
                .verify();

        //Teste Mockito: verifica se repository foi chamado 1 vez
        Mockito.verify(repository, times(1)).save(any(User.class));
    }
}