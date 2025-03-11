package br.com.atom.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tipo;
    @Column(nullable = false)
    private String numero;
    @ManyToOne(optional = false)
    private UsuarioSpringData usuarioSpringData;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public UsuarioSpringData getUsuarioSpringData() {
        return usuarioSpringData;
    }

    public void setUsuarioSpringData(UsuarioSpringData usuarioSpringData) {
        this.usuarioSpringData = usuarioSpringData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
