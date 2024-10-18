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
public class Acai implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private int idAcai;
    
    @ManyToOne
    @JoinColumn(name = "idTamanho")
    private Tamanho tam;
    private String[] frutas;
    private String[] acompanhamentos;

    public Acai(){
    }
    
    public Acai(Tamanho tam, String[] frutas, String[] acompanhamentos) {
        this.tam = tam;
        this.frutas = frutas;
        this.acompanhamentos = acompanhamentos;
    }  
}
