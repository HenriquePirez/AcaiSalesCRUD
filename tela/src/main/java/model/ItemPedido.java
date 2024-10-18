/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author henri
 */

@Entity
public class ItemPedido {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private int idItemsPedido;
    
    @ManyToOne
    @JoinColumn(name = "idAcai")
    private Acai acai;
}
