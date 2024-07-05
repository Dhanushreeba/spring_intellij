package com.xworkz.project.model.repo;

import com.xworkz.project.dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class SignUpRepoImpl implements SignUpRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public SignUpRepoImpl() {
        System.out.println("running constr for SignUpRepoImpl class");
    }

    //saveAndvalidation for systemManagement
    @Override
    public boolean saveAndValidation(SignUpDto dto) {
        System.out.println("saveAndValidation method in saveAndValidation");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
             entityManager.merge(dto);
            entityTransaction.commit();
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public SignUpDto findByEmailAndPassword(String email, String password) {
        System.out.println("findByEmailAndPassword method in SignUpRepoImpl");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();

        try {
            entityTransaction.begin();
           String query = "Select sys from SignUpDto sys where sys.email=:email AND sys.password=:password";
            Query query1=entityManager.createQuery(query);
            query1.setParameter("email", email);
            query1.setParameter("password", password);
            SignUpDto dto=(SignUpDto) query1.getSingleResult();
            System.out.println(dto);
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

    //login lock
    @Override
    public SignUpDto findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("select sys from SignUpDto sys where email=:email");
            query.setParameter("email", email);

            List<SignUpDto> resultList = query.getResultList();
            if (resultList.isEmpty()) {
                System.out.println("No result found for email :"+email);
                return null;
            } else if (resultList.size() == 1) {
                return resultList.get(0);
            } else {
                throw new NonUniqueResultException("Multiple results found for email: " + email);
            }
        } catch (NoResultException e) {
            return null;
        } finally {
            entityManager.close();
        }
    }

    //lock
    @Override
    public boolean update(SignUpDto dto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.merge(dto);
            entityTransaction.commit();
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

//    @Override
//    public SystemDto existsByEmail(String email) {
//
//            EntityManager entityManager = entityManagerFactory.createEntityManager();
//            try {
//                Query query2 = entityManager.createQuery("select sys from SystemDto sys where sys.email=:email ");
//                query2.setParameter("email", email);
//                System.out.println("Running");
//                SystemDto dto = (SystemDto) query2.getSingleResult();
//                return dto;
//            } catch (PersistenceException persistenceException) {
//                persistenceException.printStackTrace();
//            } finally {
//                entityManager.close();
//            }
//            return null;
//        }

   // if email saved then it should come as email exists
    @Override
    public SignUpDto existsByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query2 = entityManager.createQuery("select sys from SignUpDto sys where sys.email=:email ");
            query2.setParameter("email", email);
            System.out.println("Running extitsByEmail method in SignUpRepoImpl");
            return (SignUpDto) query2.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

//    @Override
//    public SignUpDto existsByContactNumber(Long contactNumber) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        try {
//            Query query = entityManager.createQuery("select sys from SignUpDto sys where sys.contactNumber=:contactNumber ");
//            query.setParameter("contactNumber", contactNumber);
//            System.out.println("Running existsByContactNumber method in SignUpRepoImpl");
//            return (SignUpDto) query.getSingleResult();
//        } catch (NoResultException noResultException) {
//            return null;
//        } catch (PersistenceException persistenceException) {
//            persistenceException.printStackTrace();
//        } finally {
//            entityManager.close();
//        }
//        return null;
//    }

    //if contact saved then it should come as contact exists
    @Override
    public SignUpDto existsByContactNumber(Long contactNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("select sys from SignUpDto sys where sys.contactNumber=:contactNumber ");
            query.setParameter("contactNumber", contactNumber);
            System.out.println("Running existsByContactNumber method in SignUpRepoImpl");
            return (SignUpDto) query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
//
//    @Override
//    public SignUpDto lookByEmail(String email) {
//        System.out.println("lookByEmail method in SignUpRepoImpl");
//        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction=entityManager.getTransaction();
//
//        try {
//            entityTransaction.begin();
//            String query = "Select sys from SignUpDto sys where sys.email=:email";
//            Query query1=entityManager.createQuery(query);
//            query1.setParameter("email", email);
//            SignUpDto dto=(SignUpDto) query1.getSingleResult();
//            System.out.println(dto);
//            entityTransaction.commit();
//            return dto;
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            entityTransaction.rollback();
//        } finally {
//            entityManager.close();
//        }
//        return null;
//    }

    //forget password
    @Override
    public SignUpDto lookByEmail(String email) {
        System.out.println("lookByEmail method in SignUpRepoImpl");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();

        try {
            entityTransaction.begin();
            Query query2 = entityManager.createQuery("select s from SignUpDto s where s.email=:email ");
            query2.setParameter("email", email);
            System.out.println("Running lookByEmail method in SignUpRepoImpl");
            entityTransaction.commit();
            return (SignUpDto) query2.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }


}

