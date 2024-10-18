/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author henri
 */
public class GenericDAO {

    public GenericDAO() {
    }
    
    public void inserir(Object obj) throws HibernateException {
        Session sessao = null;

        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();

            sessao.save(obj);
            
            sessao.close();
        } catch (HibernateException ex){
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
    }
    
        public void excluir(Object obj) throws HibernateException {
        Session sessao = null;

        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();

            sessao.delete(obj);
            
            sessao.close();
        } catch (HibernateException ex){
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
    }
        
        public void alterar(Object obj) throws HibernateException {
        Session sessao = null;

        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();

            sessao.update(obj);

            sessao.close();
        } catch (HibernateException ex){
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
    } 
    
    public List listar(Class classe) throws HibernateException {
        Session sessao = null;
        List lista = null;
        
        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();

            CriteriaQuery consulta = sessao.getCriteriaBuilder().createQuery(classe);
            consulta.from(classe);
            lista = sessao.createQuery(consulta).getResultList();

            sessao.close();
        } catch (HibernateException ex){
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
    }     
}
