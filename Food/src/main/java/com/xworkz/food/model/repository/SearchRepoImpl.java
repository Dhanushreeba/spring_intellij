package com.xworkz.food.model.repository;

import com.xworkz.food.dto.FoodOrderDto;
import com.xworkz.food.dto.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class SearchRepoImpl implements SearchRepo{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public SearchRepoImpl()
    {
        System.out.println("Created SearchRepoImpl");
    }

    @Override
    public List<FoodOrderDto> search(SearchDto searchDto) {

        System.out.println("Running search method in SearchRepoImpl ");
        EntityManager entityManager =this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction =entityManager.getTransaction();
        entityTransaction.begin();


        try {
            String query="select dto from FoodOrderDto dto where dto.orderSelection=:type";
            Query query1 =entityManager.createQuery(query);
            query1.setParameter("type",searchDto.getName());
            List<FoodOrderDto> resultList=query1.getResultList();

            entityTransaction.commit();
            return  resultList;
        }
        catch (PersistenceException persistenceException)
        {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
        }
        finally {
            entityManager.close();
        }

        return Collections.emptyList();


        }
}
