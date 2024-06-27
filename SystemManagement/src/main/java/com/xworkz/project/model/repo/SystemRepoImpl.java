package com.xworkz.project.model.repo;

import com.xworkz.project.dto.SystemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class SystemRepoImpl implements SystemRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public SystemRepoImpl() {
        System.out.println("running constr for SystemRepoImpl class");
    }

    //saveAndvalidation for systemManagement
    @Override
    public boolean saveAndValidation(SystemDto dto) {
        System.out.println("saveAndValidation method in saveAndValidation");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(dto);
            // entityManager.merge(dto);
            entityTransaction.commit();
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public SystemDto findByPassword(String email, String password) {
        System.out.println("findByPassword method in SystemRepoImpl");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            String query = "Select sys from SystemDto sys where sys.email=:email AND sys.password=:password";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("email", email);
            query1.setParameter("password", password);
            SystemDto dto = (SystemDto) query1.getSingleResult();
            System.out.println(dto);
            // entityManager.merge(dto);
            entityTransaction.commit();
            return dto;
        } catch (Exception exception) {
            exception.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }
    
}
