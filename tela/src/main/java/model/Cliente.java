package model;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author henri
 */

@Entity
@DiscriminatorValue("1")
public class Cliente extends Pessoa implements Serializable{

    public Cliente(String nome1, String telefone, char sexo, String cpf, String bairro, String rua, int numero) {
    }

    public Cliente(String nome, String telefone, char sexo, String cpf, String bairro, String rua, int numero, String cidade, String uf) {
        super(nome, telefone, sexo, cpf, bairro, rua, numero);
    }
    
    
}
