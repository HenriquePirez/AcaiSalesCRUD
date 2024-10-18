/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ClienteDAO;
import dao.ConexaoHibernate;
import dao.EnderecoDAO;
import dao.EntregadorDAO;
import dao.GenericDAO;
import java.util.List;
import model.Cliente;
import model.Endereco;
import model.Entregador;
import model.Pessoa;
import org.hibernate.HibernateException;

/**
 *
 * @author henri
 */
public class GerenciadorDominio {
   
    private ClienteDAO cliDao;
    private EntregadorDAO entDao;
    private EnderecoDAO endDao;
    GenericDAO dao = new GenericDAO();
    
    
    public GerenciadorDominio() {
        ConexaoHibernate.getSessionFactory().openSession();
        
        cliDao = new ClienteDAO();
        entDao = new EntregadorDAO();
    }
    
    public List listar(Class classe) throws HibernateException {
        return dao.listar(classe);
    }
    
    public Cliente inserirCliente (String nome, String telefone, char sexo, String cpf, String bairro, String rua, int numero){
        
        Cliente cli = new Cliente( nome,  telefone,  sexo,  cpf,  bairro,  rua,  numero);
        cliDao.inserir(cli);
        
        this.inserirEndereco(bairro, rua, numero, cli);
        
        return cli;
        
    }
    
    public Entregador inserirEntregador (String nome, String telefone){
        Entregador ent = new Entregador(nome, telefone);
        entDao.inserir(ent);
        return ent;
        
    } 

    public Endereco inserirEndereco (String bairro, String rua, int numero, Pessoa pessoa){
        Endereco end = new Endereco( bairro,  rua,  numero);
        end.setPessoa(pessoa);
        endDao.inserir(end);
        
        return end;
        
    }
    
    
}
