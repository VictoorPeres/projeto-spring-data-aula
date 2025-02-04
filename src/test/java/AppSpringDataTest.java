import br.com.atom.dao.InterfaceSpringDataUser;
import br.com.atom.model.UsuarioSpringData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})

public class AppSpringDataTest {

    @Autowired
    private InterfaceSpringDataUser interfaceSpringDataUser;

    @Test
    public void testInsert() {
        UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
        usuarioSpringData.setEmail("javaavancado@javaavancado.com");
        usuarioSpringData.setIdade(31);
        usuarioSpringData.setLogin("teste 123");
        usuarioSpringData.setPassword("123");
        usuarioSpringData.setNome("Victor Oliveira");

        interfaceSpringDataUser.save(usuarioSpringData);
    }
}
