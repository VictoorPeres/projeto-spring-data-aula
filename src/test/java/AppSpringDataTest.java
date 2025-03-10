import br.com.atom.dao.InterfaceSpringDataUser;
import br.com.atom.model.UsuarioSpringData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})

public class AppSpringDataTest {

    @Autowired
    private InterfaceSpringDataUser interfaceSpringDataUser;

    @Test
    public void testeInsert() {
        UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
        usuarioSpringData.setEmail("javaavancado@javaavancado.com");
        usuarioSpringData.setIdade(31);
        usuarioSpringData.setLogin("teste 123");
        usuarioSpringData.setPassword("123");
        usuarioSpringData.setNome("Victor Oliveira");

        interfaceSpringDataUser.save(usuarioSpringData);
    }

    @Test
    public void testeConsulta(){
        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
        System.out.println("Nome: " + usuarioSpringData.get().getNome());
        System.out.println("Email: " + usuarioSpringData.get().getEmail());
        System.out.println("Login: " + usuarioSpringData.get().getLogin());
        System.out.println("Idade: " + usuarioSpringData.get().getIdade());
    }

    @Test
    public void testeConsultaAll(){
        Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();

        for (UsuarioSpringData usuarioSpringData : lista) {
            System.out.println("-----------------------------------------------");
            System.out.println("Nome: " + usuarioSpringData.getNome());
            System.out.println("Email: " + usuarioSpringData.getEmail());
            System.out.println("Login: " + usuarioSpringData.getLogin());
            System.out.println("Idade: " + usuarioSpringData.getIdade());
        }
    }

    @Test
    public void testeUpdate(){
        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
        UsuarioSpringData data = usuarioSpringData.get();

        data.setNome("Alexandre Peres");

        interfaceSpringDataUser.save(data);
    }

    @Test
    public void testeDelete(){
        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
        UsuarioSpringData data = usuarioSpringData.get();
        interfaceSpringDataUser.delete(data);

    }

    @Test
    public void testeDeleteById(){
        interfaceSpringDataUser.deleteById(1L);
    }

    @Test
    public void testeConsultaNome(){
        List<UsuarioSpringData> lista = interfaceSpringDataUser.buscaPorNome("Victor");

        for (UsuarioSpringData usuarioSpringData : lista) {
            System.out.println("----------------------------------------");
            System.out.println("Id: " + usuarioSpringData.getId());
            System.out.println("Nome: " + usuarioSpringData.getNome());

        }
    }

    @Test
    public void testeConsultaNomeParam(){
        UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("Victor Oliveira");
        System.out.println("Nome: " + usuarioSpringData.getId());
        System.out.println("Nome: " + usuarioSpringData.getNome());
    }

    @Test
    public void testeDeletePorNome(){
        interfaceSpringDataUser.deletePorNome("Victor Oliveira");
    }

    @Test
    public void testeUpdateEmailPorNome(){
        interfaceSpringDataUser.updateEmailPorNome("victor@gmail.com", "Alexandre Peres");
    }
}
