package com.xworkz.project.model.repo;

import com.xworkz.project.dto.SystemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

@Repository
public class SystemRepoImpl implements SystemRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public SystemRepoImpl(){
        System.out.println("running constr for SystemRepoImpl class");
    }

    //saveAndvalidation for systemManagement
    @Override
    public boolean saveAndValidation(SystemDto dto) {
        System.out.println("saveAndValidation method in saveAndValidation");
        EntityManager entityManager=this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();

        try{
            entityTransaction.begin();
            entityManager.persist(dto);
           // entityManager.merge(dto);
            entityTransaction.commit();
        }
        catch (PersistenceException persistenceException){
                persistenceException.printStackTrace();
                entityTransaction.rollback();
        }
        finally {
            entityManager.close();
        }
        return true;
    }
}
