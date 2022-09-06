package com.cepsearch;

import com.cepsearch.client.CepSearchClient;
import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.impl.TechnicalException;
import com.cepsearch.model.cep.CepModel;
import com.cepsearch.model.cep.Coordinates;
import com.cepsearch.model.cep.Location;
import com.cepsearch.cep.CepSearchService;
import feign.FeignException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CepSearchAPITest {

    @Mock
    private CepSearchClient cepSearchClient;

    @InjectMocks
    private CepSearchService cepSearchService;

    @Test
    public void test_return_cep_response_when_service_returns_success() {

        String cep = "01021200";

        when(cepSearchClient.findByCep(cep)).thenReturn(
                CepModel.builder()
                        .cep(cep)
                        .state("SP")
                        .city("São Paulo")
                        .neighborhood("Centro")
                        .street("Rua Vinte e Cinco de Março")
                        .location(Location.builder()
                                .type("Point")
                                .coordinates(Coordinates.builder()
                                        .latitude("-23.5355466")
                                        .longitude("-46.2215631")
                                        .build())
                                .build())
                        .build()
        );

        CepModel response = cepSearchService.findAddressByCep(cep);

        assertEquals(cep, response.getCep());
        assertEquals("SP", response.getState());
        assertEquals("São Paulo", response.getCity());
        assertEquals("Centro", response.getNeighborhood());
        assertEquals("Rua Vinte e Cinco de Março", response.getStreet());
        assertEquals("Point", response.getLocation().getType());
        assertEquals("-23.5355466", response.getLocation().getCoordinates().getLatitude());
        assertEquals("-46.2215631", response.getLocation().getCoordinates().getLongitude());

    }

    @Test(expected = NotFoundException.class)
    public void test_return_not_found_execption_when_service_no_find_cep() {

        when(cepSearchClient.findByCep(anyString())).thenThrow(FeignException.NotFound.class);
        CepModel response = cepSearchService.findAddressByCep(anyString());

    }

    @Test(expected = TechnicalException.class)
    public void test_return_technical_execption_when_service_returns_error() {

        when(cepSearchClient.findByCep(anyString())).thenThrow(IllegalArgumentException.class);
        CepModel response = cepSearchService.findAddressByCep(anyString());

    }

}
