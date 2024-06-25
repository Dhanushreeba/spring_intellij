package com.xworkz.people.model.repository;

import com.xworkz.people.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class PeopleRepoImpl implements PeopleRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public PeopleRepoImpl() {
        System.out.println("constr of PeopleRepoImpl class");
    }

    @Override
    public boolean saveAndValidation(ContactDto dto) {
        System.out.println("saveAndValidation method from PeopleRepoImpl class");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            //  entityManager.persist(dto);//it will do only insert
            entityManager.merge(dto);// it will do insert and update both
            entityTransaction.commit();


        } catch (PersistenceException persistenceException) {

            persistenceException.printStackTrace();
            entityTransaction.rollback();

        } finally {

            entityManager.close();
        }

        return true;
    }

    //contact search
    @Override
    public List<ContactDto> search(ContactSearchDto searchDto) {


        System.out.println("Running search method in SearchRepoImpl ");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();


        try {
            String query = "select dto from ContactDto dto where dto.name=:cname";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("cname", searchDto.getName());
            List<ContactDto> resultList = query1.getResultList();

            entityTransaction.commit();
            return resultList;
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        return Collections.emptyList();


    }

    //country
    @Override
    public boolean saveAndValidation(CountryDto countryDto) {
        System.out.println("saveAndValidation method from PeopleRepoImpl class");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
//            entityManager.persist(countryDto);
            entityManager.merge(countryDto); // we use for insert and update(2 in 1)

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
    public List<CountryDto> search(CountrySearchDto countrySearchDto) {
        System.out.println("Running search method in SearchRepoImpl ");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();


        try {
            String query = "select dto from CountryDto dto where dto.capitalCity=:city";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("city", countrySearchDto.getCapitalCity());
            List<CountryDto> resultList = query1.getResultList();

            entityTransaction.commit();
            return resultList;

        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        return Collections.emptyList();

    }

    @Override
    public boolean saveAndValidation(PrimeMinisterDto pMSearchDto) {
        System.out.println("saveAndValidation method from PeopleRepoImpl class");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            // entityManager.persist(pMSearchDto);
            entityManager.merge(pMSearchDto);
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
    public List<PrimeMinisterDto> search(PrimeMinisterSearchDto pMSearchDto) {
        System.out.println("Running search method in SearchRepoImpl ");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();


        try {
            String query = "select dto from PrimeMinisterDto dto where dto.name=:name";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("name", pMSearchDto.getName());
            List<PrimeMinisterDto> resultList = query1.getResultList();

            entityTransaction.commit();
            return resultList;

        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        return Collections.emptyList();
    }


    //Edit
    @Override
    public ContactDto findById(int id) {
        System.out.println("Running findById method in PeopleRepoImpl of contact of edit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            String query = "SELECT dto FROM ContactDto dto WHERE dto.id = :cid";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("cid", id);
            ContactDto singleResult = (ContactDto) query1.getSingleResult();
            entityTransaction.commit();
            return singleResult;

        } catch (PersistenceException persistenceException) {

            persistenceException.printStackTrace();
            entityTransaction.rollback();

        } finally {
            entityManager.close();
        }

        return PeopleRepo.super.findById(id);
    }

    //country edit
    @Override
    public CountryDto findByServiceId(int id) {
        System.out.println("Running findById method in PeopleRepoImpl of country edit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            String query = "select dto from CountryDto dto where dto.id= :coid";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("coid", id);
            CountryDto countryDto = (CountryDto) query1.getSingleResult();
            entityTransaction.commit();
            return countryDto;
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        return PeopleRepo.super.findByServiceId(id);
    }

    //prime
    @Override
    public PrimeMinisterDto findId(int id) {

        System.out.println("Running findById method in PeopleRepoImpl of primeMinister edit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            String query = "SELECT dto FROM PrimeMinisterDto dto WHERE dto.id = :pid";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("pid", id);
            PrimeMinisterDto singleResult = (PrimeMinisterDto) query1.getSingleResult();
            entityTransaction.commit();
            return singleResult;

        } catch (PersistenceException persistenceException) {

            persistenceException.printStackTrace();
            entityTransaction.rollback();

        } finally {
            entityManager.close();
        }
        return PeopleRepo.super.findId(id);
    }


    //Delete
    //Contact

    @Override
    public ContactDto deleteById(int id) {
        System.out.println("Running deleteById method in PeopleRepoImpl of contact of delete");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            // Fetch the entity to be deleted
            ContactDto contactDto = entityManager.find(ContactDto.class, id);
            if (contactDto == null) {
                throw new EntityNotFoundException("No contact found with id " + id);
            }

            // Delete the entity
            String query = "DELETE FROM ContactDto WHERE id = :contactid";
            Query deleteQuery = entityManager.createQuery(query);
            deleteQuery.setParameter("contactid", id);
            deleteQuery.executeUpdate();
            entityTransaction.commit();

        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
            
        } finally {
            entityManager.close();
        }
        return PeopleRepo.super.deleteById(id);
    }
}




//    @Override
//    public ContactDto deleteById(int id) {
//        System.out.println("Running deleteById method in PeopleRepoImpl of contact of delete");
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction=entityManager.getTransaction();
//        entityTransaction.begin();
//
//        try{
//            String query="Delete from ContactDto  where id=:contactid";
//             Query query1= entityManager.createQuery(query);
//             query1.setParameter("contactid",id);
//             ContactDto singleResult= (ContactDto) query1.getSingleResult();
//             entityTransaction.commit();
//             return singleResult;
//        }
//        catch (PersistenceException persistenceException){
//            persistenceException.printStackTrace();
//            entityTransaction.rollback();
//        }
//        finally {
//            entityManager.close();
//        }
//        return PeopleRepo.super.deleteById(id);
//    }
//}

//MobileDto mobileDto = entityManager.find(MobileDto.class, id);
//        entityTransaction.begin();
//
//        if (mobileDto != null) {
//        System.out.println("delete successful");
//            entityManager.remove(mobileDto);
//            entityTransaction.commit();
