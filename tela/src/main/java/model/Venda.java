/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author henri
 */
@Entity
public class Venda implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private int idVenda;
    
    // Relacionamento com Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "idPessoa")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "entregador_id", referencedColumnName = "idPessoa")
    private Entregador entregador;
    
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    
    @OneToOne
    private ItemPedido items;
}
