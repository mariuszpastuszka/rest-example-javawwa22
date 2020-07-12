package pl.sda.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class MoneyNBPReader {

    MoneyNBPReader(@Value("${corona.status.acive}") String coronaActive) {
        log.info("corona.status.acive: [{}]", coronaActive);
        // myParam - odczytany z konfiguracji -yaml
        // możliwość podania jako argument wywołania
        // corona.status.acive
        // CORONA_ACTIVE
    }
}
