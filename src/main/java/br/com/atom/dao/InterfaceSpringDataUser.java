package br.com.atom.dao;

import br.com.atom.model.UsuarioSpringData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {

    @Query(value = "select u from UsuarioSpringData u where u.nome like %?1%")
    public List<UsuarioSpringData> buscaPorNome(String nome);

    @Transactional(readOnly = true) /* ReadOnly define que o metodo sera APENAS LEITURA */
    @Query(value = "select u from UsuarioSpringData u where u.nome = :paramnome")
    public UsuarioSpringData buscaPorNomeParam(@Param("paramnome") String paramnome);

    @Modifying
    @Transactional
    @Query(value = "delete from UsuarioSpringData u where u.nome = ?1")
    public void deletePorNome(String nome);

    @Modifying
    @Transactional
    @Query(value = "update UsuarioSpringData u set u.email = ?1 where u.nome = ?2")
    public void updateEmailPorNome(String email, String nome);
}
