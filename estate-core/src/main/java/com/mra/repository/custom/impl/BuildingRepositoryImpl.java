package com.mra.repository.custom.impl;

import com.mra.entity.BuildingEntity;
import com.mra.repository.custom.BuildingRepositoryCustom;
import com.mra.repository.paging.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(Pageable pageable) {

        StringBuilder sql = new StringBuilder(" FROM BuildingEntity ");
        Query query = entityManager.createQuery(sql.toString());
        if (pageable.getOffset() != null) {
            query.setFirstResult(pageable.getOffset());
        }
        if (pageable.getPageSize() != null) {
            query.setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }

    @Override
    public Long getTotalItems() {
        StringBuilder sql = new StringBuilder("select count(*) from BuildingEntity");
        Query query = entityManager.createQuery(sql.toString());
        return (Long) query.getResultList().get(0);
    }
}
