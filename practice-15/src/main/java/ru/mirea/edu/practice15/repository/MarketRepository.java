package ru.mirea.edu.practice15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.edu.practice15.model.Market;

@Repository
public interface MarketRepository extends JpaRepository<Market, String> {
}
