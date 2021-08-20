package ru.netology.rest.repo;

import org.springframework.stereotype.Repository;
import ru.netology.rest.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private Authorities authorities;

    Authorities write = Authorities.WRITE;
    Authorities read = Authorities.READ;
    Authorities delete = Authorities.DELETE;

    /*Добрый вечер! А в чем, собственно, вопрос? Насчёт getUserAuthorities-это метод,
     который должен вернуть список разрешений, проверив что пользователь существует.
     Если не существует, то вернуть null. Там нет какого то скрытого смысла, просто вам нужно заполнить класс с этим методом тестовыми данными,
     чтобы можно было проверить работоспособность вашего кода.*/

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user != null & password != null) {
            List<Authorities> authoritiesList = new ArrayList<>();
            authoritiesList.add(write);
            authoritiesList.add(delete);
            authoritiesList.add(read);
            return authoritiesList;
        }
        else return null;
    }
}
