package model;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author henri
 */



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn  ( name="tipo_pessoa",
                       discriminatorType = DiscriminatorType.INTEGER )
@DiscriminatorValue("0")
public abstract class Pessoa implements java.io.Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Integer idPessoa;  
    
    @Column ( name="nomePessoa", length = 200 )
    String nome;
    
    @Column ( name="telefone" )
     String telefone;
    
    @Column ( length = 1 )
    private char sexo;
    
    @Column ( updatable = false, length = 14 )
    private String cpf;
    
    @OneToOne( mappedBy="pessoa", fetch=FetchType.LAZY)
    private Endereco endereco;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Venda> vendasComoCliente;

    @OneToMany(mappedBy = "entregador", fetch = FetchType.LAZY)
    private List<Venda> vendasComoEntregador;

    //Para HIBERNATE
    public Pessoa(){        
    }
    
    public Pessoa(String nome, String telefone, char sexo, String cpf, String bairro, String rua, int numero) {
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.cpf = cpf;
        this.endereco = new Endereco(bairro, rua, numero);
        this.endereco.setPessoa(this);
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
