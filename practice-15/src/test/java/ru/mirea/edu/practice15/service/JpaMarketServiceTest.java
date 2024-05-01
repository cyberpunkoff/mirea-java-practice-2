package ru.mirea.edu.practice15.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.edu.practice15.model.Market;
import ru.mirea.edu.practice15.repository.MarketRepository;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class JpaMarketServiceTest {
    @Mock
    private MarketRepository marketRepository;
    @Mock
    private EmailService emailService;
    @Captor
    ArgumentCaptor<Market> captor;

    private MarketService marketService;

    @BeforeEach
    void setup() {
        marketService = new JpaMarketService(marketRepository, emailService);
    }

    @Test
    void getAllMarketsTest() {
        Market market1 = new Market();
        market1.setName("first");
        Market market2 = new Market();
        market2.setName("second");

        when(marketRepository.findAll()).thenReturn(List.of(market1, market2));

        MarketService marketService = new JpaMarketService(marketRepository, emailService);

        assertThat(marketService.getAllMarkets()).isEqualTo(List.of(market1, market2));
    }

    @Test
    void getAllMarketTest() {
        Market market1 = new Market();
        market1.setName("first");
        Market market2 = new Market();
        market1.setName("second");

        when(marketRepository.findById("first")).thenReturn(Optional.of(market1));

        assertThat(marketService.getMarket("first")).isEqualTo(market1);
    }

    @Test
    void addMarketTest() {
        Market market1 = new Market();
        market1.setName("first");

        when(marketRepository.save(any())).thenReturn(market1);

        marketService.addMarket(market1);

        Mockito.verify(marketRepository).save(captor.capture());
        Market market = captor.getValue();

        assertThat(market).isEqualTo(market1);
    }
}
