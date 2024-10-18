package model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
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
@DiscriminatorValue("2")
public class Entregador extends Pessoa implements Serializable{

    public Entregador() {
    }

    public Entregador(String nome, String telefone){
        super.nome = nome;
        super.telefone = telefone;
    }
    
    public Entregador(String nome, String telefone, char sexo, String cpf, String bairro, String rua, int numero) {
        super(nome, telefone, sexo, cpf, bairro, rua, numero);
    }
    
}
