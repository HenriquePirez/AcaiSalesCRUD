/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author henri
 */
@Entity
public class Tamanho implements Serializable{
    
    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY );
    private int idTam;
    
    private int tamanho;
    private int preco;

    public Tamanho(){        
    }
    
    public Tamanho(int tamanho, int preco) {
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
    
   
}
